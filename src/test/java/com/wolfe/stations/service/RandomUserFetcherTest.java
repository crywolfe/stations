package com.wolfe.stations.service;

import com.wolfe.stations.models.User;
import com.wolfe.stations.parser.JsonParser;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class RandomUserFetcherTest {

    private static final String URL_FOR_TWO = "https://randomuser.me/api/?seed=foobar&results=2";
    private static final String SEED = "foobar";
    private static final String RESULTS = "2";

    @Mock URLConnection connection;
    @Mock InputStream in;
    @Mock User user;

    @InjectMocks
    RandomUserFetcher randomUserFetcher;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        URL url = new URL(URL_FOR_TWO);

        connection = url.openConnection();
        in = connection.getInputStream();

        when(user.getGender()).thenReturn("female");
    }

    @AfterEach
    void teardown() throws IOException {
        in.close();
    }

    @Test
    void buildUrlTest() throws MalformedURLException {
        String expectedUrl = "https://randomuser.me/api/?results=2&seed=foobar";
        URL actualUrl = randomUserFetcher.buildUrl(SEED, RESULTS);
        assertEquals(expectedUrl, actualUrl.toString());
    }

    @Test
    void fetchUsersTest() throws IOException {

        List<String> expected = Lists.newArrayList(user.getGender());

        JsonParser parser = new JsonParser();
        List<String> actual = Lists.newArrayList(parser.parseJsonForUser(in).getGender());

        assertEquals(expected, actual);
    }

    @Test
    void fetchUserTest() throws IOException {

        String expected = user.getGender();

        JsonParser parser = new JsonParser();
        String actual = parser.parseJsonForUser(in).getGender();

        assertEquals(expected, actual);    }
}

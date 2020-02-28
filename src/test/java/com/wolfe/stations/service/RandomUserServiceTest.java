package com.wolfe.stations.service;

import com.wolfe.stations.models.User;
import com.wolfe.stations.parser.JsonParser;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class RandomUserServiceTest {

    @Mock private User user;
    @Mock private RandomUserFetcher randomUserFetcher;

    private static final String SEED = "foobar";
    private static final String RESULTS = "1";
    private static final String USERNAME = "LASVEGAS2020";


    @InjectMocks private RandomUserService randomUserService;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);

        JsonParser parser = new JsonParser();
        FileInputStream in = new FileInputStream("src/main/resources/static/JsonTestExample.json");
        user = parser.parseJsonForUser(in);
    }

    @Test
    void getUsersTest() throws IOException {

        when(randomUserFetcher.fetchUsers(SEED, RESULTS)).thenReturn(Lists.newArrayList(user));
        List<User> expected = Lists.newArrayList(user);
        List<User> actual = randomUserService.getAllUsers(SEED, RESULTS);

        assertEquals(expected, actual);
    }

    @Test
    void getUserTest() throws IOException {

        when(randomUserFetcher.fetchUser(SEED, RESULTS)).thenReturn(user);
        User expected = user;
        Optional<User> optionalActual = randomUserService.getUserByUsername(USERNAME, SEED, RESULTS);
        User actual = new User();
        if (optionalActual.isPresent()) {
            actual = optionalActual.get();
        }

        assertEquals(expected, actual);
    }
}

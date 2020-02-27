package com.wolfe.stations.service;

import com.wolfe.stations.business.RandomUserBO;
import com.wolfe.stations.models.Login;
import com.wolfe.stations.models.Name;
import com.wolfe.stations.models.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class RandomUserBOTest {

    @Mock RandomUserService randomUserService;
    @Mock User user1;
    @Mock User user2;
    @Mock Name name1;
    @Mock Name name2;
    @Mock Login login1;
    @Mock Login login2;

    private static final String SEED = "foobar";
    private static final String RESULTS = "2";
    private static final String LASVEGAS2020 = "lasvegas2020";
    private static final String OTHERUSERNAME = "otherusername";

    @InjectMocks RandomUserBO randomUserBO;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        when(randomUserService.getAllUsers(SEED, RESULTS)).thenReturn(Lists.newArrayList(user1, user2));

    }

    @Test
    void getAllUsersTest() throws IOException {
        List<User> expected = Lists.newArrayList(user1, user2);
        List<User> actual = randomUserBO.getAllUsers(SEED, RESULTS);
        assertEquals(expected, actual);
    }

    @Test
    void getUsersByFirstLetterOfLastNameTest() throws IOException {
        when(user1.getName()).thenReturn(name1);
        when(name1.getLast()).thenReturn("Gonzales");
        when(user2.getName()).thenReturn(name2);
        when(name2.getLast()).thenReturn("Roberts");
        List<String> expected = Lists.newArrayList("Gonzales");
        List<User> filteredUsers = randomUserBO.getUsersByFirstLetterOfLastName("G", SEED, RESULTS);
        List<String> actual = filteredUsers.stream()
                .map((user1 -> user1.getName().getLast())).collect(Collectors.toList()); // did this so that I wouldn't need to build a large user object.
        assertEquals(expected, actual);
    }

    @Test
    void getUserByUsernameTest() throws IOException {
        when(user1.getLogin()).thenReturn(login1);
        when(user1.getLogin().getUsername()).thenReturn(OTHERUSERNAME);
        when(user2.getLogin()).thenReturn(login2);
        when(user2.getLogin().getUsername()).thenReturn(LASVEGAS2020);
        List<User> expected = Lists.newArrayList(user2);
        List<User> actual = randomUserBO.getUserByUsername(LASVEGAS2020, SEED, RESULTS);
        assertEquals(expected, actual);
    }
}

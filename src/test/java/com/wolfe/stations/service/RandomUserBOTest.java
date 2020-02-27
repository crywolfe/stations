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
import java.util.Optional;

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
        setUpUser1();
        setUpUser2();
        when(randomUserService.getAllUsers(SEED, RESULTS)).thenReturn(Lists.newArrayList(user1, user2));
    }

    void setUpUser1() {
        when(user1.getName()).thenReturn(name1);
        when(name1.getLast()).thenReturn("Gonzales");
        when(user1.getLogin()).thenReturn(login1);
        when(user1.getLogin().getUsername()).thenReturn(OTHERUSERNAME);
    }

    void setUpUser2() {
        when(user2.getName()).thenReturn(name2);
        when(name2.getLast()).thenReturn("Roberts");
        when(user2.getLogin()).thenReturn(login2);
        when(user2.getLogin().getUsername()).thenReturn(LASVEGAS2020);
    }

    @Test
    void getAllUsersTest() throws IOException {
        List<User> expected = Lists.newArrayList(user1, user2);
        List<User> actual = randomUserBO.getAllUsers(SEED, RESULTS);
        assertEquals(expected, actual);
    }

    @Test
    void getUsersByFirstLetterOfLastNameTest() throws IOException {
        List<User> expected = Lists.newArrayList(user1);
        List<User> actual = randomUserBO.getUsersByFirstLetterOfLastName("G", SEED, RESULTS);
        assertEquals(expected, actual);
    }

    @Test
    void getUserByUsernameTest() throws IOException {
        Optional<User> expected = Optional.of(Lists.newArrayList(user2).get(0));;
        Optional<User> actual = randomUserBO.getUserByUsername(LASVEGAS2020, SEED, RESULTS);
        assertEquals(expected, actual);
    }

    @Test
    void getUserByUsernameIfNoUserNameExistsTest() throws IOException {
        Optional<User> expected = Optional.empty();;
        Optional<User> actual = randomUserBO.getUserByUsername("NO_USER_NAME_EXISTS", SEED, RESULTS);
        assertEquals(expected, actual);
    }
}

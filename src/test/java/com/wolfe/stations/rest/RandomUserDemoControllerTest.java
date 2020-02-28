package com.wolfe.stations.rest;

import com.wolfe.stations.models.Login;
import com.wolfe.stations.models.Name;
import com.wolfe.stations.models.User;
import com.wolfe.stations.service.RandomUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RandomUserDemoController.class)
class RandomUserDemoControllerTest {

    @MockBean private RandomUserService randomUserService;
    @Autowired private MockMvc mockMvc;

    private static final String SEED = "foobar";
    private static final String RESULTS = "100";

    @Mock User user;
    @Mock Name name;
    @Mock Login login;

    @Test
    void getAllRandomUsers() throws Exception{
        List<User> mockRandomUsers = new ArrayList<>(0);
        when(user.getName()).thenReturn(name);
        when(name.getFirst()).thenReturn("Gerry");
        when(user.getLogin()).thenReturn(login);
        when(login.getUsername()).thenReturn("VEGAS2020");

        mockRandomUsers.add(user);

        given(randomUserService.getAllUsers(SEED, RESULTS)).willReturn(mockRandomUsers);
        this.mockMvc.perform(get("/demo/randomusers?seed=" + SEED + "&results=" + RESULTS))
                .andExpect(status().isOk());
    }
}

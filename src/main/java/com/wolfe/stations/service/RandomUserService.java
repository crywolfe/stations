package com.wolfe.stations.service;

import com.wolfe.stations.business.RandomUserBO;
import com.wolfe.stations.models.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RandomUserService {

    @Inject RandomUserFetcher randomUserFetcher;
    @Inject RandomUserBO randomUserBO;

    @Cacheable("users")
    public List<User> getAllUsers(String seed, String results) throws IOException {
        return randomUserFetcher.fetchUsers(seed, results);
    }

    public List<User> getUsersByFirstLetterLastName(String letter, String seed, String results) throws IOException {
        return randomUserBO.getUsersByFirstLetterOfLastName(letter, seed, results);
    }

    @Cacheable("user")
    public Optional<User> getUserByUsername(String username, String seed, String results) throws IOException {
        return randomUserBO.getUserByUsername(username, seed, results);
    }

}

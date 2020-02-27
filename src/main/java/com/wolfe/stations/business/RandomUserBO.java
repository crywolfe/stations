package com.wolfe.stations.business;

import com.wolfe.stations.models.User;
import com.wolfe.stations.service.RandomUserService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RandomUserBO {

    @Inject private RandomUserService randomUserService;

    public List<User> getAllUsers(String seed, String results) throws IOException {
        return randomUserService.getAllUsers(seed, results);
    }

    public List<User> getUsersByFirstLetterOfLastName(String letter, String seed, String results) throws IOException {
        List<User> users = randomUserService.getAllUsers(seed, results);
        return users.stream().filter((user -> letter.equals(String.valueOf(user.getName().getLast().charAt(0))))).collect(Collectors.toList());
    };

    public Optional<User> getUserByUsername(String userName, String seed, String results) throws IOException {
        List<User> users = randomUserService.getAllUsers(seed, results);
        List<User> filtered = users.stream().filter((user -> userName.equals(user.getLogin().getUsername()))).collect(Collectors.toList());
        if (filtered.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.of(filtered.get(0));
        }
    };
}

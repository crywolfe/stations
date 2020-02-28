package com.wolfe.stations.rest;

import com.google.common.base.Strings;
import com.wolfe.stations.models.User;
import com.wolfe.stations.service.RandomUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Api(value = "RandomUserServiceController")
@RestController
@RequestMapping(value="/api")
public class RandomUserServiceController {

    @Autowired private RandomUserService randomUserService;

    @ApiOperation(value="get all users based on seed and results params")
    @GetMapping(value="/randomusers")
    public List<User> getAllRandomUsers(@RequestParam(value="seed", required=false)String seed,
                                        @RequestParam(value="results", required=false)String results) throws IOException {
        if (Strings.isNullOrEmpty(seed)) {
            seed = "foobar";
        }
        if (Strings.isNullOrEmpty(results)) {
            results = "100";
        }
        return this.randomUserService.getAllUsers(seed, results);
    }

    @ApiOperation(value="get all users by first letter of last name")
    @GetMapping(value="/randomusersbylastname")
    public List<User> getUsersByFirstLetterLastName(@RequestParam(value="letter")String letter,
                                                    @RequestParam(value="seed", required=false)String seed,
                                                    @RequestParam(value="results", required=false)String results) throws IOException {
        if (Strings.isNullOrEmpty(seed)) {
            seed = "foobar";
        }
        if (Strings.isNullOrEmpty(results)) {
            results = "100";
        }
        return this.randomUserService.getUsersByFirstLetterLastName(letter, seed, results);
    }

    @ApiOperation(value="get user by username")
    @GetMapping(value="/randomuser")
    public Optional<User> getRandomUserByUsername(@RequestParam(value="username")String username,
                                                  @RequestParam(value="seed", required=false)String seed,
                                                  @RequestParam(value="results", required=false)String results) throws IOException {
        if (Strings.isNullOrEmpty(seed)) {
            seed = "foobar";
        }
        if (Strings.isNullOrEmpty(results)) {
            results = "100";
        }
        return this.randomUserService.getUserByUsername(username, seed, results);
    }
}

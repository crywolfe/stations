package com.wolfe.stations.rest;

import com.wolfe.stations.models.User;
import com.wolfe.stations.service.RandomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/demo")
public class RandomUserDemoController {

    @Autowired private RandomUserService randomUserService;

    @GetMapping(value="/randomusers")
    public String getAllRandomUsers(@RequestParam(value="seed", required=false)String seed,
                                    @RequestParam(value="results", required=false)String results, Model model) throws IOException {

        List<User> randomUsers = this.randomUserService.getAllUsers(seed, results);
        model.addAttribute("randomUsers", randomUsers);
        return "randomusers";
    }

    @GetMapping(value="/firstletter")
    public String getUsersByFirstLetterLastName(@RequestParam(value="letter")String letter,
                                                @RequestParam(value="seed", required=false)String seed,
                                                @RequestParam(value="results", required=false)String results, Model model) throws IOException {

        List<User> filteredRandomUsers = this.randomUserService.getUsersByFirstLetterLastName(letter, seed, results);
        model.addAttribute("filteredRandomUsers", filteredRandomUsers);
        return "filteredrandomusers";
    }

    @GetMapping(value="/byusername")
    public String getUserByUsername(@RequestParam(value="username")String username,
                                    @RequestParam(value="seed", required=false)String seed,
                                    @RequestParam(value="results", required=false)String results, Model model) throws IOException {

        Optional<User> user = this.randomUserService.getUserByUsername(username, seed, results);
        model.addAttribute("user", user);
        return "userbyusername";
    }


}

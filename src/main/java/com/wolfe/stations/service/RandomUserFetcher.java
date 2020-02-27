package com.wolfe.stations.service;

import com.wolfe.stations.models.User;
import com.wolfe.stations.parser.JsonParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Component
public class RandomUserFetcher {
    private static final String BASE_URL = "https://randomuser.me/api/?";
    private static final String RESULTS_PARAM = "results=";
    private static final String SEED_PARAM = "&seed=";

    public URL buildUrl(String seed, String results) throws MalformedURLException {
        StringBuilder urlString = new StringBuilder();
        urlString.append(BASE_URL);
        urlString.append(RESULTS_PARAM).append(results);
        urlString.append(SEED_PARAM).append(seed);

        return new URL(urlString.toString());
    }

    public List<User> fetchUsers(String seed, String results) throws IOException {
        URL url = buildUrl(seed, results);

        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();

        JsonParser parser = new JsonParser();
        List<User> result = parser.parseJsonForUsers(in);
        in.close();

        return result;
    }

    public User fetchUser(String seed, String results) throws IOException {
        URL url = buildUrl(seed, results);

        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();

        JsonParser parser = new JsonParser();
        User result = parser.parseJsonForUser(in);
        in.close();

        return result;
    }

}

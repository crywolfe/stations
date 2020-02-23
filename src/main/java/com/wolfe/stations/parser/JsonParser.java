package com.wolfe.stations.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolfe.stations.models.Results;
import com.wolfe.stations.models.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class JsonParser implements JsonParserInterface {

    @Override
    public List<User> parseJsonForUsers(InputStream in) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Results results = objectMapper.readValue(in, Results.class);

        return results.getResults();    }

    @Override
    public User parseJsonForUser(InputStream in) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Results results = objectMapper.readValue(in, Results.class);

        return results.getResults().get(0);
    }


}

package com.wolfe.stations.parser;

import com.wolfe.stations.models.Results;
import com.wolfe.stations.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface JsonParserInterface {
    List<User> parseJsonForUsers(InputStream in) throws IOException;
    User parseJsonForUser(InputStream in) throws IOException;
}

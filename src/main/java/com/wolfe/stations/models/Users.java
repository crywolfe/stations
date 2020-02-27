package com.wolfe.stations.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    private List<User> users;
    private User user;

    @Cacheable("users")
    public List<User> getUsers() {
        return users;
    }

    @Cacheable("user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users) &&
                Objects.equals(user, users1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, user);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Users{");
        sb.append("users=").append(users);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}

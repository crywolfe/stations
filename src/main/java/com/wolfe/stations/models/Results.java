package com.wolfe.stations.models;

import java.util.List;
import java.util.Objects;

public class Results {
    private List<User> results;
    private Info info;

    public List<User> getResults() {
        return results;
    }

    public Info getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results) &&
                Objects.equals(info, results1.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, info);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Results{");
        sb.append("results=").append(results);
        sb.append(", info=").append(info);
        sb.append('}');
        return sb.toString();
    }
}

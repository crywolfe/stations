package com.wolfe.stations.models;

import java.util.Objects;

public class Name {

    private String title;
    private String first;
    private String last;

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(title, name.title) &&
                first.equals(name.first) &&
                last.equals(name.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, first, last);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Name{");
        sb.append("title='").append(title).append('\'');
        sb.append(", first='").append(first).append('\'');
        sb.append(", last='").append(last).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

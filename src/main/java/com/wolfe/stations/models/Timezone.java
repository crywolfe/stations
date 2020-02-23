package com.wolfe.stations.models;

import java.util.Objects;

public class Timezone {
    private String offset;
    private String description;

    public String getOffset() {
        return offset;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timezone timezone = (Timezone) o;
        return Objects.equals(offset, timezone.offset) &&
                Objects.equals(description, timezone.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset, description);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Timezone{");
        sb.append("offset='").append(offset).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

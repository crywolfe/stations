package com.wolfe.stations.models;

import java.util.Objects;

public class Picture {
    private String large;
    private String medium;
    private String thumbnail;

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return Objects.equals(large, picture.large) &&
                Objects.equals(medium, picture.medium) &&
                Objects.equals(thumbnail, picture.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(large, medium, thumbnail);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Picture{");
        sb.append("large='").append(large).append('\'');
        sb.append(", medium='").append(medium).append('\'');
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

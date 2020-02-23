package com.wolfe.stations.models;

import java.util.Objects;

public class Street {
    private Integer number;
    private String name;

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(number, street.number) &&
                Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Street{");
        sb.append("number=").append(number);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

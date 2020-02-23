package com.wolfe.stations.models;

import java.util.Date;
import java.util.Objects;

public class Registered {
    private Date date;
    private Integer age;

    public Date getDate() {
        return date;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registered that = (Registered) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Registered{");
        sb.append("date=").append(date);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

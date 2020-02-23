package com.wolfe.stations.models;

import java.util.Date;
import java.util.Objects;

public class DOB {
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
        DOB dob = (DOB) o;
        return Objects.equals(date, dob.date) &&
                Objects.equals(age, dob.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DOB{");
        sb.append("date=").append(date);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

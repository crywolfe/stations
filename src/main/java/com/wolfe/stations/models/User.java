package com.wolfe.stations.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
//    @JsonProperty
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private DOB dob;
    private Registered registered;
    private String phone;
    private String cell;
    private ID id;
    private Picture picture;
    private String nat;

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public DOB getDob() {
        return dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public ID getId() {
        return id;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getNat() {
        return nat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(gender, user.gender) &&
                Objects.equals(name, user.name) &&
                Objects.equals(location, user.location) &&
                Objects.equals(email, user.email) &&
                Objects.equals(login, user.login) &&
                Objects.equals(dob, user.dob) &&
                Objects.equals(registered, user.registered) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(cell, user.cell) &&
                Objects.equals(id, user.id) &&
                Objects.equals(picture, user.picture) &&
                Objects.equals(nat, user.nat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, location, email, login, dob, registered, phone, cell, id, picture, nat);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("gender='").append(gender).append('\'');
        sb.append(", name=").append(name);
        sb.append(", location=").append(location);
        sb.append(", email='").append(email).append('\'');
        sb.append(", login=").append(login);
        sb.append(", dob=").append(dob);
        sb.append(", registered=").append(registered);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", cell='").append(cell).append('\'');
        sb.append(", id=").append(id);
        sb.append(", picture=").append(picture);
        sb.append(", nat='").append(nat).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

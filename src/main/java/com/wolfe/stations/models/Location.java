package com.wolfe.stations.models;

import java.util.Objects;

public class Location {
    private Street street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private Coordinates coordinates;
    private Timezone timezone;

    public Street getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(street, location.street) &&
                Objects.equals(city, location.city) &&
                Objects.equals(state, location.state) &&
                Objects.equals(country, location.country) &&
                Objects.equals(postcode, location.postcode) &&
                Objects.equals(coordinates, location.coordinates) &&
                Objects.equals(timezone, location.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, country, postcode, coordinates, timezone);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("street=").append(street);
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", postcode=").append(postcode);
        sb.append(", coordinates=").append(coordinates);
        sb.append(", timezone=").append(timezone);
        sb.append('}');
        return sb.toString();
    }
}

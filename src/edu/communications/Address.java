package edu.communications;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 */
public class Address {
    String apartment;
    String building;
    String street;
    String cityArea;
    String city;
    String region;
    String country;
    String zipCode;

    public String toString() {
        return zipCode + ", " + country + ", " + city + ", st. " + street + ", b. " + building + ", apt. " + apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

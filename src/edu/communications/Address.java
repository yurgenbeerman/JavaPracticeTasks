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

    String toString() {
        return zipCode + ", " + country + ", " + city + ", st. " + street + ", b. " + building + ", apt. " + apartment;
    }
}

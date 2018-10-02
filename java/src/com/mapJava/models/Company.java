package com.mapJava.models;

public class Company {

    private String name;
    private String sector;
    private String address;
    private String postcode;
    private String city;
    private float[] coordinates;

    public Company(String name, String sector, String address, String postcode, String city, float[] coordinates) {

        this.name = name;
        this.sector = sector;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public float[] getCoordinates() {
        return coordinates;
    }
}

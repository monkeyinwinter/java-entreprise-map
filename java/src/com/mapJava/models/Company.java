package com.mapJava.models;

public class Company {
    public String name;
    public String sector;
    public String postcode;
    public String city;
    public float[] coord;

    public Company(String name, String sector, String address, String postcode, String city, float[] coord){
        this.name = name;
        this.sector = sector;
        this.postcode = postcode;
        this.city = city;
        this.coord = coord;
    }
}

package com.mapJava.models;

public class Country {

    private String id;
    private String name;
    private String code;

    public Country(String id, String name, String code) {

        this.id = id;
        this.name = name;
        this.code = code;
    }

    private String getId() {
        return id;
    }

    private String getName() {
        return name;
    }

    private String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        Country country = (Country) obj;
        return this.id.contentEquals(country.getId()) && this.name.contentEquals(country.getName()) && this.code.contentEquals(country.getCode());
    }
}

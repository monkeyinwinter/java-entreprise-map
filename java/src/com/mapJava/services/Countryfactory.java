package com.mapJava.services;

import com.mapJava.models.Country;

import java.util.ArrayList;
import java.util.List;

public class Countryfactory {

    public static List<Country> factory(List<String[]> myEntries) {
        List<Country> myCountries = new ArrayList<>();
        for (String[] arrayCountry : myEntries) {
            if (arrayCountry.length < 2) {
                continue;
            } else {
                Country country = new Country(arrayCountry[0].trim(), arrayCountry[1].trim(), arrayCountry[2].trim());
                myCountries.add(country);
            }
        }

        return myCountries;
    }
}

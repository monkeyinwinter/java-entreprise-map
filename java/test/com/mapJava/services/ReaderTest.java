package com.mapJava.services;

import com.mapJava.models.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReaderTest {

    @Test
    void shouldReadCountry1() throws IOException {

        Country country0 = new Country("1", "France", "FR");
        Country country1 = new Country("2", "Belgique", "BE");
        Country country2 = new Country("3", "Allemagne", "DE");

        List<Country> expectedCountries = new ArrayList<>();
        expectedCountries.add(country0);
        expectedCountries.add(country1);
        expectedCountries.add(country2);

        List<Country> myCountries = Countryfactory.factory(Reader.readCountry("data/country1.csv", 0));

        Assertions.assertEquals(expectedCountries.size(), myCountries.size());

        expectedCountries.removeAll(myCountries);
        Assertions.assertEquals(0, expectedCountries.size());


    }

    @Test
    void shouldReadCountry2() throws IOException {

        Country country0 = new Country("1", "France", "FR");
        Country country1 = new Country("2", "Belgique", "BE");
        Country country2 = new Country("3", "Allemagne", "DE");

        List<Country> expectedCountries = new ArrayList<>();
        expectedCountries.add(country0);
        expectedCountries.add(country1);
        expectedCountries.add(country2);

        List<Country> myCountries = Countryfactory.factory(Reader.readCountry("data/country2.csv", 0));

        Assertions.assertEquals(expectedCountries.size(), myCountries.size());

        expectedCountries.removeAll(myCountries);
        Assertions.assertEquals(0, expectedCountries.size());


    }

    @Test
    void shouldReadCountry3() throws IOException {

        Country country0 = new Country("1", "France", "FR");
        Country country1 = new Country("2", "Belgique", "BE");
        Country country2 = new Country("3", "Allemagne", "DE");

        List<Country> expectedCountries = new ArrayList<>();
        expectedCountries.add(country0);
        expectedCountries.add(country1);
        expectedCountries.add(country2);

        List<Country> myCountries = Countryfactory.factory(Reader.readCountry("data/country3.csv", 0));

        Assertions.assertEquals(expectedCountries.size(), myCountries.size());

        expectedCountries.removeAll(myCountries);
        Assertions.assertEquals(0, expectedCountries.size());


    }

    @Test
    void shouldReadCountry4() throws IOException {

        Country country0 = new Country("1", "France", "FR");
        Country country1 = new Country("2", "Belgique", "BE");
        Country country2 = new Country("3", "Allemagne", "DE");

        List<Country> expectedCountries = new ArrayList<>();
        expectedCountries.add(country0);
        expectedCountries.add(country1);
        expectedCountries.add(country2);

        List<Country> myCountries = Countryfactory.factory(Reader.readCountry("data/country4.csv", 1));


        Assertions.assertEquals(expectedCountries.size(), myCountries.size());

        expectedCountries.removeAll(myCountries);
        Assertions.assertEquals(0, expectedCountries.size());


    }

    @Test
    void shouldReadCountry5() throws IOException {

        Country country0 = new Country("", "France", "FR");
        Country country1 = new Country("", "Belgique", "BE");
        Country country2 = new Country("", "Allemagne", "DE");

        List<Country> expectedCountries = new ArrayList<>();
        expectedCountries.add(country0);
        expectedCountries.add(country1);
        expectedCountries.add(country2);

        List<Country> myCountries = Countryfactory.factory(Reader.readCountry("data/country5.csv", 1));

        Assertions.assertEquals(expectedCountries.size(), myCountries.size());

        expectedCountries.removeAll(myCountries);
        Assertions.assertEquals(0, expectedCountries.size());


    }

    @Test
    void shouldReadCountry6() throws IOException {

        Country country0 = new Country("", "France", "FR");
        Country country1 = new Country("", "Belgique", "BE");
        Country country2 = new Country("", "Allemagne", "DE");
        Country country3 = new Country("", "Heard, Ile et MacDonald, îles", "HM");
        Country country4 = new Country("", "Viet Nam (Sud)", "VD");
        Country country5 = new Country("", "Wallis et Futuna", "WF");
        Country country6 = new Country("", "Yémen", "YE");
        Country country7 = new Country("", "Yougoslavie", "YU");
        Country country8 = new Country("", "Zaïre", "ZR");

        List<Country> expectedCountries = new ArrayList<>();
        expectedCountries.add(country0);
        expectedCountries.add(country1);
        expectedCountries.add(country2);
        expectedCountries.add(country3);
        expectedCountries.add(country4);
        expectedCountries.add(country5);
        expectedCountries.add(country6);
        expectedCountries.add(country7);
        expectedCountries.add(country8);

        List<Country> myCountries = Countryfactory.factory(Reader.readCountry("data/country6.csv", 1));

        Assertions.assertEquals(expectedCountries.size(), myCountries.size());

        expectedCountries.removeAll(myCountries);
        Assertions.assertEquals(0, expectedCountries.size());
    }
}
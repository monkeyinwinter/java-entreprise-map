package com.mapJava.services;

import com.mapJava.models.Country;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void shouldReadCountry() throws IOException {
        Reader reader = new Reader();
        List<Country> result = reader.read(1, "data/country4.csv");

        Assertions.assertEquals(3, result.size());
    }

    @Test
    void shouldReadCountry5() throws IOException {
        Reader reader = new Reader();
        List<Country> result = reader.read(1, "data/country5.csv");

        List<Country> list = Arrays.asList(
                new Country("", "France", "FR"),
                new Country("", "Belgique", "BE"),
                new Country("", "Allemagne", "DE")
        );
        int index = 0;
        for (Country test: result
             ) {
            Assertions.assertEquals(test, list.get(index));
            index ++;
        }
    }

    @Test
    void shouldReadCountry6() throws IOException {
        Reader reader = new Reader();
        List<Country> result = reader.read(1, "data/country6.csv");

        List<Country> list = Arrays.asList(
                new Country("", "France", "FR"),
                new Country("", "Belgique", "BE"),
                new Country("", "Allemagne", "DE"),
                new Country("", "Heard, Ile et MacDonald, îles", "HM"),
                new Country("", "Viet Nam (Sud)", "VD"),
                new Country("", "Wallis et Futuna", "WF"),
                new Country("", "Yémen", "YE"),
                new Country("", "Yougoslavie", "YU"),
                new Country("", "Zaïre", "ZR")
        );
        Assertions.assertEquals(result.toString(), list.toString(), "TJS PAS !!");
    }
}
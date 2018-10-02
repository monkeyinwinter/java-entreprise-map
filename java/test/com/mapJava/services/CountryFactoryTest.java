package com.mapJava.services;

import com.mapJava.models.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @Test
    void shouldReadCompany1() throws IOException {
        Reader reader = new Reader();
        List<Country> result = reader.read(1, "data/sirenAll.csv");

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
}
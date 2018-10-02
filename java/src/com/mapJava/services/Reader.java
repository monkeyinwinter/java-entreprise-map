package com.mapJava.services;

import com.mapJava.models.Country;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<Country> read(int lineStart, String path) throws IOException {
        CSVReader Reader = new CSVReader(new FileReader(path), ',', '"', lineStart);
        List<String[]> listAll = Reader.readAll();

        List<Country> myCountries = new ArrayList<>();

        for (String[] lineResult: listAll
        ) {
            if(lineResult.length < 2){
                continue;
            }
                Country country = new Country(lineResult[0].trim(),
                        lineResult[1].trim(), lineResult[2].trim());

                myCountries.add(country);
            }

        return myCountries;
    }
}

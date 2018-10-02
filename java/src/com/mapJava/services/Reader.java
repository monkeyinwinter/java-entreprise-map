package com.mapJava.services;

import com.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Reader {

    static List<String[]> readCountry(String file, int lineStart) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(file), ',', '"', lineStart);
        return reader.readAll();
    }

    public static String[] readCompany(String file, int lineStart) throws IOException {
        BufferedReader br;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                CompanyFactory.factory(line);
            }
        } catch ()
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8), ';', '"', lineStart);
        return reader.readAll();
    }

    public static List<String[]> read(String file, int lineStart) throws IOException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8), ';', '"', lineStart);
        return reader.readAll();
    }
}

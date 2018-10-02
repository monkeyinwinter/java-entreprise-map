package com.mapJava.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapJava.models.Company;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyFactory {

    public void read(int lineStart, String path) throws IOException {
        CSVReader Reader = new CSVReader(new FileReader(path), ';', '"', lineStart);
        List<String[]> listAll = Reader.readAll();

        //read codePostal file
        CSVReader ReaderCP = new CSVReader(new FileReader("data/codePostaux.csv"), ';', '"', 1);
        List<String[]> ListCP = ReaderCP.readAll();

        List<Company> myCompanies = new ArrayList<>();
        float[] CoordCity = new float[2];

        for (String[] lineResultCompany: listAll
        ) {
            if(lineResultCompany.length < 2){
                continue;
            }
            CoordCity[0] = 0;
            CoordCity[1] = 0;
            for (String[] lineCP: ListCP
                 ) {
                if(lineCP[1].equals(lineResultCompany[28])){
                    CoordCity[0] = (Float.parseFloat(lineCP[5].split(",")[0]));
                    CoordCity[1] = (Float.parseFloat(lineCP[5].split(",")[1]));
                }
            }

            Company company = new Company(lineResultCompany[2].trim(),
                    lineResultCompany[43].trim(), lineResultCompany[5].trim(), lineResultCompany[20].trim(),
                    lineResultCompany[28].trim(), CoordCity);

            myCompanies.add(company );
            myCompanies.add("\n");
            System.out.println(myCompanies.get(0).toString());
        }

        try (Writer writer = new FileWriter("data/test.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(myCompanies, writer);
        }
    }
}

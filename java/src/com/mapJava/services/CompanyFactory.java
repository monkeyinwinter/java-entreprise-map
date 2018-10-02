package com.mapJava.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapJava.models.Company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CompanyFactory {

    public static void factory(List<String[]> myEntries) throws IOException {
        List<String[]> codePost = Reader.read("data/code_postaux.csv", 1);
        try (Writer writer = new FileWriter("data/company.json")) {
            writer.write('[');
            writer.write(System.getProperty("line.separator"));
        }
        for (String[] arrayCompanies : myEntries) {
            float[] coordinates = new float[2];
            if (arrayCompanies.length < 2) {
                continue;
            } else {
                System.out.println("toto");
                for (String[] codeLine : codePost) {
                    if (codeLine[2].contentEquals(arrayCompanies[20])) {
                        coordinates[0] = Float.parseFloat(codeLine[5].split(",")[0]);
                        coordinates[1] = Float.parseFloat(codeLine[5].split(",")[1]);
                    }
                }
                Company company = new Company(arrayCompanies[2].trim(), arrayCompanies[43].trim(), arrayCompanies[5].trim(),
                        arrayCompanies[20].trim(), arrayCompanies[28].trim(), coordinates);
                try (Writer writer = new FileWriter("data/company.json", true)) {
                    Gson gson = new GsonBuilder().create();
                    gson.toJson(company, writer);
                    writer.write(',');
                    writer.write(System.getProperty("line.separator"));
                }
            }

        }
        try (Writer writer = new FileWriter("data/company.json", true)) {
            writer.write(']');
        }


    }
}

package com.mapJava;

import com.mapJava.services.CompanyFactory;
import com.mapJava.services.Reader;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        CompanyFactory.factory(Reader.readCompany("data/listCompany.csv", 1));
    }
}

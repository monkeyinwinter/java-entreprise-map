package fr.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestReadCsv {
    @Test
    public void testRead()
    {
    String csvFile = "/home/sylv/Java/java-entreprise-map/java/data/country1.csv";

    ReadCsv reader = new ReadCsv(csvFile, false);
    List<Country> countries = reader.read();
    Country lineCSV = countries.get(0);


    Country countryResult = new Country(1,"France","FR");
    //countryResult.setId(1);
    //countryResult.setName("France");
    //countryResult.setAbbrev("FR");

    Assertions.assertEquals(lineCSV, countryResult);
    Assertions.assertEquals(3,countries.size());
    Assertions.assertEquals(countries.get(1).getName(),"Belgique");
    }


    @Test
    public void testRead2()
    {
     String csvFile = "/home/sylv/Java/java-entreprise-map/java/data/country2.csv";

     ReadCsv reader = new ReadCsv(csvFile, false);
     List<Country> countries = reader.read();
     System.out.println(countries);
    }

    @Test
    public void testRead3()
    {
        String csvFile = "/home/sylv/Java/java-entreprise-map/java/data/country3.csv";

        ReadCsv reader = new ReadCsv(csvFile, false);
        List<Country> countries = reader.read();
        System.out.println(countries);
    }

    @Test
    public void testRead4()
    {
        String csvFile = "/home/sylv/Java/java-entreprise-map/java/data/country4.csv";

        ReadCsv reader = new ReadCsv(csvFile, true);
        List<Country> countries = reader.read();
        System.out.println(countries);
    }
}
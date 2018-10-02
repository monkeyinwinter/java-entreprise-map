package test;

import main.company.CSVFile;
import main.company.Country;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CSVFileTest extends CSVFile {

//    @BeforeEach
//    public void initEach() {
//        CSVFile csv = new CSVFile();
//    }

    @Test
    void testReadCsv1() {

        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country1.csv");

        Assertions.assertEquals(result.get(0).getName(), "France");
        Assertions.assertNotEquals(result.iterator().next().getId(), "2" );
        Assertions.assertEquals(result.get(1).getCode(), "BE");

    }

    @Test
    void testReadCsv2 () {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country2.csv");

        Assertions.assertEquals(result.get(0).getName(), "France");
        Assertions.assertEquals(result.get(1).getCode(), "BE");
        Assertions.assertEquals(result.get(2).getId(), 3);
    }

    @Test
    void testReadCsv3() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country3.csv");

        Assertions.assertEquals(result.get(0).getName(), "France");
        Assertions.assertNotEquals(result.get(1).getCode(), "  BE");
        Assertions.assertNotEquals(result.get(2).getId(), "3 ");


    }
    @Test
    void testReadCsv4() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country4.csv");

        Assertions.assertEquals(result.get(0).getName(), "France");
        Assertions.assertEquals(result.get(1).getCode(), "BE");
        Assertions.assertNotEquals(result.get(2).getId(), "3 ");
    }
    @Test
    void testReadCsv5() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country5.csv");

        Assertions.assertEquals(result.get(0).getName(), "France");
        Assertions.assertNotEquals(result.get(1).getCode(), "  BE");
        Assertions.assertNotEquals(result.get(2).getId(), "3 ");
    }

    @Test
    void testReadCsv6() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country6.csv");

        Assertions.assertEquals("Heard, Ile et MacDonald, îles",result.get(3).getName());
        Assertions.assertEquals("Viet Nam (Sud)", result.get(4).getName());
        Assertions.assertEquals(result.get(5).getName(), "Wallis et Futuna");
        Assertions.assertEquals(9, result.size());
    }

}
package test;

import main.company.CSVFile;
import main.company.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CSVFileTest extends CSVFile {
    @Test
    void testReadCsv() {

        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv1();

        Assertions.assertEquals(result.iterator().next().getName(), "France");

        Assertions.assertNotEquals(result.iterator().next().getId(), "2" );

        Assertions.assertEquals(result.get(1).getCode(), "BE");

    }
}
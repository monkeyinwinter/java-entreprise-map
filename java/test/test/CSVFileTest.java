package test;

import main.company.CSVFile;
import main.company.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;



class CSVFileTest extends CSVFile {


    @Test
    void readFile() {

        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country1.csv");

        assertThat(result.get(0).getName()).isEqualTo("France");
        assertThat(result.get(1).getCode()).isEqualTo("BE");
        assertThat(result.get(2).getId()).isEqualTo(3);
    }

    @Test
    void shouldIgnoreEmptyLines() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country2.csv");

        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void shouldIgnoreBlanks() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country3.csv");

        assertThat(result.get(1).getCode()).isNotEqualTo("  BE");
        assertThat(result.get(2).getId()).isNotEqualTo("3 ");
    }

    @Test
    void shouldIgnoreHeader() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country4.csv");

        assertThat(result.get(0).getId()).isNotEqualTo("Id");
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void shouldAddIdIfEmpty() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country5.csv");

        for (int i =0; i< result.size(); i++) {
            assertThat(result.get(i).getId()).isEqualTo(i+1);
        }
    }

    @Test
    void shouldReadTextBetweenDoubleQuotes() {
        CSVFile csv = new CSVFile();

        List<Country> result = csv.readCsv("data/country6.csv");

        assertThat(result.get(3).getName()).isEqualTo("Heard, Ile et MacDonald, îles");
    }

}
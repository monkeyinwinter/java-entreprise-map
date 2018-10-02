import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author gro
 * 01 / 10 / 2018
 */
class TestCountry {

    private List<Country> getCountryList(String number) {
        List<Country> countries = new ArrayList<Country>();
        try {
            FileInputStream fileInputStream = new FileInputStream("data/country" + number + ".csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(inputStreamReader);

            String[] line;
            line = reader.readNext();
            boolean crasher = true;
            int id=0;
            while (crasher) {
                if (line.length == 1 && (line[0].equals("") || line[0] == null )) {
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                } else {
                    id++;
                    if( line[0].equals("Id" ) ){
                        line = reader.readNext();
                   }

                    if( line[0].equals("")) line[0]= Integer.toString(id);

                    //On crér l'objet Country
                    countries.add(new Country(Integer.parseInt(line[0].trim()), line[1].trim(), line[2].trim()));
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countries;
    }

    @Test
    void noProb() {
        List<Country> countryList = getCountryList("1");
        assertEquals("France", countryList.get(0).getName());
        assertEquals("Belgique", countryList.get(1).getName());
        assertEquals("Allemagne", countryList.get(2).getName());


        countryList = getCountryList("2");
        assertEquals("France", countryList.get(0).getName());
        assertEquals("Belgique", countryList.get(1).getName());
        assertEquals("Allemagne", countryList.get(2).getName());

        countryList = getCountryList("3");
        assertEquals("France", countryList.get(0).getName());
        assertEquals("Belgique", countryList.get(1).getName());
        assertEquals("Allemagne", countryList.get(2).getName());

        countryList = getCountryList("4");
        assertEquals("France", countryList.get(0).getName());
        assertEquals("Belgique", countryList.get(1).getName());
        assertEquals("Allemagne", countryList.get(2).getName());

        countryList = getCountryList("5");
        assertEquals("France", countryList.get(0).getName());
        assertEquals("Belgique", countryList.get(1).getName());
        assertEquals("Allemagne", countryList.get(2).getName());

        countryList = getCountryList("6");
        assertEquals("France", countryList.get(0).getName());
        assertEquals("Belgique", countryList.get(1).getName());
        assertEquals("Allemagne", countryList.get(2).getName());

    }
}
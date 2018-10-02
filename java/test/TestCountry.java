import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author gro
 * 01 / 10 / 2018
 */
class TestCountry {


    @Test
    void noProb() {
        List<Country> countryList;
        for (int i = 1; i <= 6; i++) {
            countryList = Main.getCountryList(Integer.toString(i));
            assertEquals("1", countryList.get(0).getId());
            assertEquals("France", countryList.get(0).getName());
            assertEquals("FR", countryList.get(0).getLibelle());
            assertEquals("2", countryList.get(1).getId());
            assertEquals("Belgique", countryList.get(1).getName());
            assertEquals("BE", countryList.get(1).getLibelle());
            assertEquals("3", countryList.get(2).getId());
            assertEquals("Allemagne", countryList.get(2).getName());
            assertEquals("DE", countryList.get(2).getLibelle());
            System.out.println("CSV " + Integer.toString(i) + " -> OK");
        }
    }
}
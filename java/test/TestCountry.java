import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author gro
 * 01 / 10 / 2018
 */
class TestCountry {
    private List<Country> countryList1 = Main.getCountryList("1");
    private List<Country> countryList2 = Main.getCountryList("2");
    private List<Country> countryList3 = Main.getCountryList("3");
    private List<Country> countryList4 = Main.getCountryList("4");
    private List<Country> countryList5 = Main.getCountryList("5");
    private List<Country> countryList6 = Main.getCountryList("6");

    @Test
    void shouldCreateListWithCSV() {
        assertThat(countryList1)
                .extracting("id", "name", "libelle")
                .containsOnly(
                        tuple("1", "France", "FR"),
                        tuple("2", "Belgique", "BE"),
                        tuple("3", "Allemagne", "DE")
                );
    }

    @Test
    void shouldIgnoreEmptyLine() {
        assertThat(countryList2)
                .hasSize(3);
    }

    @Test
    void shouldIgnoreSpacesAndTabIntoValue() {
        assertThat(countryList3)
                .extracting("id", "name", "libelle")
                .contains(
                        tuple("1", "France", "FR"),
                        tuple("2", "Belgique", "BE"),
                        tuple("3", "Allemagne", "DE")
                )
                .doesNotContain(
                        tuple("3 ", "\tAllemagne", "\tDE")
                );
    }

    @Test
    void shouldIgnoreFirstLine() {
        assertThat(countryList4).hasSize(3);
    }

    @Test
    void shouldAcceptEmptyValue() {
        assertThat(countryList5)
                .extracting("id")
                .containsOnly("");
    }

    @Test
    void libelleShouldOnlyGot2Char() {
        assertThat(countryList6)
                .extracting(Country::getLibelle)
                .allSatisfy(s -> assertThat(s).hasSize(2));
    }

    @Test
    void shouldAcceptComaWhenInQuote() {
        assertThat(countryList6)
                .extracting("name")
                .contains("Heard, Ile et MacDonald, îles");
    }
}


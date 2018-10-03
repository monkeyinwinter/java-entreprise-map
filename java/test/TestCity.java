import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

/**
 * @author gro
 * 02 / 10 / 2018
 */
public class TestCity {
    @Test
    void testCsvPostaux() {
        List<City> cityList = Main.getCityList();
        assertThat(cityList)
                .hasSize(39202)
                .extracting("code", "name", "codePostal", "geoLoc")
                .contains(
                        tuple("26362", "VALENCE", "26000", "44.9229811667, 4.91444013136")
                )
                .doesNotContain(
                        tuple("26362", "PARIS", "26000", "44.9229811667, 4.91444013136"),
                        tuple("", "", "", "")
                );


    }
}

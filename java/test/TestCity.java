import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author gro
 * 02 / 10 / 2018
 */
public class TestCity {
    @Test
    void noProb() {
        List<City> cityList = Main.getCityList();

        assertEquals("91248", cityList.get(25).getCode());

    }
}

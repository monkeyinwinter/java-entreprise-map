import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Test1 {

    @Test
    public void test1() throws IOException {
        CountryDAO dao = new CountryDAO();
        List<Country> result = dao.findCoutries("data/", "country1.csv", false);

        Assert.assertTrue(result.get(1).getName().equals("Belgique"));
        Assert.assertTrue(result.get(0).getName().equals("France") && result.get(0).getIndicateur().equals("FR"));
        Assert.assertTrue(result.size() == 3);
    }

    @Test
    public void test2() throws IOException {
        CountryDAO dao = new CountryDAO();
        List<Country> result = dao.findCoutries("data/", "country2.csv", false);

        Assert.assertTrue(result.get(1).getName().equals("Belgique"));
        Assert.assertTrue(result.get(0).getName().equals("France") && result.get(0).getIndicateur().equals("FR"));
        Assert.assertTrue(result.size() == 3);

    }

    @Test
    public void test3() throws IOException {
        CountryDAO dao = new CountryDAO();
        List<Country> result = dao.findCoutries("data/", "country3.csv", false);

        Assert.assertTrue(result.get(1).getName().equals("Belgique"));
        Assert.assertTrue(result.get(0).getName().equals("France") && result.get(0).getIndicateur().equals("FR"));
        Assert.assertTrue(result.size() == 3);

    }

    @Test
    public void test4() throws IOException {
        CountryDAO dao = new CountryDAO();
        List<Country> result = dao.findCoutries("data/", "country4.csv", true);

        Assert.assertTrue(result.get(1).getName().equals("Belgique"));
        Assert.assertTrue(result.get(0).getName().equals("France") && result.get(0).getIndicateur().equals("FR"));
        Assert.assertTrue(result.size() == 3);

    }

    @Test
    public void test5() throws IOException {
        CountryDAO dao = new CountryDAO();
        List<Country> result = dao.findCoutries("data/", "country5.csv", true);

        Assert.assertTrue(result.get(1).getName().equals("Belgique"));
        Assert.assertTrue(result.get(0).getName().equals("France") && result.get(0).getIndicateur().equals("FR"));
        Assert.assertTrue(result.size() == 3);

    }

    @Test
    public void test6() throws IOException {
        CountryDAO dao = new CountryDAO();
        List<Country> result = dao.findCoutries("data/", "country6.csv", true);

        Assert.assertTrue(result.get(1).getName().equals("Belgique"));
        Assert.assertTrue(result.get(0).getName().equals("France") && result.get(0).getIndicateur().equals("FR"));
        Assert.assertTrue(result.size() == 9);

    }

}

import junit.framework.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class test extends TestCase{

    @Test
    public void test1() throws Exception {

        PaysDao dao = new PaysDao(false);
        List<Pays> mylist = dao.read("data/country1.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au test 1.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas  au test 1.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas  au test 1.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas  au test 1.4");
    }

    @Test
    public void test2() throws Exception {

        PaysDao dao = new PaysDao(true);
        List<Pays> mylist = dao.read("data/country2.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au test 2.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas  au test 2.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas  au test 2.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas  au test 2.4");
    }

    @Test
    public void test3() throws Exception {

        PaysDao dao = new PaysDao(false);
        List<Pays> mylist = dao.read("data/country3.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au test 3.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas  au test 3.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas  au test 3.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas  au test 3.4");
    }

    @Test
    public void test4() throws Exception {

        PaysDao dao = new PaysDao(true);
        List<Pays> mylist = dao.read("data/country4.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au test 4.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas  au test 4.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas  au test 4.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas  au test 4.4");
    }

}

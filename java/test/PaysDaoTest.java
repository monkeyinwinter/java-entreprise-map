
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class PaysDaoTest {

/*    @Test
    public void test1() throws Exception {

        PaysDao dao = new PaysDao(false);//absence ligne titre
        List<Pays> mylist = dao.read("data/country1.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au PaysDaoTest 1.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas au PaysDaoTest 1.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas au PaysDaoTest 1.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas au PaysDaoTest 1.4");
    }*/

    @Test
    public void test1() throws Exception {

        PaysDao dao = new PaysDao(false);//absence ligne titre

        List<Pays> mylist = dao.read("data/country1.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");

    }

/*    @Test
    public void doitIgnorerLesLignesVides() throws Exception {

        PaysDao dao = new PaysDao(false);//absence ligne titre
        List<Pays> mylist = dao.read("data/country2.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au PaysDaoTest 2.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas au PaysDaoTest 2.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas au PaysDaoTest 2.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas au PaysDaoTest 2.4");
    }*/

    @Test
    public void doitIgnorerLesLignesVides() throws Exception {

        PaysDao dao = new PaysDao(false);//absence ligne titre

        List<Pays> mylist = dao.read("data/country2.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");
    }

    @Test
    public void doitIgnorerLesEspacesVides() throws Exception {

        PaysDao dao = new PaysDao(false);//absence ligne titre

        List<Pays> mylist = dao.read("data/country3.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");
    }

/*    @Test
    public void doitIgnorerLesEspacesVides() throws Exception {

        PaysDao dao = new PaysDao(false);//absence ligne titre
        List<Pays> mylist = dao.read("data/country3.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au PaysDaoTest 3.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas au PaysDaoTest 3.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas au PaysDaoTest 3.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas au PaysDaoTest 3.4");
    }*/

    @Test
    public void doitIgnorerLaLigneTitre() throws Exception {

        PaysDao dao = new PaysDao(true);//presence ligne titre

        List<Pays> mylist = dao.read("data/country4.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");
    }

/*    @Test
    public void doitIgnorerLaLigneTitre() throws Exception {

        PaysDao dao = new PaysDao(true);//presence ligne titre
        List<Pays> mylist = dao.read("data/country4.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au PaysDaoTest 4.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas au PaysDaoTest 4.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas au PaysDaoTest 4.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas au PaysDaoTest 4.4");
    }*/


    @Test
    public void doitRemplirLeChampsIdVide() throws Exception {

        PaysDao dao = new PaysDao(true);//presence ligne titre

        List<Pays> mylist = dao.read("data/country5.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");
    }

/*    @Test
    public void doitRemplirLeChampsIdVide() throws Exception {

        PaysDao dao = new PaysDao(true);//presence ligne titre
        List<Pays> mylist = dao.read("data/country5.csv");
        Assertions.assertEquals(3, mylist.size(), "ça marche pas au PaysDaoTest 5.1");
        Assertions.assertEquals(1, mylist.get(0).getId(), "ça marche pas au PaysDaoTest 5.2");
        Assertions.assertEquals("France", mylist.get(0).getName(), "ça marche pas au PaysDaoTest 5.3");
        Assertions.assertEquals("FR", mylist.get(0).getCode(), "ça marche pas au PaysDaoTest 5.4");
    }*/

}

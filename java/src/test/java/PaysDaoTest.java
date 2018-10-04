/*
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class PaysDaoTest {

    @Test
    public void test1() throws Exception {

        PaysDao dao = new PaysDao(false);//absence ligne titre

        List<Pays> mylist = dao.read("data/country1.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");

    }

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

    @Test
    public void doitIgnorerLaLigneTitre() throws Exception {

        PaysDao dao = new PaysDao(true);//presence ligne titre

        List<Pays> mylist = dao.read("data/country4.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");
    }

    @Test
    public void doitRemplirLeChampsIdVide() throws Exception {

        PaysDao dao = new PaysDao(true);//presence ligne titre

        List<Pays> mylist = dao.read("data/country5.csv");

        assertThat(mylist.size()).isEqualTo(3);
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");
    }

    @Test
    public void doitPrendreEnCptGuillementsCommeSeparateur() throws Exception {

        PaysDao dao = new PaysDao(true);//presence ligne titre

        List<Pays> mylist = dao.read("data/country6.csv");

        assertThat(mylist.size()).isEqualTo(mylist.size());
        assertThat(mylist.get(0).getId()).isEqualTo(1);
        assertThat(mylist.get(0).getName()).isEqualTo("France");
        assertThat(mylist.get(0).getCode()).isEqualTo("FR");
    }

}
*/

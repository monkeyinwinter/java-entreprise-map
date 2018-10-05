import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        PaysDao dao = new PaysDao(true);
        PaysDao daoTitre = new PaysDao(true);
        CommuneDao daoCommune = new CommuneDao(true);

        List<Pays> listPays1 = dao.read("data/country4.csv");
        List<Titre> listTitre1 = daoTitre.readTitre("data/country4.csv");
        List<Commune> listCommune1 = daoCommune.read("data/commune.csv");
        List<TitreCommune> listTitreCommune1 = daoCommune.readTitreCommune("data/commune.csv");

        List<String> listPays2 = new ArrayList<String>();
        List<String> listTitre2 = new ArrayList<String>();
        List<String> listCommune2 = new ArrayList<String>();

/*        System.out.println(listCommune1);*/

        String listTitre3;
        String listPays3;

        for(Titre titre : listTitre1)//converti list objet titre en list string
        {
            listTitre2.add(String.valueOf(titre));
        }

        listTitre3 = listTitre2.stream()
                .collect(Collectors.joining(","));

        for(Pays pays : listPays1)//converti list objet pays en list string
        {
            listPays2.add(String.valueOf(pays));
        }

        listPays3 = listPays2.stream()
                .collect(Collectors.joining(","));

        String[] testTitre1 = listTitre3.split(",");
        String[] testPays1 = listPays3.split(",");

        List<Map<String, String>> listeKeyValue = new ArrayList<Map<String, String>>();

        Integer counter = 0;
        Integer z = 0;

        for(Integer i = 0 ; i < 3 ; i++)
        {
            HashMap<String, String> map = new HashMap<String,String>();

            for (Integer x = 0 ; x < 3 ; x++)
            {
                map.put(testTitre1[z], testPays1[counter]);

                counter++;
                z++;

                if(z == 3)
                {
                    z = 0;
                }

            }
            listeKeyValue.add(map);
        }

        System.out.println(listeKeyValue);

    }

}



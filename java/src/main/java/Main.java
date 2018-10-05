import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;


public class Main
{
    public static void main(String[] args) throws IOException
    {

        Path path = Paths.get("data/country4.csv");
        List<String> lignes = Files.readAllLines(path);

        Integer count = (lignes.size()-1)*3;//nombre de champs total du fichier moins ligne titre

        PaysDao dao = new PaysDao(true);
        PaysDao daoTitre = new PaysDao(true);

        List<Pays> listPays1 = dao.read("data/country4.csv");
        List<Titre> listTitre1 = daoTitre.readTitre("data/country4.csv");

        List<String> listPays2 = new ArrayList<String>();
        List<String> listTitre2 = new ArrayList<String>();

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

        List<Map<String, String>> test = new ArrayList<Map<String, String>>();

        Integer counter = 0;
        Integer z = 0;

        for(Integer i = 0 ; i < count ; i++)
        {
            HashMap<String, String> map = new HashMap<String,String>();

            map.put(testTitre1[z], testPays1[counter]);

            test.add(map);

            counter++;

            z++;
            if(z == 3)
            {
                z = 0;
            }
        }

        System.out.println(test);


/*        List<Map<Object, Object>> test2 = test.MergeTitrePays(titre, myList);*/

/*        CommuneDao communeDao = new CommuneDao(true);
        List<Commune> ListCommune = communeDao.read("data/codepostaux26.csv");
*/
/*        for(Pays pays: listPays1)
        {
            System.out.println(pays.toString());
        }*/

    }

}



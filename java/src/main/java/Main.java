import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Main
{
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Départ du chrono\n");
        long debut = System.currentTimeMillis();//calcul le temps d'execution du programme

        CommuneDao dao = new CommuneDao(true);
        Map<String, String[]> resultCommune = dao.readBuffered("data/ville.csv");

        SocieteDao societeDao = new SocieteDao(true);
        List<Map<String, Object>> resultSociete = societeDao.readBuffered("data/societe.csv", resultCommune);

        Gson gson = new Gson();//converti list map string string en json
        String resultSocieteJson = gson.toJson(resultSociete);

        try
        {
            FileWriter writer = new FileWriter("../data/data-map.json");//ecrit et save un fichier convertie en json pour la map
            writer.write(resultSocieteJson);
            writer.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        SocieteDao societeDaoList = new SocieteDao(true);
        List<Map<String, String>> resultListSector = societeDaoList.listSector(resultSociete);

        Gson gson2 = new Gson();//converti list map string string en json
        String resultListSectorJson = gson2.toJson(resultListSector);

        try
        {
            FileWriter writer = new FileWriter("../data/data-table.json");//ecrit et save un fichier convertie en json pour la table
            writer.write(resultListSectorJson);
            writer.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        DecimalFormat f = new DecimalFormat();//arrondi à deux décimales
        f.setMaximumFractionDigits(2);

        System.out.println("Arret du chrono, temps d'éxecution => " + f.format((System.currentTimeMillis()-debut)*0.001) + " secondes");//affiche le temps d'execution



/*


        PaysDao paysDao = new PaysDao(true);
        PaysDao paysDaoTitre = new PaysDao(true);

        List<Pays> listPays1 = paysDao.read("data/country4.csv");
        List<TitrePays> listPaysTitre1 = paysDaoTitre.readTitre("data/country4.csv");

        List<String> listPays2 = new ArrayList<String>();
        List<String> listPaysTitre2 = new ArrayList<String>();

        String listPays3;
        String listPaysTitre3;

        for(Pays pays : listPays1)//converti list objet pays en list string
        {
            listPays2.add(String.valueOf(pays));
        }

        listPays3 = listPays2.stream()
                .collect(Collectors.joining(","));

        for(TitrePays titrePays : listPaysTitre1)//converti list objet TitrePays en list string
        {
            listPaysTitre2.add(String.valueOf(titrePays));
        }

        listPaysTitre3 = listPaysTitre2.stream()
                .collect(Collectors.joining(","));

        String[] StringTitrePays1 = listPaysTitre3.split(",");
        String[] StringPays1 = listPays3.split(",");

        List<Map<String, String>> listeKeyValuePays = new ArrayList<Map<String, String>>();
        List<Map<String, String>> listeKeyValueCommune = new ArrayList<Map<String, String>>();

        Integer counterPays = 0;
        Integer zPays = 0;

        for(Integer i = 0 ; i < 3 ; i++)
        {
            HashMap<String, String> mapKeyValuePays = new HashMap<String,String>();

            for (Integer x = 0 ; x < 3 ; x++)
            {
                mapKeyValuePays.put(StringTitrePays1[zPays], StringPays1[counterPays]);

                counterPays++;
                zPays++;

                if(zPays == 3)
                {
                    zPays = 0;
                }
            }
            listeKeyValuePays.add(mapKeyValuePays);
        }

*/





    }

}



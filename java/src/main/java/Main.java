import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws IOException
    {


        Scanner entréeClavier = new Scanner(System.in);

        System.out.println("Veuillez saisir un chiffre superieur ou inférieur à 5 :");

        Integer resultEntréeClavier = entréeClavier.nextInt();

        double latDestination;
        double lonDestination;
        String villeDestination;

        if(resultEntréeClavier < 5)
        {
            latDestination = 44.9;//le cheylard
            lonDestination = 4.4167;
            villeDestination = "Le Cheylard";
        }else
        {
            latDestination = 43.610769;//mtp
            lonDestination = 3.876716;
            villeDestination = "Montpellier";
        }


        double latSource = 44.933393;//valence
        double lonSource = 4.89236;
        String villeSource = "Valence";


        double result = distance_Between_LatLong(latSource, lonSource, latDestination, lonDestination);

        Integer nbApVirg = 2;//arrondir à deux chiffres après la virgule

        double resultArrondi = arrondir(result, nbApVirg );

        if (result < 100)
        {
            System.out.print("Distance : " + villeSource + " / " + villeDestination + " = " + resultArrondi + " km de distance est tout près");
        }else
        {
            System.out.print("Distance : " + villeSource + " / " + villeDestination + " = " + resultArrondi + " km de distance est trop loin");
        }





        CommuneDao dao = new CommuneDao(true);
        Map<String, String[]> resultCommune = dao.readBuffered("data/ville.csv");
/*        System.out.println(resultCommune);*/

        SocieteDao societeDao = new SocieteDao(true);
        List<Map<String, Object>> resultSociete = societeDao.readBuffered("data/societe.csv", resultCommune);
/*        System.out.println(resultSociete);*/


        Gson gson = new Gson();//converti list map string string en json
        String resultSocieteJson = gson.toJson(resultSociete);
/*        System.out.println(resultSocieteJson);*/

        try
        {
            FileWriter writer = new FileWriter("../data/data-map.json");//ecrit et save un fichier convertie en json
            writer.write(resultSocieteJson);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }







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






    }

    public static double distance_Between_LatLong(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double earthRadius = 6371.01; //Kilometers
        return earthRadius * Math.acos(Math.sin(lat1)*Math.sin(lat2) + Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1 - lon2));
    }

    public static double arrondir(double nombre,double nbApVirg)
    {
        return(double)((int)(nombre * Math.pow(10,nbApVirg) + .5)) / Math.pow(10,nbApVirg);
    }

}



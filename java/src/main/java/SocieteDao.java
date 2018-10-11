
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SocieteDao {

    private boolean header;

    public SocieteDao(boolean header) {
        this.header = header;
    }

      public List<Map<String, Object>> readBuffered(String filepath, Map<String, String[]> resultCommune)
    {
        List<Map<String, Object>> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String ligne = null;


            if (this.header == true)
            {
                br.readLine();
            }

            while ((ligne = br.readLine()) != null) {

                Map<String, Object> mapKeyValueSociete = new HashMap<String, Object>();

                String lignex = ligne.replace("\"", "");

                String[] champs = lignex.split(";");

                String[] gps = resultCommune.get(champs[20].trim());

                if(gps == null)
                {
                    continue;
                }


                // calcul distance entre point[] et gps[]
/*                System.out.println(" lat (gps[0]) = " + gps[0] + " / lon (gps[1] = " + gps[1]);*/
/*                Scanner entréeClavier = new Scanner(System.in);*/
/*                System.out.println("Veuillez saisir un chiffre superieur ou inférieur à 100 :");*/
/*                Integer resultEntréeClavier = entréeClavier.nextInt();*/
/*                double latDestination;
                double lonDestination;*/
/*                if(resultEntréeClavier < 100)
                {
                    latDestination = 44.9;//le cheylard
                    lonDestination = 4.4167;
                    villeDestination = "Le Cheylard";
                }else
                {
                    latDestination = 43.610769;//mtp
                    lonDestination = 3.876716;
                    villeDestination = "Montpellier";
                }*/


                double LatDest = Double.parseDouble(gps[0]);
                double LonDest = Double.parseDouble(gps[1]);

                double latSource = 44.933393;//valence
                double lonSource = 4.89236;

                double result = distance_Between_LatLong(latSource, lonSource, LatDest, LonDest);

                if (result < 10)
                {
                    mapKeyValueSociete.put("name", champs[2].trim());
                    mapKeyValueSociete.put("city", champs[28].trim());
                    mapKeyValueSociete.put("adress", champs[5].trim());
                    mapKeyValueSociete.put("postcode", champs[20].trim());
                    mapKeyValueSociete.put("sector", champs[43].trim());

                    mapKeyValueSociete.put("coord", new Float[] {Float.parseFloat(gps[0]), Float.parseFloat(gps[1])});

                    list.add(mapKeyValueSociete);
                }else
                {
                    continue;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static double distance_Between_LatLong(double lat1, double lon1, double latDestination, double lonDestination) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        latDestination = Math.toRadians(latDestination);
        lonDestination = Math.toRadians(lonDestination);

        double earthRadius = 6371.01; //Kilometers
        return earthRadius * Math.acos(Math.sin(lat1)*Math.sin(latDestination) + Math.cos(lat1)*Math.cos(latDestination)*Math.cos(lon1 - lonDestination));
    }


    public List<Map<String, String>> listSector(List<Map<String, Object>> resultSociete)
    {
        List<Map<String, Integer>> list = new ArrayList<>();
        List<Map<String, Integer>> listTemp = new ArrayList<>();
        List<Map<String, Integer>> listOut = new ArrayList<>();
        List<Map<String, String>> listOutLast = new ArrayList<>();

        Integer count = 1;

        for (Map<String, Object> resultSociete2 : resultSociete)
        {
            Map<String, Integer> mapKeyValueSectorTemp = new HashMap<String, Integer>();

            for (Map.Entry<String, Object> resultSociete3 : resultSociete2.entrySet())
            {
                String sector = resultSociete3.getKey();
                Object value = resultSociete3.getValue();

                String valueConvert = String.valueOf(value);

                if (sector.equals("sector"))
                {
                    mapKeyValueSectorTemp.put(valueConvert, count );
                }
            }
            listTemp.add(mapKeyValueSectorTemp);
        }

        Map<String, Integer> mapKeyValueSectorOut = new HashMap<String, Integer>();

        for ( Integer i = 0 ; i < 1 ; i++)
        {
            for (Map<String, Integer> listTemp2 : listTemp)
            {
                for (Map.Entry<String, Integer> listTemp3 : listTemp2.entrySet())
                {
                    String sector2 = listTemp3.getKey();

                    boolean test = mapKeyValueSectorOut.containsKey(sector2);

                    if (test == true)
                    {
                        Integer valueTemp = null;
                        for (Map.Entry<String, Integer> entry : mapKeyValueSectorOut.entrySet())
                        {
                            String key = entry.getKey();
                            valueTemp = entry.getValue();

                            if (key.equals(sector2))
                            {
                                Integer test2 = valueTemp + 1;
                                mapKeyValueSectorOut.put(sector2, test2);
                            }
                        }

                        continue;
                    }else
                    {
                        mapKeyValueSectorOut.put(sector2, count );
                    }

                }
            }

            listOut.add(mapKeyValueSectorOut);
/*                    System.out.println(mapKeyValueSectorOut);*/
        }
/*        System.out.println(listOut);*/

        for (Map<String, Integer> listOut2 : listOut)
        {
            for (Map.Entry<String, Integer> resultSociete3 : listOut2.entrySet())
            {
                Map<String, String> mapKeyValueSectorLast = new HashMap<String, String>();
                String sector = resultSociete3.getKey();
                Integer value = resultSociete3.getValue();

                String valueAsString = Integer.toString(value);

                String sectorTitre = "sector";
                String valueTitre = "value";

                mapKeyValueSectorLast.put(sectorTitre, sector);
                mapKeyValueSectorLast.put(valueTitre, valueAsString);

/*                System.out.println(mapKeyValueSectorLast);*/
                listOutLast.add(mapKeyValueSectorLast);
            }

        }

/*        System.out.println(listOutLast);*/
        return listOutLast;
    }
}


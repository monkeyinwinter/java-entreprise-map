
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

                String[] champs = ligne.split(";");

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

                if (result < 150)
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


    public List<Map<String, Integer>> listSector(List<Map<String, Object>> resultSociete)
    {
        List<Map<String, Integer>> list = new ArrayList<>();
        List<Map<String, Integer>> listTemp = new ArrayList<>();

        Integer count = 1;
        Map<String, Integer> mapKeyValueSectorTemp = new HashMap<String, Integer>();
        for (Map<String, Object> resultSociete2 : resultSociete)
        {


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
        System.out.println(mapKeyValueSectorTemp);

        boolean test = mapKeyValueSectorTemp.contains("D�pollution et autres services de gestion des d�chets");

        /*         System.out.println(listTemp);*/





/*
        Boolean test = listTemp.contains("Comm. d�tail de quincaillerie, peintures et verres (mag.< 400 m2)");

        System.out.println(test);
*/


       /* System.out.println(list);*/
        return list;
    }
}


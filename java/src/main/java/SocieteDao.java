import java.io.*;
import java.util.*;

public class SocieteDao
{
    private boolean header;

    /**
     *
     * @param header
     */
    public SocieteDao(boolean header)
    {
        this.header = header;
    }

    /**
     *
     * @param filepath
     * @param resultCommune
     * @return List<Map<String, Object>> resultSociete
     */
      public List<Map<String, Object>> readBuffered(String filepath, Map<String, String[]> resultCommune)
      {
        List<Map<String, Object>> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath)))
        {
            String ligne = null;

            if (this.header == true)
            {
                br.readLine();
            }

            while ((ligne = br.readLine()) != null)
            {
                Map<String, Object> mapKeyValueSociete = new HashMap<String, Object>();

                String lignex = ligne.replace("\"", "");

                String[] champs = lignex.split(";");

                String[] gps = resultCommune.get(champs[20].trim());

                if(gps == null)
                {
                    continue;
                }

                double LatDest = Double.parseDouble(gps[0]);
                double LonDest = Double.parseDouble(gps[1]);

                double latSource = 44.933393;//valence
                double lonSource = 4.89236;

                double result = distance_Between_LatLong(latSource, lonSource, LatDest, LonDest);

                if (result < 100)//definie la distance(rayon) en km à partir du point de reference Valence
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

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param lat1
     * @param lon1
     * @param latDestination
     * @param lonDestination
     * @return double result
     */
    public static double distance_Between_LatLong(double lat1, double lon1, double latDestination, double lonDestination)//calcul la distance entre deux points gps
    {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        latDestination = Math.toRadians(latDestination);
        lonDestination = Math.toRadians(lonDestination);

        double earthRadius = 6371.01; //Kilometers diametre de la terre

        double result = earthRadius * Math.acos(Math.sin(lat1)*Math.sin(latDestination) + Math.cos(lat1)*Math.cos(latDestination)*Math.cos(lon1 - lonDestination));

        return result;
    }

    /**
     *
     * @param resultSociete
     * @return List<Map<String, String>> resultListSector
     */
    public List<Map<String, String>> listSector(List<Map<String, Object>> resultSociete)//retourne une list map string string pour display les sectors et le nombre de societe de ce sector
    {
        SocieteDao listSector1 = new SocieteDao(true);

        SocieteDao listSectorFct2 = new SocieteDao(true);

        SocieteDao listSectorFct3 = new SocieteDao(true);

        List<Map<String, Integer>> listSector1Result = listSector1.listSectorFct1(resultSociete);//recupere les keys et values sector de la map et cree une list map string string -> (fleuriste=1)

        List<Map<String, Integer>> listSector2Result = listSectorFct2.listSectorFct2(listSector1Result);//supprime les doublons et incemente la valeur associé à la key -> (fleuriste=12)

        List<Map<String, String>> listSectorFct3Result = listSectorFct3.listSectorFct3(listSector2Result);//cree une list map string string avec (sector=fleuriste, value=12)

        return listSectorFct3Result;//retourne une list map string string -> (sector=fleuriste, value=12)
    }

    /**
     *
     * @param resultSociete
     * @return List<Map<String, Integer>> listSector1Result
     */
    public List<Map<String, Integer>> listSectorFct1(List<Map<String, Object>> resultSociete)//recupere les keys et values sector de la map et cree une list map string string -> (fleuriste=1)
    {
        List<Map<String, Integer>> list = new ArrayList<>();

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
            list.add(mapKeyValueSectorTemp);
        }
        return list;
    }

    /**
     *
     * @param listFct1Result
     * @return List<Map<String, Integer>> listSector2Result
     */
    public List<Map<String, Integer>> listSectorFct2(List<Map<String, Integer>> listFct1Result)//supprime les doublons et incemente la valeur associé à la key -> (fleuriste=12)
    {
        List<Map<String, Integer>> listTemp = new ArrayList<>();

        Map<String, Integer> mapKeyValueSectorOut = new HashMap<String, Integer>();

        Integer count = 1;

        for ( Integer i = 0 ; i < 1 ; i++)
        {
            for (Map<String, Integer> listTemp2 : listFct1Result)
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
                    }else
                    {
                        mapKeyValueSectorOut.put(sector2, count );
                    }
                }
            }
            listTemp.add(mapKeyValueSectorOut);
        }
        return listTemp;
    }

    /**
     *
     * @param listFct2Result
     * @return List<Map<String, String>> listSectorFct3Result
     */
    public List<Map<String, String>> listSectorFct3(List<Map<String, Integer>> listFct2Result)//cree une list map string string avec (sector=fleuriste, value=12)
    {
        List<Map<String, String>> listOut = new ArrayList<>();

        for (Map<String, Integer> listOut2 : listFct2Result)
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

                listOut.add(mapKeyValueSectorLast);
            }
        }
        return listOut;
    }

}


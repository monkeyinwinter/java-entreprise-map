/*

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class exemple {

    private boolean header;

    public exempleDao(boolean header) {
        this.header = header;
    }

    public List<Map<String, Object>> readBuffered(String filepath, Map<String, String[]> resultCommune)
    {
        List<Map<String, Object>> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String ligne = null;

*/
/*            if (this.header == true)
            {
                br.readLine();
            }*//*


            while ((ligne = br.readLine()) != null) {

                Map<String, Object> mapKeyValueSociete = new HashMap<String, Object>();

                String[] champs = ligne.split(";");

                String[] gps = resultCommune.get(champs[20].trim());

                if(gps == null)
                {
                    continue;
                }


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








}

*/

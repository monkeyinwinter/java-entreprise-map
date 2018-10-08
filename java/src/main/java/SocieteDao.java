
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SocieteDao {

    private boolean header;

    public SocieteDao(boolean header)
    {
        this.header = header;
    }

    public List<TitreSociete> readTitreSociete(String filepath) throws IOException
    {
        /*Path path = Paths.get(filepath);*/

        List<TitreSociete> listTitre = new ArrayList<TitreSociete>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/societe.csv"))) {

            String lignes = "";


                lignes = br.readLine();

/*            while ((lignes = br.readLine()) != null ) {*/
/*                System.out.println(lignes);*/


            String[] champsTitre = lignes.split(";");

            TitreSociete titreSociete = new TitreSociete();

            titreSociete.setTitreSociete(champsTitre[2].trim());
            titreSociete.setTitreCommune("," + champsTitre[28].trim());
            titreSociete.setTitreAdresse("," + champsTitre[17].trim() + " " + champsTitre[18].trim() + " " + champsTitre[19].trim());
            titreSociete.setTitreCodePostal("," + champsTitre[20].trim());
            titreSociete.setTitreActivite("," + champsTitre[43].trim());

            listTitre.add(titreSociete);

/*                }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
/*        System.out.println(listTitre);*/
        return listTitre;
    }
/*
    public List<Societe> read(String filepath) throws IOException
    {
        Path path = Paths.get(filepath);

        List<String> lignesSociete = Files.readAllLines(path);

        List<Societe> ListSociete = new ArrayList<Societe>();

        Integer f = 0;

        if (this.header == true)
        {
            f = 1;//condition pour fichier 4 ligne titre
        }

        for ( ; f< lignesSociete.size() ; f++)
        {

            String lignePropreSociete;
            String ligneBrutSociete3;
            String ligneBrutSociete4;
            String[] champsSociete;

            String ligneBrutSociete1= lignesSociete.get(f);

            String ligneBrutSociete2 = ligneBrutSociete1.replaceAll("\"", " separateur ");//pour fichier 6 guillemets

            if (ligneBrutSociete2.contains(" separateur "))// pour test fichier 6
            {
                ligneBrutSociete3 = ligneBrutSociete2.replaceAll(";", "");

                lignePropreSociete = ligneBrutSociete3.replaceAll(" separateur ", ";");
            }
            else
            {
                lignePropreSociete = ligneBrutSociete2.replaceAll(";;", ";");
            }

            champsSociete = lignePropreSociete.split(";");

            if (champsSociete.length >= 3)
            {
                if(champsSociete[0].isEmpty())
                {
                    champsSociete[0] = "1";
                }

                String societeX = champsSociete[2].trim();
                String commune = "," + champsSociete[2].trim();
                String adresse = "," + champsSociete[2].trim();
                String codePostal = "," + champsSociete[2].trim();
                String activite = "," + champsSociete[1].trim();
                String gps = "," + champsSociete[4].trim() + "/" + champsSociete[5].trim();

                Societe societe = new Societe(societeX, commune, adresse, codePostal, activite, gps);

                ListSociete.add(societe);
            }

        }

        return ListSociete;
    }*/


    public List<Map<String, String>> readBuffered(String filepath, Map<String, String[]> resultCommune)
    {
        List<Map<String, String>> listTitre = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String ligne = null;

            if (this.header == true)
            {
                br.readLine();
            }

            while ((ligne = br.readLine()) != null) {

                Map<String, String> mapKeyValueSociete = new HashMap<String, String>();

                String[] champs = ligne.split(";");

/*                System.out.println(resultCommune);*/

/*                resultCommune = resultCommune.split(",");*/

/*                String value = null;
                String value2 = null;*/

                /*for(final Map.Entry<String, String> entry : resultCommune..entrySet()) {
                    final String key =  entry.getKey();
                    final String value =  entry.getValue();

                }*/
/*                System.out.println(value.split(","));*/



              /*  Societe societe = new Societe();
                societe.setSociete(champs[2].trim());
                societe.setCommune(champs[28].trim());
                societe.setAdresse(new String[]{champs[17].trim() , champs[18].trim() , champs[19].trim()});
                societe.setCodePostal(champs[20].trim());
                societe.setActivite(champs[43].trim());
                societe.setGps(resultCommune.get(societe.getCodePostal()));*/

                String[] gps = resultCommune.get(champs[20].trim());

                if(gps == null)
                {
                    continue;
                }

                mapKeyValueSociete.put("nom", champs[2].trim());
                mapKeyValueSociete.put("commune", champs[28].trim());
                mapKeyValueSociete.put("codepostal", champs[20].trim());
                mapKeyValueSociete.put("Activite", champs[43].trim());
                mapKeyValueSociete.put("gps", gps[0] + "/" + gps[1]);

                listTitre.add(mapKeyValueSociete);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listTitre;
    }

}


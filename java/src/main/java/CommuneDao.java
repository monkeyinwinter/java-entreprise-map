import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class CommuneDao
{
    private boolean header;

    public CommuneDao(boolean header)
    {
        this.header = header;
    }

/*    public List<TitreCommune> readTitreCommune(String filepath) throws IOException
    {

        String lignePropreTitre;
        String[] champsTitre;
        String id;
        Path path = Paths.get(filepath);

*//*        System.out.println(filepath);

        System.out.println("tata" + path);*//*

        List<String> lignes = Files.readAllLines(path);

*//*        System.out.println(lignes);*//*

        List<TitreCommune> listTitre = new ArrayList<TitreCommune>();


            String ligneTitreBrut = lignes.get(0);

            champsTitre = ligneTitreBrut.split(";");

            String TitreCommuneCodePostal = champsTitre[2].trim();
            String TitreCommuneNomCommune = "," + champsTitre[1].trim();
            String TitreCommuneGps = "," + champsTitre[5].trim();
            TitreCommune titreCommune = new TitreCommune(TitreCommuneCodePostal, TitreCommuneNomCommune, TitreCommuneGps);

            listTitre.add(titreCommune);

        return listTitre;
    }*/

/*    public List<Commune> read(String filepath) throws IOException
    {
        Path path = Paths.get(filepath);

        List<String> lignesCommune = Files.readAllLines(path);

        List<Commune> ListCommune = new ArrayList<Commune>();

        Integer f = 0;

        if (this.header == true)
        {
            f = 1;//condition pour fichier 4 ligne titre
        }

        for ( ; f< lignesCommune.size() ; f++)
        {

            String lignePropreCommune;
            String ligneBrutCommune3;
            String ligneBrutCommune4;
            String[] champsCommune;

            String ligneBrutCommune1= lignesCommune.get(f);

            String ligneBrutCommune2 = ligneBrutCommune1.replaceAll("\"", " separateur ");//pour fichier 6 guillemets

            if (ligneBrutCommune2.contains(" separateur "))// pour test fichier 6
            {
                ligneBrutCommune3 = ligneBrutCommune2.replaceAll(";", "");

                lignePropreCommune = ligneBrutCommune3.replaceAll(" separateur ", ";");
            }
            else
            {
                lignePropreCommune = ligneBrutCommune2.replaceAll(";;", ";");
            }

            champsCommune = lignePropreCommune.split(";");

            if (champsCommune.length >= 3)
            {
                if(champsCommune[0].isEmpty())
                {
                    champsCommune[0] = "1";
                }

                String codePostal = champsCommune[2].trim();
                String nomCommune = "," + champsCommune[1].trim();
                String gps = "," + champsCommune[4].trim() + "/" + champsCommune[5].trim();

                Commune commune = new Commune(codePostal, nomCommune, gps);

                ListCommune.add(commune);
            }

        }

        return ListCommune;
    }*/

    public Map<String, String[]> readBuffered(String filepath) throws IOException
    {
        Map<String, String[]> mapKeyValueCommune = new HashMap<String, String[]>();
        //List<Map<String, String>> listTitre = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String ligne = null;

            if (this.header == true)
            {
                br.readLine();
            }

            while ((ligne = br.readLine()) != null) {


                String[] champs = ligne.replaceAll(";;", ";").split(";");

                Commune commune = new Commune();

                commune.setCodePostal(champs[2].trim());
                commune.setCommune(champs[1].trim());
                commune.setGps(new String[]{champs[4].trim(), champs[5].trim()});

                mapKeyValueCommune.put(commune.getCodePostal(), commune.getGps());

                //listTitre.add(mapKeyValueCommune);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapKeyValueCommune;
    }


}

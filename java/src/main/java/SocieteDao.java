
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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

            while ((lignes = br.readLine()) != null ) {
/*                System.out.println(lignes);*/

                for(Integer i = 0 ; i < 50 ; i++) {

                    String[] champsTitre = lignes.split(";");


                TitreSociete titreSociete = new TitreSociete();

                titreSociete.setTitreCommune(champsTitre[1].trim());
                titreSociete.setTitreAdresse(champsTitre[5].trim());
                titreSociete.setTitreCodePostal( champsTitre[2].trim());
                titreSociete.setTitreActivite(champsTitre[1].trim());
                titreSociete.setTitreGps(champsTitre[5].trim());

                listTitre.add(titreSociete);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listTitre);
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
}


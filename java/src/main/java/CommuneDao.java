import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CommuneDao
{
    private boolean header;

    public CommuneDao(boolean header)
    {
        this.header = header;
    }

    public List<TitreCommune> readTitreCommune(String filepath) throws IOException
    {

        String lignePropreTitre;
        String[] champsTitre;
        String id;
        Path path = Paths.get(filepath);

/*        System.out.println(filepath);

        System.out.println("tata" + path);*/

        List<String> lignes = Files.readAllLines(path);

/*        System.out.println(lignes);*/

        List<TitreCommune> listTitre = new ArrayList<TitreCommune>();

        for ( Integer z = 0 ; z < 1 ; z++)
        {
            String ligneTitreBrut = lignes.get(z);

            champsTitre = ligneTitreBrut.split(";");

            String TitreCommuneCodePostal = champsTitre[2].trim();
            String TitreCommuneNomCommune = "," + champsTitre[1].trim();
            String TitreCommuneGps = "," + champsTitre[5].trim();
            TitreCommune titreCommune = new TitreCommune(TitreCommuneCodePostal, TitreCommuneNomCommune, TitreCommuneGps);
/*            System.out.println(titreCommune);*/
            listTitre.add(titreCommune);
        }

        return listTitre;
    }

    public List<Commune> read(String filepath) throws IOException
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
    }
}

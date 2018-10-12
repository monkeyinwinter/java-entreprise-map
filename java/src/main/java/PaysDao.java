import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PaysDao
{
    private boolean header;

    public PaysDao(boolean header)
    {
         this.header = header;
    }

    public List<TitrePays> readTitre(String filepath) throws IOException
    {
        String[] champsTitre;
        String id;
        Path path = Paths.get(filepath);

        List<String> lignes = Files.readAllLines(path);

        List<TitrePays> listTitre = new ArrayList<TitrePays>();

        for ( Integer z = 0 ; z < 1 ; z++)
        {
            String ligneTitreBrut = lignes.get(z);

            champsTitre = ligneTitreBrut.split(",");

            id = champsTitre[0].trim();
            String name = "," + champsTitre[1].trim();
            String code = "," + champsTitre[2].trim();
            TitrePays titre= new TitrePays(id, name, code);

            listTitre.add(titre);
        }

        return listTitre;
    }

    public List<Pays> read(String filepath) throws IOException
    {

        Path path = Paths.get(filepath);

        List<String> lignes = Files.readAllLines(path);

        List<Pays> mylist = new ArrayList<Pays>();

        String[] champs;

        Integer i = 0;

        if (this.header == true)
        {
            i = 1;//condition pour fichier 4 ligne titre
        }

        for ( ; i < lignes.size() ; i++)
        {
            String lignePropre;
            String ligneBrut3;

            String ligneBrut1 = lignes.get(i);

            String ligneBrut2 = ligneBrut1.replaceAll("\"", " separateur ");//pour fichier 6 guillemets

            if (ligneBrut2.contains(" separateur "))// pour test fichier 6
            {
                ligneBrut3 = ligneBrut2.replaceAll(",", "");

                lignePropre = ligneBrut3.replaceAll(" separateur ", ",");
            }
            else
            {
                lignePropre = ligneBrut2;
            }

            champs = lignePropre.split(",");

            if (champs.length >= 3)
            {
                if(champs[0].isEmpty())
                {
                    champs[0] = "1";
                }

                String id = champs[0].trim();
                String name = "," + champs[1].trim();
                String code = "," + champs[2].trim();
                Pays pays = new Pays(id, name, code);

                mylist.add(pays);
            }
        }
        return mylist;
    }

}


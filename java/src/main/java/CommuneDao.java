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
                ligneBrutCommune3 = ligneBrutCommune2.replaceAll(",", "");

                lignePropreCommune = ligneBrutCommune3.replaceAll(" separateur ", ",");
            }
            else
            {
                ligneBrutCommune4 = ligneBrutCommune2.replaceAll(";;", ";");
                lignePropreCommune = ligneBrutCommune4;
/*                lignePropreCommune = ligneBrutCommune2;*/
            }

/*            System.out.println(ligneBrutCommune2);*/

            champsCommune = lignePropreCommune.split(";");

            if (champsCommune.length >= 3)
            {
                if(champsCommune[0].isEmpty())
                {
                    champsCommune[0] = "1";
                }

                String codePostal = champsCommune[2].trim();
                String nomCommune = champsCommune[1].trim();
                String Gps = champsCommune[4].trim() + "/" +champsCommune[5].trim();

                Commune commune = new Commune(parseInt(codePostal), nomCommune, Gps);

                ListCommune.add(commune);
            }

        }

        return ListCommune;
    }
}

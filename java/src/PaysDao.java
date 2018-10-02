import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PaysDao
{
    private boolean header;


    public PaysDao(boolean header)
    {
         this.header = header;
    }

    public List<Pays> read(String filepath) throws IOException
    {
        Path path = Paths.get(filepath);

        List<String> lignes = Files.readAllLines(path);

        List<Pays> mylist = new ArrayList<Pays>();

        Integer i = 0;

        if (this.header == true) i = 1;

        for ( ; i < lignes.size() ; i++)
        {
            String ligne = lignes.get(i); // une ligne du fichier

            String[] champs = ligne.split(",");

            if (champs.length >= 3) {

                String id = champs[0].trim();
                String name = champs[1].trim();
                String code = champs[2].trim();
                Pays pays = new Pays(parseInt(id), name, code);

                mylist.add(pays);
            }
        }

        return mylist;
    }
}


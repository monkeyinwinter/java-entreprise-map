import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        PaysDao dao = new PaysDao(true);
        List<Pays> mylist = dao.read("data/country4.csv");

/*        for(Pays pays : mylist)
        {
            System.out.println(pays.toString());
        }*/

        PaysDao daoTitre = new PaysDao(true);

        List<Titre> listTitre = daoTitre.readTitre("data/country4.csv");

/*        for(Titre titre: listTitre)
        {
            System.out.println(titre.toString());
        }*/


        HashMap<Titre, Pays> listCleValeurPays = new HashMap<Titre, Pays>();

        /*String test = listTitre.split();*/

        String[] champsTitre;

/*        champsTitre = listTitre.split("/");*/

        System.out.println();

        for(int y = 0 ; y < listTitre.size() ; y++){

            for (Pays pays : mylist)
            {
                listCleValeurPays.put(listTitre.get(y), mylist.get(y));
            }
        }

        System.out.println(listCleValeurPays);

/*        CommuneDao communeDao = new CommuneDao(true);
        List<Commune> ListCommune = communeDao.read("data/codepostaux26.csv");

        for(Commune commune : ListCommune)
        {
            System.out.println(commune.toString());
        }*/

    }

}



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        CommuneDao dao = new CommuneDao(true);
        Map<String, String[]> resultCommune = dao.readBuffered("data/commune.csv");
        System.out.println(resultCommune);

        SocieteDao societeDao = new SocieteDao(true);
        List<Map<String, String>> resultSociete = societeDao.readBuffered("data/societe2.csv", resultCommune);
        System.out.println(resultSociete);

        PaysDao paysDao = new PaysDao(true);
        PaysDao paysDaoTitre = new PaysDao(true);
        CommuneDao communeDao = new CommuneDao(true);
        CommuneDao communeDaoTitre = new CommuneDao(true);
/*        SocieteDao SocieteDao = new SocieteDao(true);*/
        SocieteDao SocieteDaoTitre = new SocieteDao(true);

        List<Pays> listPays1 = paysDao.read("data/country4.csv");
        List<TitrePays> listPaysTitre1 = paysDaoTitre.readTitre("data/country4.csv");
/*        List<Commune> listCommune1 = communeDao.read("data/commune.csv");
        List<TitreCommune> listTitreCommune1 = communeDaoTitre.readTitreCommune("data/commune.csv");*/
/*        List<Societe> listSociete1 = SocieteDao.read("data/societe.csv");*/
        List<TitreSociete> listSocieteTitre1 = SocieteDaoTitre.readTitreSociete("data/societe.csv");

        List<String> listPays2 = new ArrayList<String>();
        List<String> listPaysTitre2 = new ArrayList<String>();
        List<String> listCommune2 = new ArrayList<String>();
        List<String> listTitreCommune2 = new ArrayList<String>();
        List<String> listSociete2 = new ArrayList<String>();
        List<String> listTitreSociete2 = new ArrayList<String>();

/*        System.out.println(listPays1);
        System.out.println(listPaysTitre1);
        System.out.println(listCommune1);
        System.out.println(listTitreCommune1);
        System.out.println(listSociete1);*/
/*       System.out.println(listSocieteTitre1);*/

        String listPays3;
        String listPaysTitre3;
        String listCommune3;
        String listCommuneTitre3;
        String listSociete3;
        String listSocieteTitre3;

///////////////////////////////Pays
        for(Pays pays : listPays1)//converti list objet pays en list string
        {
            listPays2.add(String.valueOf(pays));
        }

        listPays3 = listPays2.stream()
                .collect(Collectors.joining(","));

        for(TitrePays titrePays : listPaysTitre1)//converti list objet TitrePays en list string
        {
            listPaysTitre2.add(String.valueOf(titrePays));
        }

        listPaysTitre3 = listPaysTitre2.stream()
                .collect(Collectors.joining(","));

///////////////////////////////commune
/*        for(Commune commune : listCommune1)//converti list objet Commune en list string
        {
            listCommune2.add(String.valueOf(commune));
        }

        listCommune3 = listCommune2.stream()
                .collect(Collectors.joining(","));*/

/*        for(TitreCommune titreCommune : listTitreCommune1)//converti list TitreCommune titre en list string
        {
            listTitreCommune2.add(String.valueOf(titreCommune));
        }

        listCommuneTitre3 = listTitreCommune2.stream()
                .collect(Collectors.joining(","));*/

/*        System.out.println(listPays3);
        System.out.println(listPaysTitre3);
        System.out.println(listCommune3);
        System.out.println(listCommuneTitre3);*/

        String[] StringTitrePays1 = listPaysTitre3.split(",");
        String[] StringPays1 = listPays3.split(",");
/*        String[] StringTitreCommune1 = listCommuneTitre3.split(",");
        String[] StringCommune1 = listCommune3.split(",");*/

        /*System.out.println(listPays3);
        System.out.println(listPaysTitre3);
        System.out.println(StringCommune1[0]);
        System.out.println(listCommuneTitre3);*/

        List<Map<String, String>> listeKeyValuePays = new ArrayList<Map<String, String>>();
        List<Map<String, String>> listeKeyValueCommune = new ArrayList<Map<String, String>>();

        Integer counterPays = 0;
        Integer zPays = 0;
        Integer counterCommune = 0;
        Integer zCommune = 0;

        //////////////////////////////////////////////Pays
        for(Integer i = 0 ; i < 3 ; i++)
        {
            HashMap<String, String> mapKeyValuePays = new HashMap<String,String>();

            for (Integer x = 0 ; x < 3 ; x++)
            {
                mapKeyValuePays.put(StringTitrePays1[zPays], StringPays1[counterPays]);

                counterPays++;
                zPays++;

                if(zPays == 3)
                {
                    zPays = 0;
                }

            }
            listeKeyValuePays.add(mapKeyValuePays);
        }

        ////////////////////////////////////////////////////commune
/*        for(Integer a = 0 ; a < 9 ; a++)
        {
            HashMap<String, String> mapKeyValueCommune = new HashMap<String,String>();

            for (Integer n = 0 ; n < 3 ; n++)
            {
                mapKeyValueCommune.put(StringTitreCommune1[zCommune], StringCommune1[counterCommune]);
*//*                System.out.println(mapKeyValueCommune);*//*
                counterCommune++;
                zCommune++;

                if(zCommune == 3)
                {
                    zCommune = 0;
                }
            }
            listeKeyValueCommune.add(mapKeyValueCommune);
        }*/

/*        System.out.println(StringCommune1[0]);*/

/*        for(Integer a = 0 ; a < 9 ; a++)
        {
            HashMap<String, String> mapKeyValueCommune = new HashMap<String,String>();

            //for (Integer n = 0 ; n < 3 ; n++)
            //{
                mapKeyValueCommune.put(StringCommune1[0], StringCommune1[0] + "," + StringCommune1[1] + "," + StringCommune1[2]);
                *//*                System.out.println(mapKeyValueCommune);*//*
                counterCommune++;
                zCommune++;

                if(zCommune == 3)
                {
                    zCommune = 0;
                }
            //}
            listeKeyValueCommune.add(mapKeyValueCommune);
        }*/


 /*       System.out.println(StringCommune1[1]);*/

/*        System.out.println(listeKeyValuePays);*/
/*        System.out.println(listeKeyValueCommune);*/




    }

}



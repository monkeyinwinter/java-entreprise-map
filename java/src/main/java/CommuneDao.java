import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommuneDao
{
    private boolean header;

    public CommuneDao(boolean header)
    {
        this.header = header;
    }


    public Map<String, String[]> readBuffered(String filepath)
    {
        Map<String, String[]> mapKeyValueCommune = new HashMap<String, String[]>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath)))
        {
            String ligne = null;

            if (this.header == true)
            {
                br.readLine();
            }

            while ((ligne = br.readLine()) != null)
            {
                String[] champs = ligne.replaceAll(";;", ";").split(";");

                Commune commune = new Commune();

                commune.setCodePostal(champs[2].trim());
                commune.setCommune(champs[0].trim());
                commune.setGps(new String[]{champs[5].trim(), champs[6].trim()});

                mapKeyValueCommune.put(commune.getCodePostal(), commune.getGps());
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return mapKeyValueCommune;
    }
}

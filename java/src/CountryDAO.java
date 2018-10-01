import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    private final static String RESSOURCE_PATH = "data/";
    private final static String COUNTRY_FILE_NAME = "country1.csv";
    private final static char SEPARATOR = ',';

    public List<Country> findCoutries() throws IOException {

        File file = new File(RESSOURCE_PATH + COUNTRY_FILE_NAME);
        FileReader fr = new FileReader(file);

        CSVReader csvReader = new CSVReader(fr, SEPARATOR);

        //List<String[]> data = new ArrayList<String[]>();
        String[] nextLine = null;
        List<Country> result = new ArrayList<>();

        while((nextLine = csvReader.readNext())!=null)

        {
            // nextLine = [1,France,FR]
           // int size = nextLine.length;



           new Country();
           //result = country()// mettre country dedans

            //data.add(nextLine);
        }

        return result;
    }
}

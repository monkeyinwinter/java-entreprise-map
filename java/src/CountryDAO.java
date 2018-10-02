import com.opencsv.CSVReader;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends Country {

    // private final static String RESSOURCE_PATH = "data/";
    // private final static String COUNTRY_FILE_NAME = "country1.csv";
    private final static char SEPARATOR = ',';

    public List<Country> findCoutries(String RESSOURCE_PATH, String COUNTRY_FILE_NAME, boolean header) throws IOException {

        File file = new File(RESSOURCE_PATH + COUNTRY_FILE_NAME);
        FileReader fr = new FileReader(file);

        CSVReader csvReader = new CSVReader(fr, SEPARATOR);

        String[] nextLine = null;
        List<Country> countries = new ArrayList<>();

        // List<String> data = new ArrayList<String[]>();

        if (header) {
            csvReader.readNext();
        }

        while ((nextLine = csvReader.readNext()) != null) {


            int size = nextLine.length;

            if (size > 1) {
                int id = Integer.parseInt(nextLine[0].trim());
                //System.out.println(id);
                String name = nextLine[1].trim();
                //System.out.println(name);
                String indicateur = nextLine[2].trim();
                //System.out.println(indicateur);

                Country country = new Country(id, name, indicateur);
                countries.add(country);
            }
        }
        //System.out.println(countries);
        return countries;
    }
}







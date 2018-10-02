import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends Country {

    private final static String RESSOURCE_PATH = "data/";
    private final static String COUNTRY_FILE_NAME = "country1.csv";
    private final static char SEPARATOR = ',';

    public List<Country> findCoutries() throws IOException {

        File file = new File(RESSOURCE_PATH + COUNTRY_FILE_NAME);
        FileReader fr = new FileReader(file);

        CSVReader csvReader = new CSVReader(fr, SEPARATOR);

        List<String[]> data = new ArrayList<String[]>();
        String[] nextLine = null;

        // List<String> data = new ArrayList<String[]>();

        while ((nextLine = csvReader.readNext()) != null) {
            int size = nextLine.length;

            if (size != 0) {
                data.add(nextLine);
            }
        }

        List<Country> countries = new ArrayList<>();
        for (String[] oneData : data) {
            int id = Integer.parseInt(oneData[0]);
            System.out.println(id);
            String name = oneData[1];
            System.out.println(name);
            String indicateur = oneData[2];
            System.out.println(indicateur);

            Country country = new Country(id, name, indicateur);
            countries.add(country);
        }

        System.out.println(countries);
        return countries;
    }
}

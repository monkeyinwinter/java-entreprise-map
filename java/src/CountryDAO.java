import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CountryDAO {

    private final static String RESSOURCE_PATH = "/../data/";
    private final static String COUNTRY_FILE_NAME = "country1.csv";
    private final static char SEPARATOR = ';';

    public List<Country> findCoutries() {
        File file = new File(RESSOURCE_PATH + COUNTRY_FILE_NAME);
        FileReader fr = new FileReader(file);

        CSVReader csvReader = new CSVReader (fr, SEPARATOR);
    }
}

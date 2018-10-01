import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CountryDAO dao = new CountryDAO();
        try {
            dao.findCoutries();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(countries);
    }

}

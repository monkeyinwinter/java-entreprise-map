package Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<Country> readCSV(String name) {

        //String csvFile = "/home/vincent/sites/java-entreprise-map/java/data/" + name;
        String csvFile = "C:/Users/T3rA/Documents/GitHub/java-entreprise-map/java/data/" + name;
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        List<Country> ref = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                String[] country = line.split(csvSplitBy);

                for (int i=0; i<country.length; i++) {

                    country[i] = country[i].trim();
                }

                ref.add(new Country(Integer.parseInt(country[0]), country[1], country[2]));
                System.out.println(country[1] + " " + country[2]);
            }


        } catch (IOException ex) {
            ex.printStackTrace();

        } finally {

            if (br != null) {
                try {
                    br.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }

        return ref;
    }

}

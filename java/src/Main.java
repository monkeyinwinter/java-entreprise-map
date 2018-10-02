import com.google.gson.Gson;
import com.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<City> cityList = getCityList();
        storeJson(cityList);
    }

    /**
     * @param object
     * @return boolean
     */
    static boolean storeJson(Object object) {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter("data/cities.json")) {
            gson.toJson(object, fileWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param number
     * @return List<City>
     */
    static List<Country> getCountryList(String number) {
        List<Country> countries = new ArrayList<Country>();
        try {
            FileInputStream fileInputStream = new FileInputStream("data/country" + number + ".csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(inputStreamReader);

            String[] line;
            line = reader.readNext();
            boolean crasher = true;
            while (crasher) {
                if (line.length == 1 && (line[0].equals("") || line[0] == null)) {
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                } else {
                    if (line[0].equals("")) line[0] = "";
                    countries.add(new Country(line[0].trim(), line[1].trim(), line[2].trim()));
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * @return List<City>
     */
    static List<City> getCityList() {
        List<City> cities = new ArrayList<City>();
        try {
            FileInputStream fileInputStream = new FileInputStream("data/code_postaux.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(inputStreamReader, ';');

            String[] line;
            line = reader.readNext();
            boolean crasher = true;
            while (crasher) {
                if (line.length == 1 && (line[0].equals("") || line[0] == null)) {
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                } else {
                    if (line.length > 5 && line[5] != null && !line[5].equals("")) {
                        City city = new City(line[0].trim(), line[1].trim(), line[2].trim(), line[5].trim());
                        cities.add(city);
                    } else {
                        City city = new City(line[0].trim(), line[1].trim(), line[2].trim(), "NoGeoloc");
                        cities.add(city);
                    }
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }

}

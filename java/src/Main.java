import com.google.gson.Gson;
import com.opencsv.CSVReader;
import io.vavr.collection.Array;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {


//        List<City> cityList = getCityList();
//        storeJson(cityList, "data/cities.json");
//        List<Insee> inseeList = getInseeList();
    }

    /**
     * @param object
     * @return boolean
     */
    static boolean storeJson(Object object, String jsonPath) {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(jsonPath)) {
            gson.toJson(object, fileWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    static HashMap<String, String> getGeoloc() {
        List<City> cityList = getCityList();
        HashMap<String, String> geoloc = new HashMap<>();

        for (City city : cityList) {
            geoloc.put(city.getCodePostal(), city.getGeoLoc());
        }
        return geoloc;
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
    static List<Insee> getInseeList() {
        HashMap<String, String> geolocTable = getGeoloc();

        List<Insee> inseeList = new ArrayList<Insee>();
        try {
            FileInputStream fileInputStream = new FileInputStream("/home/gro/Bureau/sirene_201808_L_M/sirc-17804_9075_61173_201808_L_M_20180901_015350280.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(inputStreamReader, ';');

            String[] line;
            line = reader.readNext();
            boolean crasher = true;
            int jsonNumber = 0;
            int count = 0;
            while (crasher) {
                if (line.length == 1 && (line[0].equals("") || line[0] == null)) {
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                } else {
                    count++;
//                    if (line[20].equals("26000")) {
                    Insee insee = new Insee(line[0], line[16], line[18], line[19], line[20], line[28], line[43]);
                    inseeList.add(insee);
//                    }
                    if (count == 1000000) {
                        jsonNumber++;
                        System.out.println(Integer.toString(jsonNumber) + " million");

                        System.out.println(Integer.toString(inseeList.size()) + " trouvé a valence !");
                        count = 0;
                    }
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inseeList;
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

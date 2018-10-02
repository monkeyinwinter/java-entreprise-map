import com.google.gson.Gson;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {


//    /**
//     * Method for file code_postaux.csv convert object to Json.file
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        Gson gson = new Gson();
//        Pattern pattern = Pattern.compile(";");
//
//        try (BufferedReader in = new BufferedReader(new FileReader("data/code_postaux.csv"))) {
//
//            List<City> cities = in.lines().skip(1).map(line -> {
//
//                String[] x = pattern.split(line);
//
//                if (x.length > 5 && x[5] != null && !x[5].equals("")) {
//                    return new City(x[0], x[1], Integer.parseInt(x[2]), x[5]);
//                }
//                else{
//                    return new City(x[0], x[1], Integer.parseInt(x[2]), "NOWHERE");
//                }
//
//            }).collect(Collectors.toList());
//
//            for (City city : cities) {
//                System.out.println(city.getCodePostal() + " : " + city.getName()+ " : " + city.getGeoLoc());
//            }
//
//            try (FileWriter writer = new FileWriter("data/cities.json")) {
//
//                gson.toJson(cities, writer);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Method for file country[*].csv convert object to Json.file
     * @param args
     */
    public static void main(String[] args) {

        getCountryList();
    }

    static List<Country> getCountryList(){

        List<Country> countries = new ArrayList<Country>();

        Gson gson = new Gson();
        Pattern pattern = Pattern.compile(",");

        try (BufferedReader reader = new BufferedReader(new FileReader("data/country3.csv"))) {

            countries = reader.lines().skip(0).map(line -> {

                String[] x = pattern.split(line);

                return new Country(Integer.parseInt(x[0].trim()), x[1].trim(), x[2].trim());

            }).collect(Collectors.toList());

            for (Country country : countries) {
                System.out.println(country.getId() + " : " + country.getName()+ " : " + country.getLibelle());
            }

            try (FileWriter writer = new FileWriter("data/country1.json")) {

                gson.toJson(countries, writer);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return countries;
    }

}

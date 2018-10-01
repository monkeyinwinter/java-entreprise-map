package main.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {


   public List<Country> readCsv1() {

        String file = "data/country2.csv";
       List<Country> result = new ArrayList<>();
       FileReader fr;
       BufferedReader br;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;

                for (line = br.readLine(); line != null; line = br.readLine()) {

                    String[] str = line.split(",");

                    Country country = new Country();
                    country.setId(Integer.parseInt(str[0]));
                    country.setName(str[1]);
                    country.setCode(str[2]);
                    result.add(country);
                }
        }
        catch(Exception e){
                e.printStackTrace();
            }

        return result;
    }



}

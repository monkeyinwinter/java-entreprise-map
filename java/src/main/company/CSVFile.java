package main.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {


    public List<Country> readCsv(String file) {

        List<Country> result = new ArrayList<>();
        FileReader fr;
        BufferedReader br;
        String[] str;

        int id = 1;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);


            for (String line = br.readLine(); line != null; line = br.readLine()) {

                try {

                    str = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");


                    for (int i = 0; i < str.length; i++) {
                        str[i] = str[i].trim();
                        str[i] = str[i].replace("\"", "");
                    }

                    Country country = new Country();
                    if (str[0].equals("")) {
                        country.setId(id);
                        id++;
                    } else {
                        country.setId(Integer.parseInt(str[0]));
                        id++;
                    }
                    country.setName(str[1]);
                    country.setCode(str[2]);
                    result.add(country);

                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

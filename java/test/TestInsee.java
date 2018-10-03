import com.google.gson.Gson;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tony
 * 02 / 10 / 2018
 */
class TestInsee {

    public static List<Insee> getInseeList() {
        List<Insee> insees = new ArrayList<Insee>();
        try {
            FileInputStream fileInputStream = new FileInputStream("data/sirene_201808_L_M/sirc-17804_9075_61173_201808_L_M_20180901_015350280.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(inputStreamReader, ';');

            String[] line;
            line = reader.readNext();

            boolean crasher = true;
            int count =0;
            int jsonNb = 1;

            while (crasher) {
                if (line.length == 1 && (line[0].equals("") || line[0] == null )) {
                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                } else {
                    count ++;
                    //On crér l'objet Insee

                    if(line[20].equals("26000")){
                        Insee insee = new Insee(line[0],line[16],line[18],line[19],line[20],line[28],line[43]);
                        insees.add(insee);
                    }
                    if(count == 1000000){
                        System.out.println(insees.size());
                        count =0;
                        System.out.println(Integer.toString(jsonNb)+" Millions");

                        jsonNb++;
//                        insees = new ArrayList<Insee>();
                    }

                    if ((line = reader.readNext()) == null) {
                        crasher = false;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
                        try (FileWriter writer =new FileWriter("data/Insee/insee26000.json")) {
                            Gson gson = new Gson();
                            gson.toJson(insees, writer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

        return insees;
    }

    @Test
    void noProb() {
        List<Insee> inseeList = getInseeList();
        try (FileWriter writer =new FileWriter("data/insee.json")) {
            Gson gson = new Gson();
            gson.toJson(inseeList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
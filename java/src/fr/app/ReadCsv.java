package fr.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {

    private String csvFile;
    private boolean header;

    /**
     *
     * @param path
     */
    public ReadCsv (String path, boolean header){
        this.csvFile = path;
        this.header = header;
    }

    /**
     *
     * @param csvFile
     */
    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    /**
     *
     * @return
     */
    public String getCsvFile() {
        return csvFile;
    }

    public List<Country> read() {


        List<Country> countries = new ArrayList<Country>();
        String line = "";

        try (BufferedReader buffer = new BufferedReader(new FileReader(csvFile))){

            if (this.header){
                buffer.readLine(); // si header Ligne juste lue pour passer à la suite
            }

            while ((line = buffer.readLine()) != null) {
                    if ( line.equals("") ) {
                    continue;
                    }

                // System.out.println(line);
                        String[] countryLine = line.split(",");

                        Country country = new Country();

                        country.setId(Integer.parseInt(countryLine[0].trim()));

                        country.setName(countryLine[1].trim());

                        country.setAbbrev(countryLine[2].trim());

                        countries.add(country);

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return countries;
    }
}
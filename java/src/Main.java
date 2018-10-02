import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Country> result = null;
        CountryDAO dao = new CountryDAO();
        try {
            result = dao.findCoutries();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Test1 test = new Test1();
        Test1 test2 = new Test1();
        Test1 test3 = new Test1();
        boolean resultatTest = test.test1(result);
        boolean resultatTest2 = test2.test2(result);
        boolean resultatTest3 = test3.test3(result);
        System.out.println(resultatTest);
        System.out.println(resultatTest2);
        System.out.println(resultatTest3);
    }


}

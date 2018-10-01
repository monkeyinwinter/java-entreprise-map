package main.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        CSVFile csv = new CSVFile();

        for (Iterator it = csv.readCsv1().iterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }
    }
}

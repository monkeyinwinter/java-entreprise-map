package Class;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] arg) {

        File reposit;
        reposit = new File("/home/vincent/sites/java-entreprise-map/java/data");

        if (reposit.exists()) {

            List l = Reader.readCSV("country1.csv");
            System.out.println(l);

        } else {

            System.out.println("Dépot de fichiers introuvable");
        }
    }
}
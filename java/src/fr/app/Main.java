package fr.app;

public class Main {
    public static void main(String[] args){
        String csvFile = "/home/sylv/Java/java-entreprise-map/java/data/country1.csv";

        ReadCsv reader = new ReadCsv(csvFile, false);

        System.out.println(reader.read());
    }

}

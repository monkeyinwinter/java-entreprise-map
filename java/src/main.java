import com.mapJava.services.CompanyFactory;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        CompanyFactory factory =  new CompanyFactory();

       factory.read( 1, "data/siren.csv");
    }
}

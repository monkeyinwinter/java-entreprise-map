import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        PaysDao dao = new PaysDao(true);
        List<Pays> mylist = dao.read("data/country5.csv");

        for(Pays pays : mylist)
        {
            System.out.println(pays.toString());
        }
    }

}



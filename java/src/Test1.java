import java.util.List;

public class Test1 {

    public boolean test1(List<Country> result) {

        if (result.get(1).getName().equals("Belgique")) {
            System.out.println("La Belgique occupe bien l'index 1");
        } else {
            return false;
        }
        return true;
    }

    public boolean test2(List<Country> result) {

        if (result.get(0).getName().equals("France") && result.get(0).getIndicateur().equals("FR")) {
            System.out.println("FR correspond bien à la France");
        } else {
            return false;
        }
        return true;
    }

    public boolean test3(List<Country> result) {

        int nb_pays = result.size();
        int compare_to = 3;

        if (nb_pays == compare_to) {
            System.out.println("Oui il y a bien 3 pays");
        } else {
            return false;
        }
        return true;
    }
}

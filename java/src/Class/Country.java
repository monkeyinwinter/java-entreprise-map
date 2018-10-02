package Class;

public class Country {

    private int id;
    private String pays;
    private String code;

    public Country(int id, String pays, String code) {

        this.id = id;
        this.pays = pays;
        this.code = code;
    }

    @Override
    public String toString() {
        return pays;
    }


}

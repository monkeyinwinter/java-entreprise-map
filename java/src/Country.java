public class Country {

    public int id;
    public String name;
    public String indicateur;

    public Country (int idCountry, String nameCountry, String indicateurCountry) {
        this.id = idCountry;
        this.name = nameCountry;
        this.indicateur = indicateurCountry;
    }
    public Country() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setIndicateur(String indicateur) {
        this.indicateur = indicateur;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getIndicateur() {
        return indicateur;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.name + " " + this.indicateur + " walou ";
    }
}

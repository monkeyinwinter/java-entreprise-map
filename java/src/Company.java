import java.util.Arrays;

/**
 * @author gro
 * 02 / 10 / 2018
 */
public class Company {
    String name;
    String sector;
    String adress;
    String postcode;
    String city;
    String[] coord;

    public Company(String name, String sector, String adress, String postcode, String city, String[] coord) {
        this.name = name;
        this.sector = sector;
        this.adress = adress;
        this.postcode = postcode;
        this.city = city;
        this.coord = coord;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", adress='" + adress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", coord=" + Arrays.toString(coord) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getpostcode() {
        return postcode;
    }

    public void setpostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getCoord() {
        return coord;
    }

    public void setCoord(String[] coord) {
        this.coord = coord;
    }
}
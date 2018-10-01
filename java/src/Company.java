import java.lang.reflect.Array;

public class Company {

    public String sector;
    public String name;
    public String city;
    public int zipcode;
    public Array coord;

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setCoord(Array coord) {
        this.coord = coord;
    }

    public String getSector() {
        return sector;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public Array getCoord() {
        return coord;
    }

}

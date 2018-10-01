import java.lang.reflect.Array;

public class City {

    public int zipcode;
    public String name;
    public Array coord;

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Array coord) {
        this.coord = coord;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getName() {
        return name;
    }

    public Array getCoord() {
        return coord;
    }

}

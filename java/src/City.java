public class City {

    private String code;
    private String name;
    private String codePostal;
    private String geoLoc;


    public City(String code, String name, String codePostal, String geoLoc) {
        this.code = code;
        this.name = name;
        this.codePostal = codePostal;
        this.geoLoc = geoLoc;
    }

    @Override
    public String toString() {
        return "City{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", geoLoc='" + geoLoc + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getGeoLoc() {
        return geoLoc;
    }

    public void setGeoLoc(String geoLoc) {
        this.geoLoc = geoLoc;
    }
}
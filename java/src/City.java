public class City {

    private String code;
    private String name;
    private int codePostal;
    private String geoLoc;


    public City (String code, String name, int codePostal, String geoLoc){
        this.code = code;
        this.name = name;
        this.codePostal = codePostal;
        this.geoLoc = geoLoc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setGeoLoc(String geoLoc) {
        this.geoLoc = geoLoc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getGeoLoc() {
        return geoLoc;
    }

    public String getName() {
        return name;
    }
}

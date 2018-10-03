public class Ville {

    private Integer codePostal;
    private String commune;
    private String gps;


    public Ville(Integer codePostal, String commune, String gps) {//constructeur de la class pays
        setCodePostal(codePostal);
        setCommune(commune);
        setGps(gps);
    }

    public Ville() {//constructeur de la class Ville

    }

    public void setCodePostal(Integer codePostal) {//setter codePostal
        this.codePostal = codePostal;
    }
    public int getCodePostal() {// getter codePostal
        return this.codePostal.intValue();
    }


    public void setCommune(String Commune) {//setter Commune
        this.commune = Commune;
    }
    public String getCommune() {// getter code
        return this.commune;
    }// getter Commune


    public void setGps(String gps) {//setter gps
        this.gps = gps;
    }
    public String getGps() {// getter gps
        return this.gps;
    }

    @Override
    public String toString() {
        return "codePostal -> " + getCodePostal() + "Commune -> " + getCommune() + "gps -> " + getGps();
    }


}

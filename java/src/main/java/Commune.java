public class Commune {

    private Integer codePostal;
    private String nomCommune;
    private String Gps;

    public Commune(Integer codePostal, String nomCommune, String Gps) {//constructeur de la class pays
        setCodePostal(codePostal);
        setCommune(nomCommune);
        setGps(Gps);
    }

    public Commune() {//constructeur de la class Commune
    }

    public void setCodePostal(Integer codePostal) {//setter codePostal
        this.codePostal = codePostal;
    }
    public int getCodePostal() {// getter codePostal
        return this.codePostal.intValue();
    }

    public void setCommune(String Commune) {//setter Commune
        this.nomCommune = Commune;
    }
    public String getCommune() {// getter Commune
        return this.nomCommune;
    }

    public void setGps(String Gps) {//setter LatGps
        this.Gps = Gps;
    }
    public String getGps() {// getter Gps
        return this.Gps;
    }

    @Override
    public String toString() {
        return  getCodePostal() +
                getCommune() +
                getGps();
    }


}

public class Commune {

    private Integer codePostal;
    private String nomCommune;
    private String latGps;
    private String lonGps;


    public Commune(Integer codePostal, String nomCommune, String latGps, String lonGps) {//constructeur de la class pays
        setCodePostal(codePostal);
        setCommune(nomCommune);
        setLatGps(latGps);
        setLonGps(lonGps);
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

    public void setLatGps(String gps) {//setter LatGps
        this.latGps = latGps;
    }
    public String getLatGps() {// getter latGps
        return this.latGps;
    }

    public void setLonGps(String lonGps) {//setter lonGps
        this.lonGps = lonGps;
    }
    public String getLonGps() {// getter gps
        return this.lonGps;
    }

    @Override
    public String toString() {
        return "codePostal -> " + getCodePostal()
                + "Commune -> " + getCommune()
                + "lattitude gps -> " + getLatGps()
                + "longitude gps -> " + getLonGps();

    }


}

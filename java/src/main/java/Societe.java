public class Societe {

    private String Societe;
    private String commune;
    private String adresse;
    private Integer codePostal;
    private String activite;
    private String gps;

    public Societe(String Societe, String commune, String adresse, Integer codePostal, String activite, String gps) {//constructeur de la class pays
        setSociete(Societe);
        setCommune(commune);
        setAdresse(adresse);
        setCodePostal(codePostal);
        setActivite(activite);
        setGps(gps);
    }

    public Societe() {//constructeur de la class Societe
    }

    public void setSociete(String Societe) {//setter Societe
        this.Societe = Societe;
    }
    public String getSociete() {// getter Societe
        return this.Societe;
    }

    public void setCommune(String commune) {//setter commune
        this.commune = commune;
    }
    public String getCommune() {// getter commune
        return this.commune;
    }

    public void setAdresse(String adresse) {//setter adresse
        this.adresse = adresse;
    }
    public String getAdresse() {// getter adresse
        return this.adresse;
    }

    public void setCodePostal(Integer codePostal) {//setter codePostal
        this.codePostal = codePostal;
    }
    public Integer getCodePostal() {// getter codePostal
        return this.codePostal;
    }

    public void setActivite(String activite) {//setter codePostal
        this.activite = activite;
    }
    public String getActivite() {// getter codePostal
        return this.activite;
    }

    public void setGps(String gps) {//setter codePostal
        this.gps = gps;
    }
    public String getGps() {// getter codePostal
        return this.gps;
    }

    @Override
    public String toString() {
        return "Societe -> " + getSociete()
                + "Commune -> " + getCommune()
                + "Adresse -> " + getAdresse()
                + "code postal -> " + getCodePostal()
                + "Activite -> " + getActivite()
                + "Gps -> " + getGps();
    }


}

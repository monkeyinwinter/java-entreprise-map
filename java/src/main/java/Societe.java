public class Societe {

    private String societe;
    private String commune;
    private String[] adresse;
    private String codePostal;
    private String activite;
    private String[] gps;

    public Societe(String societe, String commune, String[] adresse, String codePostal, String activite, String[] gps) {//constructeur de la class pays
        setSociete(societe);
        setCommune(commune);
        setAdresse(adresse);
        setCodePostal(codePostal);
        setActivite(activite);
        setGps(gps);
    }

    public Societe() {//constructeur de la class Societe
    }

    public void setSociete(String societe) {//setter Societe
        this.societe = societe;
    }
    public String getSociete() {// getter Societe
        return this.societe;
    }

    public void setCommune(String commune) {//setter commune
        this.commune = commune;
    }
    public String getCommune() {// getter commune
        return this.commune;
    }

    public void setAdresse(String[] adresse) {//setter adresse
        this.adresse = adresse;
    }
    public String[] getAdresse() {// getter adresse
        return this.adresse;
    }

    public void setCodePostal(String codePostal) {//setter codePostal
        this.codePostal = codePostal;
    }
    public String getCodePostal() {// getter codePostal
        return this.codePostal;
    }

    public void setActivite(String activite) {//setter codePostal
        this.activite = activite;
    }
    public String getActivite() {// getter codePostal
        return this.activite;
    }

    public void setGps(String[] gps) {//setter codePostal
        this.gps = gps;
    }
    public String[] getGps() {// getter codePostal
        return this.gps;
    }

    @Override
    public String toString() {
        return  getSociete() + "," +
                getAdresse()[0] + " " + getAdresse()[1] + " " + getAdresse()[2] + "," +
                getCodePostal() + "," +
                getCommune() + "," +
                getActivite() + "," +
                getGps()[0]+ "/" + getGps()[1];
    }


}

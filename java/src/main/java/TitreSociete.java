public class TitreSociete {

    private String TitreSociete;
    private String TitreCommune;
    private String TitreAdresse;
    private String TitreCodePostal;
    private String TitreActivite;
    private String TitreGps;

    public TitreSociete(String TitreSociete, String TitreCommune, String TitreAdresse, String TitreCodePostal, String TitreActivite, String TitreGps) {//constructeur de la class pays
        setTitreSociete(TitreSociete);
        setTitreCommune(TitreCommune);
        setTitreAdresse(TitreAdresse);
        setTitreCodePostal(TitreCodePostal);
        setTitreActivite(TitreActivite);
        setTitreGps(TitreGps);
    }

    public TitreSociete() {//constructeur de la class Societe
    }

    public void setTitreSociete(String TitreSociete) {//setter Societe
        this.TitreSociete = TitreSociete;
    }
    public String getTitreSociete() {// getter Societe
        return this.TitreSociete;
    }

    public void setTitreCommune(String TitreCommune) {//setter commune
        this.TitreCommune = TitreCommune;
    }
    public String getTitreCommune() {// getter commune
        return this.TitreCommune;
    }

    public void setTitreAdresse(String TitreAdresse) {//setter adresse
        this.TitreAdresse = TitreAdresse;
    }
    public String getTitreAdresse() {// getter adresse
        return this.TitreAdresse;
    }

    public void setTitreCodePostal(String TitreCodePostal) {//setter codePostal
        this.TitreCodePostal = TitreCodePostal;
    }
    public String getlTitreCodePostal() {// getter codePostal
        return this.TitreCodePostal;
    }

    public void setTitreActivite(String TitreActivite) {//setter codePostal
        this.TitreActivite = TitreActivite;
    }
    public String getTitreActivite() {// getter codePostal
        return this.TitreActivite;
    }

    public void setTitreGps(String TitreGps) {//setter codePostal
        this.TitreGps = TitreGps;
    }
    public String getTitreGps() {// getter codePostal
        return this.TitreGps;
    }

    @Override
    public String toString() {
        return  getTitreSociete() +
                getTitreCommune() +
                getTitreAdresse() +
                getlTitreCodePostal() +
                getTitreActivite() +
                getTitreGps();
    }
}

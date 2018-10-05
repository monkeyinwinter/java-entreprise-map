public class TitreCommune
{
    private String TitreCommuneCodePostal;
    private String TitreCommuneNomCommune;
    private String TitreCommuneGps;

    public TitreCommune(String TitreCommuneCodePostal, String TitreCommuneNomCommune, String TitreCommuneGps) {//constructeur de la class pays
        setCodePostal(TitreCommuneCodePostal);
        setTitreCommuneNomCommune(TitreCommuneNomCommune);
        setTitreCommuneGps(TitreCommuneGps);
    }

    public TitreCommune() {//constructeur de la class Commune
    }

    public void setCodePostal(String TitreCommuneCodePostal) {//setter codePostal
        this.TitreCommuneCodePostal = TitreCommuneCodePostal;
    }
    public String getCodePostal() {// getter codePostal
        return this.TitreCommuneCodePostal;
    }

    public void setTitreCommuneNomCommune(String TitreCommuneNomCommune) {//setter Commune
        this.TitreCommuneNomCommune = TitreCommuneNomCommune;
    }
    public String getTitreCommuneNomCommune() {// getter Commune
        return this.TitreCommuneNomCommune;
    }

    public void setTitreCommuneGps(String TitreCommuneGps) {//setter LatGps
        this.TitreCommuneGps = TitreCommuneGps;
    }
    public String getTitreCommuneGps() {// getter Gps
        return this.TitreCommuneGps;
    }

    @Override
    public String toString() {
        return  getCodePostal() +
                getTitreCommuneNomCommune() +
                getTitreCommuneGps();
    }
}

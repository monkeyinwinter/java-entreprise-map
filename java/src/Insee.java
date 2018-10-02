/**
 * @author gro
 * 02 / 10 / 2018
 */
public class Insee {

    private String SIREN;
    private String NUMVOIE;
    private String TYPVOIE;
    private String LIBVOIE;
    private String CODPOS;
    private String LIBCOM;
    private String LIBAPET;

    public Insee(String SIREN, String NUMVOIE, String TYPVOIE, String LIBVOIE, String CODPOS, String LIBCOM, String LIBAPET) {
        this.SIREN = SIREN;
        this.NUMVOIE = NUMVOIE;
        this.TYPVOIE = TYPVOIE;
        this.LIBVOIE = LIBVOIE;
        this.CODPOS = CODPOS;
        this.LIBCOM = LIBCOM;
        this.LIBAPET = LIBAPET;
    }

    @Override
    public String toString() {
        return "Insee{" +
                "SIREN='" + SIREN + '\'' +
                ", NUMVOIE='" + NUMVOIE + '\'' +
                ", TYPVOIE='" + TYPVOIE + '\'' +
                ", LIBVOIE='" + LIBVOIE + '\'' +
                ", CODPOS='" + CODPOS + '\'' +
                ", LIBCOM='" + LIBCOM + '\'' +
                ", LIBAPET='" + LIBAPET + '\'' +
                '}';
    }

    public String getSIREN() {
        return SIREN;
    }

    public void setSIREN(String SIREN) {
        this.SIREN = SIREN;
    }

    public String getNUMVOIE() {
        return NUMVOIE;
    }

    public void setNUMVOIE(String NUMVOIE) {
        this.NUMVOIE = NUMVOIE;
    }

    public String getTYPVOIE() {
        return TYPVOIE;
    }

    public void setTYPVOIE(String TYPVOIE) {
        this.TYPVOIE = TYPVOIE;
    }

    public String getLIBVOIE() {
        return LIBVOIE;
    }

    public void setLIBVOIE(String LIBVOIE) {
        this.LIBVOIE = LIBVOIE;
    }

    public String getCODPOS() {
        return CODPOS;
    }

    public void setCODPOS(String CODPOS) {
        this.CODPOS = CODPOS;
    }

    public String getLIBCOM() {
        return LIBCOM;
    }

    public void setLIBCOM(String LIBCOM) {
        this.LIBCOM = LIBCOM;
    }

    public String getLIBAPET() {
        return LIBAPET;
    }

    public void setLIBAPET(String LIBAPET) {
        this.LIBAPET = LIBAPET;
    }
}
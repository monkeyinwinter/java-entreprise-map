public class TitrePays {
    private String id;
    private String name;
    private String code;

    public TitrePays(String id, String name, String code) {//constructeur de la class pays
        setName(name);
        setId(id);
        setCode(code);
    }

    public TitrePays() {//constructeur de la class pays

    }

    public void setId(String id) {//setter id
        this.id = id;
    }
    public String getId() {// getter id
        return this.id;
    }

    public void setName(String name) {//setter name
        this.name = name;
    }
    public String getName() {// getter name
        return this.name;
    }

    public void setCode(String code) {//setter code
        this.code = code;
    }
    public String getCode() {// getter code
        return this.code;
    }

    @Override
    public String toString() {
        return getId()
                + getName()
                + getCode();
    }


}

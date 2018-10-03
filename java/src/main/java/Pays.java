
public class Pays {
    private Integer id;
    private String name;
    private String code;

    public Pays(Integer id, String name, String code) {//constructeur de la class pays
        setName(name);
        setId(id);
        setCode(code);
    }

    public Pays() {//constructeur de la class pays

    }


    public void setId(Integer id) {//setter id
        this.id = id;
    }
    public int getId() {// getter id
        return this.id.intValue();
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
        return "Id -> " + getId() + "Name -> " + getName() + "Code -> " + getCode();
    }
}
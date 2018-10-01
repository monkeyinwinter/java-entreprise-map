package main.company;

public class Country {

    private int id;
    private String name;
    private String code;


     public int getId() {
        return id;
    }

     void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

     void setCode(String code) {
        this.code = code;
    }
    public String toString() {
        return "id : "+ getId()+ ", name: "+getName()+", code : "+getCode();
    }
}

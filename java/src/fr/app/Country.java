package fr.app;

public class Country {

    public int id;
    public String name;
    public String abbrev;



    public Country() {


    }

    public Country (int id,String name, String abbrev) {
        this.setId(id);
        this.setName(name);
        this.setAbbrev(abbrev);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    @Override
    public String toString() {
        return  getId() + "," + getName() + "," + getAbbrev();
    }

    @Override
    public boolean equals(Object obj) {
        Country country = (Country) obj;

        if (country.getId() == this.getId() && country.getName().equals(this.getName()) && country.getAbbrev().equals(this.getAbbrev())){
            return true;
        }else{
            return false;
        }
    }
}

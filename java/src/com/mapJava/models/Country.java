package com.mapJava.models;


public class Country {

    public String  id;
    public String name;
    public String code;

    public Country(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ",name=" + this.name + ",code=" + this.code +"]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        if (!this.id.contentEquals(((Country)obj).id)) { return false; }
        if (!this.name.contentEquals(((Country)obj).name)) { return false; }
        if (!this.code.contentEquals(((Country)obj).code)) { return false; }
        else{
            return true;
        }
    }
}

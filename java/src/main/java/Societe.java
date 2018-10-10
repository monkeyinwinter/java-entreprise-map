public class Societe {

    private String name;
    private String city;
    private String[] adress;
    private String postcode;
    private String sector;
    private float[] coord;

    public Societe(String name, String city, String[] adress, String postcode, String sector, float[] coord)//constructeur de la class pays
    {
        setName(name);
        setCity(city);
        setAdress(adress);
        setPostcode(postcode);
        setSector(sector);
        setCoord(coord);
    }

    public Societe()//constructeur de la class Societe
    {
    }

    public void setName(String name)
    {//setter Societe
        this.name = name;
    }
    public String getName()
    {// getter Societe
        return this.name;
    }

    public void setCity(String city)
    {//setter commune
        this.city = city;
    }
    public String getCity()
    {// getter commune
        return this.city;
    }

    public void setAdress(String[] adress)
    {//setter adresse
        this.adress = adress;
    }
    public String[] getAdress()
    {// getter adresse
        return this.adress;
    }

    public void setPostcode(String postcode)
    {//setter getPostcode
        this.postcode = postcode;
    }
    public String getPostcode()
    {// getter getPostcode
        return this.postcode;
    }

    public void setSector(String sector)
    {//setter setSector
        this.sector = sector;
    }
    public String getSector()
    {// getter setSector
        return this.sector;
    }

    public void setCoord(float[] coord)
    {//setter setCoord
        this.coord = coord;
    }
    public float[] getCoord()
    {// getter setCoord
        return this.coord;
    }

    @Override
    public String toString()
    {
        return  getName() + "," +
                getAdress()[0] + " " + getAdress()[1] + " " + getAdress()[2] + "," +
                getPostcode() + "," +
                getCity() + "," +
                getSector() + "," +
                getCoord()[0]+ "," + getCoord()[1];
    }


}

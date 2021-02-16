package clone;

public class AdressClone implements Cloneable {
	private String street;
    private int house;
 
 
    public AdressClone(String street, int house) {
        this.street = street;
        this.house = house;
    }
 
    public AdressClone(int house) {
        this.house = house;
    }
 
    public int getHouse() {
        return house;
    }
 
    public void setHouse(int house) {
        this.house = house;
    }
 
    public AdressClone clone() throws CloneNotSupportedException {
    	return (AdressClone) super.clone();
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", house=" + house +
                '}';
    }

}

package clone;

public class ConstructorCloneAddress {
	private String street;
    private int house;
 
 
    public ConstructorCloneAddress(String street, int house) {
        this.street = street;
        this.house = house;
    }
 
    public ConstructorCloneAddress(ConstructorCloneAddress a) {
       this(a.getStreet(), a.getHouse());
    }
 
    public ConstructorCloneAddress(int house) {
        this.house = house;
    }
 
    public int getHouse() {
        return house;
    }
 
    public void setHouse(int house) {
        this.house = house;
    }
 
 
    @Override
    protected ConstructorCloneAddress clone() throws CloneNotSupportedException {
        return (ConstructorCloneAddress) super.clone();
    }
 
    public String getStreet() {
        return street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", house=" + house +
                '}';
    }

}

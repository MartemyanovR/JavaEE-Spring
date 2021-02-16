package clone;

public class ConstructorCloneUser {
	private int id;
    private  String name;
    private ConstructorCloneAddress address;
    private final double d;
 
    public ConstructorCloneUser(int id, String name, ConstructorCloneAddress address, final Double d) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.d = d;
    } 
 
 
    public ConstructorCloneUser (ConstructorCloneUser u) {
        this(u.getId(), u.getName(), new ConstructorCloneAddress(u.address),u.d);
    }
 
    public ConstructorCloneAddress getAddress() {
        return address;
    }
 
    public void setAddress(ConstructorCloneAddress address) {
        this.address = address;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
 
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address + " " + d +
                '}';
    }
}

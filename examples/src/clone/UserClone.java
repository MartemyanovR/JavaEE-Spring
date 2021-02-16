package clone;

import java.util.Arrays;

public class UserClone implements Cloneable{
	private final String name;
	private int id;
	private AdressClone address;
	public static double d = 0.1d;
	private int[] arrClone = {1,2,3,4,5};
	
	public UserClone(int id, String name, AdressClone address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
 
    public AdressClone getAddress() {
        return address;
    }
 
    public void setAddress(AdressClone address) {
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
 
/*    public void setName(String name) {
        this.name = name;
    }*/
    
    public void setArrClone(int i, int val) {
    	this.arrClone[i] = val;
    }
 
    public UserClone clone() throws CloneNotSupportedException {
    	UserClone userClone = (UserClone) super.clone();
    	//значение final поля не возможно изменить 
   // 	userClone.name = "GG";
    	//static поле можно изменить
    	UserClone.d = 1d;
    	//отдельное клонированние ссылочной переменной объекта
    	userClone.address = (AdressClone) address.clone();
        return userClone;
    }
 
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address + " " + d + 
                " , array: " + Arrays.toString(arrClone) + 
                '}';
    }

}

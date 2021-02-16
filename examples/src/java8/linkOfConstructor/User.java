package java8.linkOfConstructor;

public class User {
	private String name;
	private String lastN;
	
	public User() {
		}

	public User(String name) {
		this.name = name;
	}

	public User(String name, String lastN) {
		this.name = name;
		this.lastN = lastN;
	}

	public String getName() {
		return name;
	} 

	public String getLName() {
		return lastN;
	} 
}

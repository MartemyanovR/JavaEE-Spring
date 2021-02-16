package java8.linkOfConstructor;

public class Usersurrogate extends User {
	private String name;
	private String lastN;

	public Usersurrogate(String name) {
	
		this.name = name;
	}

	public Usersurrogate(String name, String lastN) {
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

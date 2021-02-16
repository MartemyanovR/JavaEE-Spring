package collection;

import java.util.ArrayList;

public  class Pizza {
	String name = null;
	ArrayList<String> topping = new ArrayList<>();
	
	public Pizza(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNameTop() {		
		return getName().toString() + ": " + topping.toString();
	}

}

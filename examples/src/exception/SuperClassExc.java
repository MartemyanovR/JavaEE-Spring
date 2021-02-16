package exception;

import java.io.IOException;

public class SuperClassExc {
	
	private String name;
	
	public SuperClassExc() {		
	}
	
	public SuperClassExc(String name) throws IOException {
		this.name = name;
	}
	
	public String getName() throws IOException {
		return name;
	}

}

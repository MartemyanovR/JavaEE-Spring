package inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SuperClass {
	
	public SuperClass() {
		
	}	
	
	public SuperClass(int i) {
		
	}
	
	
	public Object interestingMethod() throws IOException{
        System.out.println("Superclass's interesting method.");
        return null;
    }

    void exampleMethod() throws IOException  {
        interestingMethod();
    }

}

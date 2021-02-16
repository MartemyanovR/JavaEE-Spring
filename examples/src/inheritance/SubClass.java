package inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass {
	

	public SubClass() {
		//super();
	}
	
	public SubClass(int a) {
		super();
		//Constructor call must be the first statement in a constructor
		//super(5);
	}
	

	//можно использовать exception который является подклассом в методе суперкласса
	public Integer interestingMethod() throws FileNotFoundException{
        System.out.println("Subclass's interesting method.");
        return null;
    }

	public static void main(String[] args) throws IOException {
		SuperClass me = new SubClass();
		if (me instanceof SubClass ) {
			System.out.println("@@");
		}
        me.exampleMethod();
        System.out.println(me.getClass());
        
	}

}

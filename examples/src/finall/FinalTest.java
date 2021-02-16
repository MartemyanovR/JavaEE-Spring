package finall;
import java.util.Random;

public class FinalTest {
	public static void main (String[] args) {
	Final2 f2 = new Final2(0);
	Final1 f1 = new Final1(5);
	System.out.println(f1.f+1);
	System.out.println(f1.f);
	System.out.println(f1.f+1);
	f2.f();
	f2.fg();
	Final1 f3 = f2;
	f3.g();
	System.out.println("__________________");
	Random r = new Random(50);
	
	System.out.println(r);
	//сужение типов,  компилируется, но бросает exc
	Final2 f4 = (Final2)f1;
	//f4.f();
	//f4.fg();
	//f4.g();
	
	
	}
}

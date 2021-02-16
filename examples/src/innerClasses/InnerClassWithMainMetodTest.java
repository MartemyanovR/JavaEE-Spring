package innerClasses;

public class InnerClassWithMainMetodTest {
	public static void main(String[] args) {
		
		InnerClassWithMainMetod3 in3 = new InnerClassWithMainMetod3();
		InnerClassWithMainMetod3.InnerMain2 in2 = in3.new InnerMain2();
		InnerClassWithMainMetod3.meth();
		in3.meth();
	}

}

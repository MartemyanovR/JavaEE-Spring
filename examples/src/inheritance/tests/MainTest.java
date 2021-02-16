package inheritance.tests;

public class MainTest {

	public static void main(String[] args) {		
		
		SuperClassTest sct =(SuperClassTest) new SubClassTest();
		SuperClassTest superct = new SubClassTest();		
		
		String str = (String) superct.meth("hello");
		//superct.meth1();
	/*	System.out.println(str);
		int i = 100;
		Integer j = 100;
		Integer ii = new Integer(j);  //здесь пул не ипользуется
		if(j ==i) {
			System.out.println("!!!");
		}
		long l =  1;
		Long l1 = (long) 1;
		Long ll = new Long(1);
		if(ll==l1) {
			System.out.println("&&&");
		}
		short sh = 55;
		Short s = 55;
		Short shr = new Short(s);
		if(s==shr) {
			System.out.println("^^^");
		}*/
	}

}

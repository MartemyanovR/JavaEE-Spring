package string;

public class StringImmutable {

	public static void main(String[] args) {
		String a = "abc";
		
		//3 excluding
		String b = "abc".substring(0, 3);
		
		//String working with char
		char[] c = {'a','b','c'};
		String a1 = new String(c);
		System.out.println(a==a1);
		System.out.println(b);
		System.out.println();
		

		String sNull = null;
		//String sNull2 = new String(sNull); NPE		
		System.out.println(null + sNull);
		
		char c1 = '\u005f';
		System.out.println(c1);
		String delete = "System.out.println";
		String deleter = null;
		if (delete.contains("s"))
			deleter = delete.replace("s",	"");
		System.out.println(deleter);
		
	}

}

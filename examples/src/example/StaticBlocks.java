package example;

public class StaticBlocks {
	
	String str1,str2;
	static String str3,str4;
	static String str5 = "str5";
	
	static {
		str3 = "str3";
		System.out.println(str3);
	}
	static {
		System.out.println(str4);
		str4 = "str4";		
	}

	{
		str1 = "str1";
		System.out.println(str1);				
	}
	
	StaticBlocks() {
		System.out.println(str5);
	}
	 void staat () {
		str2 = "__";
		System.out.println(str2);
	}
	
}

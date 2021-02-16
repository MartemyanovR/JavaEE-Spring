package string;

public class StringNull {

	public static void main(String[] args) {
		String s = null;
		String s2 = "null";
	//	StringBuilder sb = new StringBuilder(s);  NPE
		StringBuilder sb2 = new StringBuilder(s2);
	//	System.out.println(s.charAt(0));   NPE
	//	System.out.println(s.concat(s2)); NPE
	//	System.out.println(sb); 	NPE
		System.out.println(sb2.append(s));   
		System.out.println(s+s2+sb2);
		System.out.println(null + s);
		System.out.println(s + null);
		System.out.println(sb2 + " " +  null); 
	//	System.out.println((String)sb2 + null); //compale error
	//	System.out.println(null + sb2);  compale error
	}

}

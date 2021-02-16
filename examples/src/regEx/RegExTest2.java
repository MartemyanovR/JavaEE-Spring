package regEx;

import java.util.regex.Pattern;

public class RegExTest2 {

	public static void main(String[] args) {
		String text = "1st";
		String text1 = "7.12.18";
	    Pattern pattern = Pattern.compile("\\.");
	    String[] strings = pattern.split(text,2);
	    for (String s : strings) {
	        System.out.println(s);
	    }
	    System.out.println("---------");
	    String[] strings1 = pattern.split(text);
	    for (String s : strings1) {
	        System.out.println(s);
	    }
	    Boolean b = Pattern.matches("(Fir|1)st", text);
	    System.out.println(b);
	    Boolean b1 = Pattern.matches("7[-./]12[-./]18", text1);
	    System.out.println(b1);
	}

}

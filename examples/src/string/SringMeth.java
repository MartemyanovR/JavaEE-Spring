package string;

import java.util.Arrays;

public class SringMeth {

	public static void main(String[] args) {
		String str = "aacdefaa";
	      System.out.println("string = " + str);
	      // returns the index within this String
	      int retval = str.offsetByCodePoints(2,1);	      
	      // prints the index
	      System.out.println("index = " + retval);	      
	      System.out.println("string = " + str);
	      CharSequence firstString = "15345";
	      String str1 = "15345"; 
	      String nul = null;
	      StringBuilder sb = new StringBuilder("15345");
	      System.out.println(str1.equals(firstString));
	      System.out.println(str1.equals(sb));
	      System.out.println(str1.contentEquals(sb));
	      char п = 'п';
	      char д = 'д';
	      int i = п;
	      int i1 =д; 
	      System.out.println(i);
	      System.out.println(i1);
	      System.out.println(str1.compareTo((String) firstString));
	      
	      String Str1 = new String("Welcome to Tutorialspoint.com");
	      String Str2 = new String("Tutorials");
	      String Str3 = new String("TUTORIALS");
	      System.out.print("Return Value :" );
	      System.out.println(Str1.regionMatches(11, Str2, 0, 8));
	      
	      String rus = "dfrrrrrrпа123";
	      System.out.println(rus.codePointAt(0));
	      System.out.println(rus.indexOf(1087));
	      System.out.println(str.concat("_"));
	      System.out.println(rus.replace('r', 'd'));
	      System.out.println(rus.contains(sb));
	      char[] ch = str.toCharArray();
	      System.out.println(ch.toString()  + " " + Arrays.toString(ch));
	      
	}

}

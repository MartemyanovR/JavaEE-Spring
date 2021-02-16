package string;

public class CharSequenceTest {
	public static void main(String[] args) {
		 CharSequence str = new String("Hello from String");
	//	 soutCharSequence(str);
		 CharSequence sb = new StringBuilder("Hello from StringBuilder");
	//	 soutCharSequence(sb);  //exc in 38line
		 StringBuilder sb1 = new StringBuilder("Hello from StringBuilder_1");
		 soutCharSequence(sb1.toString());
		 System.out.println();
		 CharSequence firstString = "building";		 
		 CharSequence firstString1 = "building";		 
		 String secondString = "building";
		 String secondString1 = "building";
		 System.out.println(secondString.compareTo(secondString1));
		 System.out.println(firstString.toString().compareTo(secondString));
		 StringBuilder sbuild = new StringBuilder("baeldung");
		 StringBuilder sbuild2 = new StringBuilder("baeldung");
		 System.out.println(firstString == firstString1);
		 System.out.println(secondString == secondString1);
		 System.out.println(secondString == firstString);
		 System.out.println(sbuild == sbuild2);
		 int i = System.identityHashCode(sbuild);
		 int i1 = sbuild2.hashCode();
		 System.out.println("i=" + i + " i1=" + i1 + " " + (i == i1));
		 sbuild.append("ffgddfgfg1");
		 i = System.identityHashCode(sbuild);
		 System.out.println(i);
		 int y = System.identityHashCode(secondString);
		 int y1 = secondString.hashCode();
		 //значения разные потому что в string HC переопределен
		 System.out.println("y=" + y + " y1=" + y1 + " " + (y == y1));
		// StringBuilder ssb ="df";		 
	}

	public static void soutCharSequence(CharSequence ch) {
	     System.out.println(ch.getClass().getName());
	     System.out.println(ch);
	     if (ch instanceof CharSequence) {
	         System.out.println(((String) ch).toUpperCase());
	      }
	}

}

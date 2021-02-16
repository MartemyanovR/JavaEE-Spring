package example;

import java.util.HashSet;

public class StringHolderTest {

	public static void main(String[] args) {
		final int a;
		a=5;
		//a=4;
		System.out.println(a);
		 StringHolder sh = new StringHolder(";blert");
		    HashSet h = new HashSet();
		    h.add(sh);
		    sh.setstring(";moo");
		    System.out.println(h.contains(sh));
		    System.out.println(h.size());
		    System.out.println(h.iterator().next());
		    char twoSpace = 'f'; 
			char oneSpace = 'h';
		    String str = "fhg hfgh";
		    
				str = str.replace('f', 'h');
				
			
		    System.out.println(str);

	}

}

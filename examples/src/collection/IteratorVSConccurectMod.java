package collection;

import java.util.ArrayList;
import java.util.List;

public class IteratorVSConccurectMod {

	public static void main(String[] args) {
		 List<String> list= new ArrayList<>();
		 list.add("A");
		 list.add("B");
		 list.add("C");
		 for(String s : list) {
			 if(s.equals("A")) {
				 list.remove("C");
		 }
			 System.out.println(s);
		 }
	}

}

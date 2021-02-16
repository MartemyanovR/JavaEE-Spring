package comparator;

import java.util.Comparator;

public class MilkComparator implements Comparator<Milk>{
	
	 public int compare(Milk obj1, Milk obj2)
	    {
	        String str1 = obj1.getName();
	        String str2 = obj2.getName();
	            
	        return str1.compareTo(str2);
	    }

}

package comparator;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product>{
	
	 public int compare(Product obj1, Product obj2)
	    {
	        String str1 = obj1.getName();
	        String str2 = obj2.getName();
	            
	        return str1.compareTo(str2);
	    } 
	 
	// Comparator<Product> productNameComp = Comparator.comparing((Product product) -> product.getName());

}

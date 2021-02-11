package package1;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Store {
	
	private List<Product> listProduct;
	//private Product[] products;
	@Value("${nameStore}")
	private String nameStore;
	@Value("${rating}")
	private int rating;
	
	public Store(Product ... product) {
		this.listProduct = Arrays.asList(product);		
	}
	
	public void doing() {
		for(Product product : listProduct)
		product.applied();
	}
	
	public String toString() {
		return getNameStore() + ", rating: " + getRating();
	}

	public String getNameStore() {
		return nameStore;
	}

	public int getRating() {
		return rating;
	}
	
	
}

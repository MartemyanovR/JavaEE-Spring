package comparator;

public class Product implements Comparable<Product> {
	 private String name;
	    private float  price;
	    public int  quantity;
	    
	    public Product (String name, float price, int quantity)
	    {
	        this.name     = name;
	        this.price    = price;
	        this.quantity = quantity;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public float getPrice() {
	        return price;
	    }
	    public void setPrice(int price) {
	        this.price = price;
	    }
	    public int getQuantity() {
	        return quantity;
	    }
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	    @Override
	    public String toString()
	    {
	        return "Nmae '" + name + "', cost "
	                                + String.valueOf (price)
	                                + ", quntity - "
	                                + String.valueOf (quantity);
	    }
	    
		@Override
		public int compareTo(Product o) {
			
			return getName().compareTo(o.getName());
		}
	
	
	
}

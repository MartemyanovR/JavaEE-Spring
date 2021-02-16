package example;

public class Just {
	private String just;
	
		public Just(String just) {
			System.out.println(just);
			this.just=just;
		}
	
		public String getJust() {
			return just;
		}
		
		public void setJust(String j) {
			just=j;
			System.out.println(j);
		}
		
		enum Animal{
			Dog,Cat,Hen;
		}
}

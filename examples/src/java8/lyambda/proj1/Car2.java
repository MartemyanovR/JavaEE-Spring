package java8.lyambda.proj1;

public class Car2{
	private String color;
	
	public Car2(String c) {
		this.color = c;
	}

/*	@Override
	public boolean carFilter() {
		return color == "Red" ? true : false;
	}   */
	CarFilter cf = new CarFilter() {			
		@Override
		public boolean carFilter() {
			return color == "Red" ? true : false;
		}
	};

}

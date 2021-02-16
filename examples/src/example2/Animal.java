package example2;
public interface Animal {
		
	void eat();
	void walk();
	void getCalor();
	
	static class Calor {
		private String calor;
		public Calor (String calor) {
			this.calor = calor;
		}
		
		public String colorM() {
			return calor;
		}
	}

}

package java8.lyambda.proj1;

public  class Car {
	private int wheel;
	private String color;
	private Form form;
	

	public Car(int wheel, String color, Form form) {
		this.wheel = wheel;
		this.color = color;
		this.form = form;		
	}	
	
	public void info() {
		System.out.println("This is car" + this.toString());
	}
	
	
	public int getWheel() {
		return wheel;
	}
	
	public String getColor() {
		return color;
	}

	public Form getForm() {
		return form;
	}			
	
	
}

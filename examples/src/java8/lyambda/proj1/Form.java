package java8.lyambda.proj1;

enum Form {
	SEDAN(2.5),CROSS(2),LIFTBACK(1.8),HATCHBACK(1.5),SUV(2.2);
	private double dopSize;
	Form(double size) {
		this.dopSize = size;
	}
	
	public double getSize() {
		return dopSize;
	}
}

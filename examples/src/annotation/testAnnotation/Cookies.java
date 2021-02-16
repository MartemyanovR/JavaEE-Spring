package annotation.testAnnotation;

@ControlledObject(name = "biscuits")
public class Cookies {
	
	@StatrObject
	public void createCookies() {
		System.out.println("Cokkies create");
	}
	
	@StopObject
	public void stopCookies() {
		System.out.println("Stop cookies");
	}
	

}

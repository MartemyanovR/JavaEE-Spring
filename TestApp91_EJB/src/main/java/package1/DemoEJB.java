package package1;

import javax.ejb.Stateless;

@Stateless()
public class DemoEJB {

	public static String hello() {
		return "Hello World";
	}
}

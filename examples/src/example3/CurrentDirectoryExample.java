package example3;


public class CurrentDirectoryExample {

	public static void main(String[] args) {
		String current = System.getProperty("user.dir");
        System.out.println("Current working directory in Java : " + current);

	}

}

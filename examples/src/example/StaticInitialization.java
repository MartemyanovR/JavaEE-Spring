package example;

public class StaticInitialization {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Start");
		System.out.println("Start");
		Class.forName(StaticBlocks.class.getName());
		StaticBlocks stBl = new StaticBlocks();
		int a = 0;
		while(true) {
			if(a == 0)
				a = 5;
			else 
				return;
		}	
	}

}

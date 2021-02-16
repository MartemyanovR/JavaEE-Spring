package innerClasses;

public interface IClassInInInterface {
	void printHello();
	
	class Print implements IClassInInInterface {
		public static void main(String[] args){
			new Print().printHello();
		}
		

		@Override
		public void printHello() {
			System.out.println("Hello from Interface!");
		}
		
		
	}

}

package exception;

import java.util.Random;

public class SimpleClass {
	private final String[] str; 
	private final int size;
	
	
	public SimpleClass(int size) {
		this.size = size;
		str = new String[size];
	}
	//метод генеррует исключение
	public void meth() throws ArrayIndexOutOfBoundsException {
		Random random = new Random();
		//цикл генеррует исключение
		/*for(int i = 0; i<str.length+1; i++) {
			str[i] = String.valueOf(i+1);
		}*/
		//метод-модель для работы способа возобновления
		for(int i = 0; i<str.length; i++) {
			str[random.nextInt(str.length * 2)] = String.valueOf(i+1);
		}
		this.display();
	}
	private void display() {
		
		for (String s : str) {
		System.out.print(s + " ");
		}
	}	
}

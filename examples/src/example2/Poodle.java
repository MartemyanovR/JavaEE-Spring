package example2;
public class Poodle extends Dog {
	int age=1;
	public Poodle(int age) {
		super(age);				//конструктор копированием
		System.out.println(super.age + " years");	//используем переменную базового класса	
	}
	
	public void eat(int t) {		//если изменить сигнатуру(явный параметр) метод теряет связь с родит методом
		System.out.println("foods for poodle");
	}
	public Long getAge() {
		return null;
	}
	
}

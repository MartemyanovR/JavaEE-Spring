package reflection.proxy.javaRush;


/*
 * Представим, что этот класс мы получили в составе готовой JAR-библиотеки и не можем просто взять и переписать его код.
 *  К примеру, мы не знаем, какой именно метод будет вызван у нашего объекта,
 *   а потому хотим, чтобы при вызове любого из них человек сначала говорил «Привет!»
 */
public class Man implements Person{
	   private String name;
	   private int age;
	   private String city;
	   private String country;

	   public Man(String name, int age, String city, String country) {
	       this.name = name;
	       this.age = age;
	       this.city = city;
	       this.country = country;
	   }

	   @Override
	   public void introduce(String name) {

	       System.out.println("Меня зовут " + this.name);
	       this.sayAge(getAge());
	   }

	   @Override
	   public void sayAge(int age) {
	       System.out.println("Мне " + this.age + " лет");
	   }

	   @Override
	   public void sayFrom(String city, String country) {

	       System.out.println("Я из города " + this.city + ", " + this.country);
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	   
	   

}

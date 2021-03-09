package collectionsClass;

public class Cat extends Feline implements Comparable<Cat>{
	
	
	public String name;
	public int age;

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Cat o) {
		return (this.age > o.age) ? 1 : ((this.age < o.age) ? -1 : 0);
	}

}

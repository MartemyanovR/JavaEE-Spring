package collectionsClass;

public class Animal {
	
	private String clas;
	private int weight;
	
	public Animal() {}
	
	public Animal(String clas, int weight) {
		super();
		this.clas = clas;
		this.weight = weight;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	@Override
	public String toString() {
		return "Animal [clas=" + clas + ", weight=" + weight + "]";
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

}

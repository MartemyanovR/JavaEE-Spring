package collectionsClass;

public class Feline extends Animal {

	private int agility;
	
	public Feline() {}

	public Feline(int agility) {
		super();
		this.agility = agility;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	@Override
	public String toString() {
		return "Feline [agility=" + agility + "]";
	}
}

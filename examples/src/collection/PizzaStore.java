package collection;

public class PizzaStore {

	public static void main(String[] args) {
		Pizza domin = new PizzaFourCheese();
		Pizza dodo = new PizzaPepperoni();
		System.out.println(domin.getNameTop());
		System.out.println(dodo.getNameTop());

	}

}

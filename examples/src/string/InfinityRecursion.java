package string;

public class InfinityRecursion {
	
	@Override
	public String toString() {
		//StackOverflowError
		System.out.println(this);
		return "This is recursion" + super.toString() + ".";
	}

	public static void main(String[] args) {
		InfinityRecursion ir = new InfinityRecursion();
		System.out.println(ir);

	}

}

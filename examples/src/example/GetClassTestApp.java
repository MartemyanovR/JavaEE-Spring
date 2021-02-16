package example;

public class GetClassTestApp {
	public static void main (String[] args) {
		GetClassInterface gct = new GetClassTest();
		GetClassTuple<GetClassInterface> gener = new GetClassTuple<>(gct);
		gener.control();
	}
}

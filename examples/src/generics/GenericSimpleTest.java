package generics;

public class GenericSimpleTest {
	public static void main(String[] args) {
		GenericClass<String> genCl = new GenericClass<>("first", 22);
		GenericClass<String> genCl2 = new GenericClass<>("Second", 33);
		System.out.println(genCl.getId());
		genCl2.setSum(34);
		System.out.println(genCl2.getId());
		System.out.println(genCl + "\n" + genCl2);
		//реализация обобщ. метода
		System.out.println(genCl.getId2("Stringa"));
		System.out.println(genCl.getId2(52.4d));
		System.out.println(genCl.getId2(genCl2));
	}
}

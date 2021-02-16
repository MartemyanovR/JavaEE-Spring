package collection;

public class InterfaceMapTest2 {

	public static void main(String[] args) {
		InterfaceMap<String,String> interM = new InterfaceMap<>();
		for(int i=0; i<10; i++) {
			interM.put(String.valueOf(i), String.valueOf(i));
		}
		interM.put(String.valueOf(5),String.valueOf(55));
		System.out.println(interM);

	}

}

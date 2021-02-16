package generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardRaw {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		ArrayList arrayList = new ArrayList();
		arrayList = strings; // Ok
		strings = arrayList; // Unchecked assignment
		arrayList.add(1); //unchecked call
	}

	
}

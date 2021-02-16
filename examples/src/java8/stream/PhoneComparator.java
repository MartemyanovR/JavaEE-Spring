package java8.stream;

import java.util.Comparator;

public class PhoneComparator implements Comparator<Phone> {

	@Override
	public int compare(Phone p1, Phone p2) {
		return (p1.getName().toLowerCase()).compareTo(p2.getName().toLowerCase());
	}

}

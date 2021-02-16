package horstmann;

import java.util.Scanner;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Size.values();
		for (Size sz: Size.values()) {
			System.out.println(sz);
		}
		Scanner in = new Scanner (System.in);
		System.out.println("Enter the size: (SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("Size = " + size);
		System.out.println("abbreviation = " + size.getAbbreviation());
		if (size == Size.EXTRA_LARGE)
			System.out.println("Good job !!!");
		
	}

}
	 enum Size{
		
		SMALL("S") , MEDIUM("M") , LARGE("L"), EXTRA_LARGE("XL");
		 
		private String abbreviation;
		private Size (String abbreviation) {
			this.abbreviation = abbreviation;
		}
		public String getAbbreviation() {
			return abbreviation;
		}
		
	}


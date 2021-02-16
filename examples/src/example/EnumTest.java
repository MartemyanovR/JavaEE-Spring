package example;

public enum EnumTest {
	 MONDAY,
	  THURSDAY,t,
	  WEDNESDAY;
	
	static enum EnumTestInner implements EnumInterface {	
		
		MONDAY(EnumTest.MONDAY){public double apply(double x, double y) { return x + y;	}},
		  THURSDAY(EnumTest.THURSDAY){public double apply(double x, double y) { return 0;	}},
		  WEDNESDAY(EnumTest.WEDNESDAY){public double apply(double x, double y) { return 0;	}};	
		
		EnumTest e;
		
		EnumTestInner(EnumTest e){
			this.e = e;
		}
		
	}
	
	public static void main(String[] args) {
		EnumTest et;
		for(EnumTest et1 : values()){
			System.out.println(et1 + " ORDINAL: " +  et1.ordinal() + " value: " + EnumTest.valueOf(et1.toString()));
			System.out.println(EnumTestInner.MONDAY.apply(5.2, 0.8));
					
		}
		
	}
}

package example;

public enum EnumExtendedOperation implements EnumOperations {
	
	ЕХР("^") { public double apply(double x, double y) {return Math.pow(x, y);}	},
	
	REMAINDER("%") { public double apply(double x, double y){return x % y;}};
	
	private final String symbol;
	
	EnumExtendedOperation(String symbol) {
	this.symbol = symbol;
	}
	
	@Override
	public String toString () {
		return symbol;
	}

}

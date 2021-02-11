package testJSP;

public class Calculation {
	
	public int calculate(int i, int y , String operation) {		
		int result = 0;
		
		switch(operation) {
		case "+" : 
			result = i + y;
			return result;
		case "-" : 
			result = i - y;
			return result;
		case "*" : 
			result = i * y;
			return result;
		case "/" : 
			result = i / y;
			return result;
		default :
			System.out.println("<p>input error </p>");
			return 0;
		}			
	}

}

package collection.ekkelCollection;

public class StackHandler {
	private StackX<String> theStack;
	private StackX<String> letters;
	private final String input;
	private String output;	
	public StackHandler(final String s) {
		input = s;
		output = "";
		int stackSize = s.length();
		theStack = new StackX<>(stackSize);
		letters = new StackX<>(stackSize);
	}
	public String doTrans() {
		fillLetters();
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch(ch) {
			case '+' :
				if(i == input.length()-1 || letters.isEmpty()) {
					System.out.println("This is end string, or stack is empty.");
					break;
				}
				theStack.push(letters.pop());
				break;
			case '-' :
				if (theStack.isEmpty()) 
					break;
				theStack.pop();
				break;
			default :
			break;
			}
		}		
		return theStack.toString();
	}
		
	private void fillLetters() {
		for (int j = input.length()-1; j >= 0; j--) {
			Character chx = input.charAt(j);
			if (chx != '-' && chx != '+')				
				letters.push(chx.toString());
		}
	}

}

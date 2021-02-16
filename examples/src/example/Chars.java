package example;

public class Chars {
	public static void main(String []args){
		int a = 0;
		if(++a == 1) System.out.println("done");
        String costForPrint = "5$";
        System.out.println(
         costForPrint.charAt(0) );
        System.out.println( + '1');
    }

    public static String getCurrencyName(char symbol) {
        if (symbol == '$') {
            return " dollars";
        } else {
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }

}

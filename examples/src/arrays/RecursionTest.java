package arrays;

public class RecursionTest {
	 
	public void ShowNums(int i) {
		int x = 1;
        try {
        	int m = x / i;				
            i--;
            ShowNums(i);		
            System.out.println(i+1);
	        }
        catch(ArithmeticException e) {
	            return;					
		}
   }

	public static void main(String[] args) {
		RecursionTest r = new RecursionTest();
		r.ShowNums(100);				
    }
}

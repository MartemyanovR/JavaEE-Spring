package exception;

public class RenewalOfException {
	public int i = -5;
	public int[] arrInt = new int[1];
	
	public int findCorrectIndex() {
		while(arrInt[0] == 0) {
			i++;
			try {
				arrInt[i] = i;
				return arrInt[i];
			} catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("incorrect value, i < 0");
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		RenewalOfException roe = new RenewalOfException();
		System.out.println(roe.findCorrectIndex());
		//если метод принимает в качестве аргумента обьектную обертку, то нужно указывать конкретный тип буквой L
		printLong(4L);
	}
	
	 public static void printLong(Long longValue) {
	        System.out.println(longValue);
	    }

}

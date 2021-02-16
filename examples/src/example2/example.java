package example2;
public class example {
	static int arrSize = 1000;
	public static void main(String[] args) {
		System.out.println(convolution("123456789"));
		/*System.out.println(hashF("cats"));
		System.out.println(hashF2("cats"));
		System.out.println(hashF3("cats"));*/
	}
	public static int hashF (String key) {		//простое хэширование строк
		int hashVal= 0;
		int pow = 1;	//количество фигурируемых символов		
		for (int j= key.length()-1; j>=0; j--) {
			int letter = key.charAt(j) - 96;    // с 96го символа начинается алфавит
			hashVal += pow * letter; 
			pow *=27;
		}
		return hashVal % arrSize; 
	 }
	public static int  hashF2 (String key) {	//хеширование с помощью метода Горнера
		int hashVal = key.charAt(0) -96;
		for (int j = 1 ; j< key.length(); j++) {
			int letter = key.charAt(j)-96;
			hashVal = hashVal * 27 + letter;
		}
		return hashVal % arrSize;		
	}
	public static int hashF3 (String key) {		// хеширование Гонером с мгновенным %
		int hashVal = 0;
		for (int j = 0; j< key.length(); j++) {
			int letter = key.charAt(j) - 96;
			hashVal = (hashVal * 27 + letter) % arrSize;
		}
		return hashVal;
	}
	public static int convolution(String key) {		// нужен метод свертки, который разбивает данные на группы	
		int a = Integer.MAX_VALUE;
		StringBuilder s = new StringBuilder();
		System.out.println(a);
		while(a>0) {
		     s.insert(0, a%10);
		     a = a / 10;
		}
		System.out.println(s.toString());
		return a;
		
		/*Integer n = arrSize-1;
		int size = n.toString().length();
		System.out.println(size);
		char buf[] = new char[3];
		 key.getChars(0, 3, buf, 0);
		 String s = new String(buf);
		 int i = Integer.parseInt(s);
		 return i;*/
	}
}

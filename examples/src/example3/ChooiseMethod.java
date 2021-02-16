package example3;

public class ChooiseMethod {
	 public static void method(Object obj){
	     System.out.println("method with param type - Object");
	   }
	 
	   public static void method(String obj){  //любой подкласс получает предпочтение перед супер классомм
	     System.out.println("method with param type - String"); //Java использует правило выбора наиболее конкретного метода.
	   }
	 
/*	   public static void method(StringBuffer strBuf){ //при добовлении еще одного конкретного метода- получаем compale error
		     System.out.println("method with param type - StringBuffer");
		   }	*/
	   
	   public static void method(Object obj, Object obj1){
		   System.out.println("method with param types - Object, Object");
		 }

		 public static void method(String str, Object obj){ //тоже самое, любой подкласс получает предпочтение перед супер классомм
		   System.out.println("method with param types - String, Object");
		 }
/*		 public static void method(Object obj, String obj1){ //если добавить эще один конкретизированый метод, то compale error
			   System.out.println("method with param types - Object, String");
			 }*/
		   
	   public static void main(String [] args){
	     method(null);
	     method(null, null);
	     
	   }
}

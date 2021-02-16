package string;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class StringFormatTest {
	
	//общий синтаксис
	//%[argument__index$][flags][width][.precision]conversion

	public static void main(String[] args) {
		//определяет индекс параметра, предназначеного для форматирования
		String greetings = String.format("Hello %2$s, welcome to %1$s !", "Baeldung", "Folks");
		System.out.println(greetings);
		
		// все в порядке, если мы не указываем argument index__ для первого, но нам нужно указать его для двух других.
		//
		  Calendar c = new GregorianCalendar(2017, 11/*месяц от 0 до 11*/, 10);
		    String s = String.format(
		      "The date is: %te %1$tm %1$tY", c);
		    System.out.println(s);
		    
		   //Внутри format () , если мы хотим напечатать ‘%’ - нам нужно выйти из него с помощью ‘%%’ .
		    String s1 = String.format("John scored 90%% in Fall semester");
		    System.out.println(s1);
		    
		    String s2 = String.format("The correct answer is %C", 'a');
		    String s3 = String.format("The correct answer is %c", 'a');
		    String s4 = String.format("The valid unicode character: %c", 0x0400);
		    String s5 = String.format("The valid unicode character: %c", 0x100FE);
		    System.out.println(s2 + " " + s3 + " " + s4 + " " +  s5);
		    System.out.println( String.format("The correct answer is %c", (String)null));
		    String nulls = (String)null;
		//    System.out.println(nulls.toString());  NPE
		    String s6 = String.format("The computerized scientific format of 10000.00 " + "= %e", 10000.00);
		    System.out.println(s6);
		    String s7 = String.format("The computerized scientific format of 10000.00 " + "= %9.2f", 10000.00);
		    System.out.println(s7);
		    String s8 = String.format ("С выровненным по левому краю флагом: %20d next text", 25);
		    String s9 = String.format ("С выровненным по левому краю флагом: %-20d next text", 25);
		    System.out.println(s8);
		    System.out.println(s9);
		    StringBuilder sb = new StringBuilder("abcd"); 
		    Formatter formatter = new Formatter(sb);  
		    System.out.println();
		    formatter.format ("Я пишу в %s экземпляр.", sb.getClass());
		    System.out.println(formatter);
		    
		    
		    Integer obj = 12345 ;
		    System.out.println(obj.toString() + " " + String.valueOf(obj) + " " +  " " + (obj.toString()==obj.toString()) + " "
		    + (obj.toString().equals(obj.toString())));
		    System.out.println(String.valueOf(obj)==String.valueOf(obj));
		    
		    Object ob = null;
		    System.out.println(String.valueOf(ob));
		  //  System.out.println(ob.toString());	NPE
	
		    String  strob = new String("1234");
		    String  strob2 = new String("1234");
		    System.out.println(strob.intern() == "1234");
		    System.out.println(strob.intern() == strob2);
		    System.out.println(strob.intern() == strob2.intern());
		    
	}
	
	

}

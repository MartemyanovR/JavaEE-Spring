package regEx;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExTest {
	
	public static String knights = "Then(,!,    when you have found the shrubbery tree, you must " +
			"cut down the mightiest tree in the forest... " +
			"with... a herring";	
	
	public static void split(String regex) {
		System.out.println(
				Arrays.toString(knights.split(regex)));		
	}
	
	public static void main (String[] args) {
		System.out.println("-1234".matches("-?\\d+"));  // означает необязательный знак минус с числом
		System.out.println("585".matches("-?\\d+"));
		System.out.println("+9".matches("-?\\d+"));
		System.out.println("911".matches("(-|\\*|\\+)?\\d+"));  //необязателььные знаки +*- с числом
		split(" ");		//разделитель пробел
		split("\\W+"); // Разбиение по символам, не являющимся символами слов
		split("n\\W+"); //шаблоны разбивки в результате не отображаются (т.е. n и не символу слов за ним)
		System.out.println(knights.replaceFirst("f\\w+", 
				"located")); //Операция заменяет только первое найденное совпадение,
												//поэтому слово «found» заменяется словом «located».
		System.out.println(knights.replaceAll("shrubbery|tree|herring","banana"));
		
		String text = "Агора Авта Ава Алла Алекс522андр";
	 // Pattern pattern = Pattern.compile("Е.+\\d{3}");    //жадный режим
	    Pattern pattern = Pattern.compile("А.+?а");	//ленивый режим
	    Matcher matcher = pattern.matcher(text);			
	    while (matcher.find()) {
	        System.out.println(text.substring(matcher.start(), matcher.end()));
	    }
	    
	}

}

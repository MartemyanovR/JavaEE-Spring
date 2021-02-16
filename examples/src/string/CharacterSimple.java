package string;

public class CharacterSimple {

	public static void main(String[] args) {
		String a = "цbG５";
		Character ch = '\u0035';
		
		System.out.println(Character.codePointBefore(a, 4));
		System.out.println(Character.highSurrogate(133));
	
		System.out.println(Character.isLowerCase('\u0660'));
		System.out.println(Character.toChars(0xFF19));
		System.out.println(Character.isDigit(0xFF10));
		System.out.println(Character.getType(0xFF23));
		System.out.println(Character.toUpperCase('v'));
		System.out.println(Character.toTitleCase('v'));
		System.out.println(Character.digit('A', 16));
		//Возвращает значение int, которое представляет указанный символ Юникода.
		//Например, символ '\u216C' (римская цифра пятьдесят) вернет значение int со значением 50.
		System.out.println(Character.getNumericValue('\u0035'));
		System.out.println(Character.getNumericValue(0xFF90));
		System.out.println(ch.compareTo('\uff15'));
		
		
		
	}

}

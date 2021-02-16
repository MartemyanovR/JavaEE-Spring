package multithreading.QueueAndCollection;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class Test {
	

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Locale local = Locale.getDefault();
		Map<String,Integer> month = calendar.getDisplayNames(Calendar.MONTH, Calendar.ALL_STYLES, local);
		System.out.println(month);
		String id = "8q";
		if(id != null && id.chars().allMatch(Character::isDigit) && id != "")
			System.out.println(id);
		else
			System.out.println("not");
		

	}

}

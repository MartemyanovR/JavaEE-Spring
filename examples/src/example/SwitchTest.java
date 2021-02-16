package example;

public class SwitchTest {
	
	static class DayOfWeek{
		public static final String MONDAY = "Monday";
		public static final String TUESDAY = "Tuesday ";
		public static final String WEDNESDAY = "Wednesday ";
		public static final String THURSDAY = "Thursday";
		public static final String FRIDAY = "Friday ";
	}
	
	public static enum DayOfWeak{
		  MONDAY("Monday"),
		  THURSDAY("Thursday"),
		  WEDNESDAY("Wednesday"),
		  NOT_FOUND("Not found");
		
		private String day;
		
		 DayOfWeak(final String day) {
			this.day = day;
		}
		
		 public static DayOfWeak fromValue(String value) {
		     for (final DayOfWeak dayOfWeek : values()) {
		        if (dayOfWeek.day.equalsIgnoreCase(value)) {
		           return dayOfWeek;
		        }
		     }
		     return NOT_FOUND;
		  }
	
	}

	public static void main(String[] args) {
		//String
		switch(DayOfWeek.FRIDAY) {
		case DayOfWeek.MONDAY : 
			System.out.println("понед");
		break; 
		case DayOfWeek.TUESDAY : 
			System.out.println("втор");
		break;
		case DayOfWeek.WEDNESDAY: 
			System.out.println("сред");
		break;
		case DayOfWeek.THURSDAY: 
			System.out.println("четв");
		break;
		case DayOfWeek.FRIDAY:{ 
			System.out.println("пятн");
		break;
		}
		default:
			System.out.println("NO");
			break;
		}
		
		DayOfWeak dow = DayOfWeak.fromValue("Thursday");
		//enum
		switch(dow) {
		case MONDAY : 
			System.out.println("понед");
		break; 
		case THURSDAY : 
			System.out.println("втор");
		break;
		case WEDNESDAY: 
			System.out.println("сред");
		break;
		default:
			System.out.println("NO");
			break;
		}
		
		
		//EnumTest et = EnumTest.MONDAY;
		//enum
		switch(EnumTest.MONDAY) {
		case MONDAY : 
			System.out.println("понед");
		break; 
		case THURSDAY : 
			System.out.println("втор");
		break;
		case WEDNESDAY: 
			System.out.println("сред");
		break;
		default:
			System.out.println("NO");
			break;
		}
				
		//примитив
		int i = 1;
		switch(i) {
		case(1) : 
			System.out.println("One");
		case(2) :
			System.out.println("Two");
		case(3) :
			System.out.println("Three");
		break;
		case(4) : 
			System.out.println("Four");
		case(5) :
			System.out.println("Five");
		default :
			System.out.println("Not found");
		}

	}

}

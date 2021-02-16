package collection;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import horstmann.Employee;
import horstmann.Manager;

public class PairTest {

	public static void main(String[] args) {
		Object ob = new Object();
		TmplateClass <Employee> tmp = new TmplateClass<>(new Employee());
		tmp.set(new Eagle());
		((Eagle)tmp.get()).voice();
		tmp.<Eagle>get().voice();

		/*GregorianCalendar[] birthday = {
				new GregorianCalendar(1945, Calendar.APRIL, 30),
				new GregorianCalendar(1957, Calendar.JANUARY,18),
				new GregorianCalendar(2001, Calendar.MARCH, 7)				
			};
		ArrayAlg a= new ArrayAlg();
		Pair <GregorianCalendar> mm = ArrayAlg.minmax(birthday);
		Pair calendar = mm;
		//calendar.setFirst(new Date(5687));  //генерирует�?�? и�?ключение при вызове метода getFirst
		System.out.println("min= " + mm.getFirst().getTime());
		System.out.println("max= " + mm.getSecond().getTime());
		System.out.println(ob.equals(ob));
		
			Employee buddy = new Manager(2000);
			Manager manager1=new Manager(100);
			Manager manager2=new Manager(500);
			Manager manager3=new Manager(3000);
			Manager manager4=new Manager(400);
			Manager manager5=new Manager(550);
				Manager[] manager = {manager1,manager2,manager3,manager4,manager5};
		//Pair <Manager> p =new Pair<>(buddy,manager2);  //ошибкафцы
		for (Manager m : manager) {
			System.out.println(m.getBonus());
		}
		Pair<Employee> emp = new Pair<>();
		ArrayAlg.minmaxBonus(manager, emp);
		System.out.println(emp.getFirst() + " --------- " + emp.getSecond());
		
*/
}
}

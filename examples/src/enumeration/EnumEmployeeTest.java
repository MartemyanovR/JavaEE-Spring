package enumeration;

public class EnumEmployeeTest {

	public static void main(String[] args) {
		EnumEmployee EE;
		
		System.out.println("Employee two - " + EnumEmployee.B.getEmployee());
		
		System.out.println("All employee:");
		for (EnumEmployee e : EnumEmployee.values()) {
			System.out.print(e.getString() + ", ");
			}
		//работает, если перечисления используют(переопределяют) абстрактный метод, или интерфейс
		System.out.println("\n" + EnumEmployee.A.abcd());
		//EnumEmployee.A.abcd();

	}

}

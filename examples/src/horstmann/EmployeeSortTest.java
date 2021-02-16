package horstmann;

import java.util.Arrays;

public class EmployeeSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		n+=20;
		String v = "5";
		int i = Integer.parseInt(v+5);
		System.out.println(i + "_____________");
		Employee emp = new Employee();
		
		EmployeeSort[] staff = new EmployeeSort[3];

	      staff[0] = new EmployeeSort("Harry Hacker", 35000);
	      staff[1] = new EmployeeSort("Carl Cracker", 75000);
	      staff[2] = new EmployeeSort("Tony Tester", 38000);
	  	
			
	      
	      Manager manag = new Manager();
			if(emp instanceof Manager) {
				System.out.println("+");
			}

	      Arrays.sort(staff);

	      // print out information about all Employee objects
	      for (EmployeeSort e : staff)
	         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

	}

}

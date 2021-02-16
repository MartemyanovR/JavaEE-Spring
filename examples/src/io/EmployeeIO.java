package io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import horstmann.Employee;


public class EmployeeIO {

	   private String name;
	   private double salary;
	   private Date hireDay;
	   public static final int NAME_SIZE = 40;
	   public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 2;
	
	 public EmployeeIO() {}  
	   
	 public EmployeeIO(String n, double s, int year, int month, int day)
	   {  name = n;
	      salary = s;
	      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
	      hireDay = calendar.getTime();
	   }	
	  
	   public void raiseSalary(double byPercent) {
	     salary *= 1 + byPercent / 100;
	   }
	   
	   public int hireYear() {
		   return hireDay.getYear();
	   }
	   
	   public void writeData(DataOutput out) throws IOException {
		  DataIO.writeFixedString(name, NAME_SIZE, out);  
	      out.writeDouble(salary);
	      out.writeInt(hireDay.getYear());
	      out.writeInt(hireDay.getMonth());
	      out.writeInt(hireDay.getDay());
	   }

	   public void readData(DataInput in) throws IOException
	   {  name = DataIO.readFixedString(NAME_SIZE, in);
	      salary = in.readDouble();
	      int y = in.readInt();
	      int m = in.readInt();
	      int d = in.readInt();
	      hireDay = new Date(y, m, d);
	   }	  
	   
	   public void print()
	   {  System.out.println(name + " " + salary 
	         + " " + hireYear());
	   }
	   public String getName() throws IndexOutOfBoundsException
	   {
	      return name;
	   }

	   public double getSalary()
	   {
	      return salary;
	   }

	   public Date getHireDay()
	   {
	      return hireDay;
	   }

	   public boolean equals(Object otherObject)
	   {
	      // a quick test to see if the objects are identical
	      if (this == otherObject) return true;

	      // must return false if the explicit parameter is null
	      if (otherObject == null) return false;

	      // if the classes don't match, they can't be equal
	      if (getClass() != otherObject.getClass()) return false;

	      // now we know otherObject is a non-null Employee
	      Employee other = (Employee) otherObject;

	      // test whether the fields have identical values
	      return Objects.equals(name, other.getName()) && salary == other.getSalary() 
	    		  && Objects.equals(hireDay, other.getHireDay());
	   }

	   public int hashCode()
	   {
	      return Objects.hash(name, salary, hireDay); 
	   }

	   public String toString()
	   {
	      return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
	            + "]";
	   }

}

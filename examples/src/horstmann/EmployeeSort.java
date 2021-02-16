package horstmann;


public class EmployeeSort implements Comparable<EmployeeSort>
{
   private String name;
   private double salary;

   public EmployeeSort(String n, double s)
   {
      name = n;
      salary = s;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   /**
    * Compares employees by salary
    * @param other another Employee object
    * @return a negative value if this employee has a lower salary than
    * otherObject, 0 if the salaries are the same, a positive value otherwise
    */
   public int compareTo(EmployeeSort other)
   {
      return name.compareTo(other.name);
   }
}

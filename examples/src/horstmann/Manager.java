package horstmann;

public class Manager extends Employee
{
	public Integer abc ;
	public Integer i = 10;
  private  int bonus;
   private static double bonus1;
   
   public Manager() {
	    abc = 10; 
   }
   
   public Manager (int b) {
	   bonus=b;
   }

  public Manager(String n, double s, int year, int month, int day)
   {
      super(n, s, year, month, day);
      bonus = 0;
   }
   
public  String getName() throws ArrayIndexOutOfBoundsException {
	  
	  return "1" + "   " + abc;
  }
  
   
   public double getSalary()
   {
	   System.out.println("This is manager");
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
     
   }
   
    public void setBonus(int b)
   {
      bonus = b;
   }
  
    
    public static void setChar(char b1) {
 	   bonus1=b1;
    }

   public boolean equals(Object otherObject)
   {
      if (!super.equals(otherObject)) return false;
      Manager other = (Manager) otherObject;
      // super.equals checked that this and other belong to the same class
      return bonus == other.bonus;
   }

   public int hashCode()
   {
      return super.hashCode() + 17 * new Double(bonus).hashCode();
   }

   public String toString()
   {
      return super.toString() + "[bonus=" + bonus + "]";
   }

   public int getBonus() {
	   // TODO Auto-generated method stub
	return bonus;
   }

}

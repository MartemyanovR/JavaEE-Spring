package horstmann;

import java.lang.reflect.Field;

/**
 * This program demonstrates the equals method.
 * @version 1.12 2012-01-26
 * @author Cay Horstmann
 */
public  class EqualsTest
{
   public static void main(String[] args) throws NoSuchFieldException, SecurityException
   {
	   
	   Integer value = 29;
	   System.out.println((value+1.0)/0);
	   Field fields = Manager.class.getField("i");
	   Class declarClass = fields.getDeclaringClass();
	   System.out.println(declarClass.getName());
      Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
      Employee alice2 = alice1;
      Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
      Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
      Manager bob2 = new Manager();
      Employee bob3 = new Manager();
     
     // Object o = bob2;
      //Manager bob4 =(Manager) bob;
      //Employee ee= (Employee)bob2;
     // if (bob instanceof Manager) {
     // bob4.getSalary();}
      bob2.setBonus(3);
     // bob3.setBonus(3);
      
      System.out.println("alice1 == alice2: " + (alice1 == alice2));

      System.out.println("alice1 == alice3: " + (alice1 == alice3));

      System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

      System.out.println("alice1.equals(bob): " + alice1.equals(bob));

      System.out.println("bob.toString(): " + bob);

      Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      //boss.setBonus(5000);
      carl.setBonus('b');
      
      System.out.println("boss.toString(): " + boss);
      System.out.println("carl.toString(): " + carl);
      System.out.println("carl.equals(boss): " + carl.equals(boss));
      System.out.println("alice1.hashCode(): " + alice1.hashCode());
      System.out.println("alice3.hashCode(): " + alice3.hashCode());
      System.out.println("bob.hashCode(): " + bob.hashCode());
      System.out.println("carl.hashCode(): " + carl.hashCode());
     System.out.println( bob2.getName());
     
     Employee ingener = new Manager("Carl Cracker", 80000, 1987, 12, 15);
    System.out.println("ingener.toString(): " + ingener);
    System.out.println("ingener.equals(boss)" + ingener.equals(boss));
    
   }
}
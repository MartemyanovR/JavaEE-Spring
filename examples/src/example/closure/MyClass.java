package example.closure;

import java.text.DateFormat.Field;
import java.util.Random;

public class MyClass {
	private String extString = "String from External Class";
	private static final int PERM_MIN_VALUE = 50;	 
    private class Closure {
 
        public String showInt() {
            return ("String from CLosuer");
        }
 
        public String showExt() {
            return (MyClass.this.extString);
        }
 
    }
 
    public Closure getClosure() {
        return new Closure();
    }
 
    // Метод создает экземпляр внутреннего класса Closure чтобы тот вытащил для него переменную класса
    // extString которая и так доступна
    // СMyClass >> extString >> method >> Closure.showExt() >> extString  круг замкнулся
 
    public void demoClosure() {
        System.out.println("Direct show   string demo:" + extString);
        System.out.println("Callback via Closure demo:" + getClosure().showExt());
 
    }
 
 
    // Метод открывает и вызывает анонимный класс на базе интерфейса IClosure чтобы тот
    // вытащил для него переменную класса extString которая и так доступна
    // СMyClass >> extString >> method >> new IClosure.getVar >> extString  круг замкнулся
    public void demoClosure2() {
        System.out.println("Direct show   string demo:" + extString);
        System.out.println("Callback via Closure demo:" + getClosure2().getVar());
 
    }
 
    public ICLosure getClosure2() {
        return (new ICLosure() {
            @Override
            public String getVar() {
                return MyClass.this.extString;
            }
        });
    }
 
    public void demoClosure3() {
 
        // Метод открывает внутренний класс чтобы тот вытащил для него переменную класса
        // extString которая находится в классе  класс >> extString >> метод >> ICLousure >> extString >> метод
 
        String s = (new ICLosure() {
            @Override
            public String getVar() {
                return MyClass.this.extString;
            }
        }).getVar();
        System.out.println("Direct show   string demo:" + extString);
        System.out.println("Callback via Closure demo:" + s);
 
 
        // Метод открывает внутренний класс чтобы тот вытащил для него переменную
        // ext2 которая находится в самом методе  круг замкнулся
        String ext2 = "Ext2 String in Method";
        String s2 = (new ICLosure() {
            @Override
            public String getVar() {
                return ext2;
            }
        }).getVar();
 
        System.out.println("Direct show   string demo:" + ext2);
        System.out.println("Callback via Closure demo:" + s2);
 
 
        // Метод открывает внутренний класс прямо внутри println чтобы тот вытащил для него переменную
        // ext4 которая находится в самом методе круг замкнулся  метод ext4 >> IClosure(){} >> ext4 >> метод
        String ext4 = "Ext4 String in Method";
        System.out.println("Direct show   string demo:" + ext4);
        System.out.println("Callback via Closure demo:" + new ICLosure() {
            @Override
            public String getVar() {
                return ext4;
            }
        }.getVar());
 
    }
    
    
    public Integer demoClosure4(int i) {
      	return (new IClosureInt<Integer>() {
    		@Override
    		public Integer getVar(Integer i1) {			
    			return i + i1;	}    	
        }).getVar(i*2);
    	
    }
    
    public void demoClosure5(int i, int i2) {
    	IClosureInt<Integer> ici =(y) -> i + y ;
    			
    	System.out.println(ici.getVar(i2));
    }
    
    public Integer demoClosure6(int i) {
    	IClosureInt<Integer> ici =(y) -> i > y ? i : y;
    	if(i < PERM_MIN_VALUE)
    		System.out.print("Value update!  ");	
    	return this.sum(PERM_MIN_VALUE, ici);
    }
    
    public Integer sum (int first, IClosureInt<Integer> ici) {  //передача функции
    	Integer i = ici.getVar(first); 
    	
    	return i;
    }
 
 
    public static void main(String[] args) throws Exception{
    	
    	
    	label: do {
    		System.out.println("before");
    		  if (true) continue label;
    		  System.out.println("after");
    		  break label;
    		} while(true);
    	
    	     			 
    			    // Extract the IntegerCache through reflection
    			    Class<?> clazz = Class.forName(
    			      "java.lang.Integer$IntegerCache");
    			    java.lang.reflect.Field field = clazz.getDeclaredField("cache");
    			    field.setAccessible(true);
    			    Integer[] cache = (Integer[]) field.get(clazz);
    			 
    			    // Rewrite the Integer cache
    			    for (int i = 0; i < cache.length; i++) {
    			      cache[i] = new Integer(
    			        new Random().nextInt(cache.length));
    			    }
    			 
    			    // Prove randomness
    			    for (int i = 0; i < 10; i++) {
    			      System.out.println((Integer) i);
    			    }
    			  
        MyClass mc = new MyClass();
        mc.demoClosure();
        mc.demoClosure2();
        mc.demoClosure3();
        System.out.println(mc.demoClosure4(10));
        mc.demoClosure5(5,7);
        System.out.println(mc.demoClosure6(60));
 
    }

}

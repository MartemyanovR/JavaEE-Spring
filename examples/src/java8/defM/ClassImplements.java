package java8.defM;

// дублированые методы в I-сах выдают ошибку компиляции, необходимо переопределить данный метод в классе
public class ClassImplements /*extends ClassAbstr*/ implements DefaulI1, DefaultI2{
	public static boolean b = false;
	
	@Override
    public long getId() {
		if(b == true)
			return 2222;
		return DefaultI2.super.getId();
	}

	@Override
	public String getName() {
		
		return DefaultI2.super.getName();
	}
	

	public static void main(String[] args) {
		DefaulI1 ci = new ClassImplements();
		System.out.println(ci.getId() + "\n");
		System.out.println(ci.getName());
		 
	}
	
}

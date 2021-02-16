package java8.defM;

public class DefTEst555 implements DefTest555I  {
//2 способа ввызова дефаулт метода
	//1
	public void print555() {
		System.out.print("print 555 : ");
		DefTest555I.super.meth555();
	}
	
	public void meth555() {
		System.out.println("666");
		DefTest555I.super.meth555();
		DefTest555I.methStat();
	}
	
	
	
	
	public static void main(String[] args) {
		DefTEst555 def555 = new DefTEst555();
		def555.print555();
		def555.meth555();
		
		//2
		DefTest555I def555I = new DefTEst555();
		def555I.meth555();
		DefTest555I.methStat();

	}

}

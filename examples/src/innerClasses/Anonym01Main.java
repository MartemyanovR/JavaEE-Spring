package innerClasses;

public class Anonym01Main {
	public static void main (String[] args) {
		
		Anonym01External anExt = new Anonym01External();
		Anonym01External anExt1 = new Anonym01External();
		System.out.println("ext.this= " + anExt.getThis());
		anExt1 = Anonym01External.ext;
		System.out.println("ext.this= " + anExt.getThis());
		anExt = new Anonym01External();
		anExt = Anonym01External.ext;
		System.out.println("ext.this= " + anExt.getThis());
		System.out.println("ext.this= " + anExt1.getThis());
	}

}

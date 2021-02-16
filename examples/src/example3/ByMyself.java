package example3;

public class ByMyself {
	
	public void mySelf(ByMyself s) {
		System.out.println("invoke 1" + this.toString() + " " + s.toString());
		s.mySelf2(this);
	}
	public void mySelf2(ByMyself s2) {
		System.out.println("invoke 2" + this.toString()  + " " + s2.toString());
	}

	public static void main(String[] args) {
		ByMyself a = new ByMyself();
		ByMyself a1 = new ByMyself();
		a.mySelf(a);
		a.mySelf(a1);
	}

}

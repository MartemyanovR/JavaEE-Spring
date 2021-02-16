package patterns;

public class OcpFood implements OcpCook  {
	public void getFry(){
		System.out.println("жарить");
	}
	public void getFreeze() {
		System.out.println("заморозить");
	}
		public void methCook() {
			getFry();
			getFreeze();
		}

}

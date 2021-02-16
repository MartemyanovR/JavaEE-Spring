package finall;

public class Final1 {
	private int i;
	final int f;
	public Final1(final int i) {
		f = i;
	}
	private void f() {
		System.out.println("Final.f");
	}
	final void g() {
		System.out.println("Final.g");
	}
	private final void fg() {
		System.out.println("Final.fg");
	}
}

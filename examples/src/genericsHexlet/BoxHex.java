package genericsHexlet;

public class BoxHex <T> {
	private final T value;
	
	public BoxHex (final T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}

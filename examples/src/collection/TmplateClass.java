package collection;

public class TmplateClass <T> {
	
	private T var;
	Object obj;
	
	public TmplateClass(T var) {
	this.var = var;		
	}
	public <X> void set (X var){
				obj = var;
	}
	public <V> V get() {
		return (V) obj;
	}
	public String get(int a) {
		return (String)obj;
	}

}

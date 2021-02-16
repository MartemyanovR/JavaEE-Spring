package generics;

public class GenericClassOldStyle implements GenericInterface {
	
	private Object id;
	private Object sum;
	
	public GenericClassOldStyle(Object id, Object sum) {
		this.id = id;
		this.sum = sum;		
	}

	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSum(int sum) {
		// TODO Auto-generated method stub
		
	}

}

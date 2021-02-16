package exception;

public class SimpleException {

	public static void main(String[] args) {
		try {
			System.out.println("Возбуждаем Exception из main");
			throw new Exception("Create in the main()");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//System.out.println();
			System.err.println("close");
		}
	}

}

package genericsHexlet;

public class Main3 {
	public static void main(String... args) {
		final Integer left = 1;
		final Double middle = 0.4;
		final String right = "right";
		
		final Triple3 triple = new Triple3(left, right, middle);
		final Tuple3<Integer, String> tuple = triple;

		try {
			final Integer leftId = tuple.getLeft();
			final Integer leftId2 =(Integer) triple.getLeft();
			
			if (!left.equals(leftId) || !left.equals(leftId2)) {
				throw new RuntimeException("Triple#getLeft() do not returns the value that have been set in the constructor");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		try {
			final String rightValue = tuple.getRight();
			final String rightValue2 = (String)triple.getRight();
			
			if (!right.equals(rightValue) || !right.equals(rightValue2)) {
				throw new RuntimeException("Triple#getRight() do not returns the value that have been set in the constructor");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		try {
			final Double middleValue = (Double)triple.getMiddle();
			if (!middle.equals(middleValue)) {
				throw new RuntimeException("Triple#getMiddle() do not returns the value that have been set in the constructor");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}

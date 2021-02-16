package innerClasses;

public interface ISummator {
	/**
	 * The method returns the sum of two arguments passed to it on an input.
	 * @param a is integer number.
	 * @param b is integer number.
	 * @return sum of numerical operands.
	 */
	int plus(int a, int b);
	
	/**
	 * The method returns the difference of two arguments passed to it at the input.
	 * @param a is integer number.
	 * @param b is integer number.
	 * @return numerical operand difference.
	 */
	int minus(int a, int b);
	
	/**
	 * The method divides its operands, where the left operand is divisible and the right operand is a divisor.
	 * @param a is divisible, integer number.
	 * @param b is a divisor, integer number.
	 * @return result of division. Type double.
	 */
	double div(int a, int b);
	
	/**
	 * The method returns the remainder of dividing the left operand by the right.
	 * The return value always gets the sign of the dividend, not the divisor.
	 * @param a is integer number. The left operand.
	 * @param b is integer number. The left operand.
	 * @return the integer remainder of dividing the left operand by the right.
	 */
	int remDiv(int a, int b);
	
	/**
	 * The method returns the multiplication of two arguments passed to it at the input.
	 * @param a is integer number.
	 * @param b is integer number.
	 * @return multiplication result.
	 */
	int mult(int a, int b);
	
	/**
	 * The method raises the first argument to the power equal to the second argument.
	 * The method does not know how to work with a negative degree. But a negative number raises to a given degree.
	 * @param a is integer number.
	 * @param b is integer number.
	 * @return "a" to the power of "b".
	 */
	int pow(int a, int b);

}

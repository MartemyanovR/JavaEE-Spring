package java8.linkOfMeth;

public class LambdaApp {
	 public static void main(String[] args) {
         
	        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
	        System.out.println(sum(nums, ExpressionHelper::isEven));  //используем в качестве функции уже готовый метод (isEven)
	         
	        Expression expr = ExpressionHelper::isPositive;  //link of method
	        System.out.println(sum(nums, expr));
	        
	        Expression exprLya = (x) -> x < 0;    //can used lyambda, this is same
	        System.out.println(sum(nums,exprLya));
	        
	        
	        ExpressionHelper exH = new ExpressionHelper();
	        System.out.println(sum(nums, exH::isNegative)); //использование метода обьекта (не статич)
	    } 
	     
	    private static int sum (int[] numbers, Expression func)  //в func мы можем установить любой подходящий метод,
	    {														 //либо лямбда выражение. В момент написания метода sum условие func не известно 
	        int result = 0;
	        for(int i : numbers)
	        {
	            if (func.isEqual(i))
	                result += i;
	        }
	        return result;
	    }

}

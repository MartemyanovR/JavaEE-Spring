package example;

public class AutoBoxing {

	public static void main(String[] args) {
        int i = 10;
		Integer iOb  = 10;
        method(iOb);
        method(i);
        Integer[] iObs = new Integer[] {5, 10, 50, 2, 7};
        method(iObs);
        System.out.println(sumBeforeInclusive(3));
    }
	 //Ошибка компиляции, если указать int, в массивах не работает
    public static void method(Integer ... i) {
       System.out.println("int[]");
   }

    public static void method(int i) {
       System.out.println("int");
   }
/*
    public static void method(Integer iOb) { //Будет вызван данный метод
       System.out.println("Integer");
   }
*/
    public static Integer sumBeforeInclusive(Integer number) {
        Integer iOb = number;
        if (number > 1) iOb += sumBeforeInclusive(number - 1);
        return iOb;
    }
}

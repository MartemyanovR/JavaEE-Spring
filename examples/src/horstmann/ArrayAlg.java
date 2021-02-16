package horstmann;

public class ArrayAlg {
	final private double outer = 10.01;
	private static double outerStat;
	public static class Pair{
		private  double first;
		private  double second;
		
		public Pair (double f,double s){
			ArrayAlg aa = new ArrayAlg();
			first = outerStat;
			second = aa.outer;				// внутрений класс имее доступ к закрытым членам внешнего класса 
											// через экземпляр внешнего класса
		}
		
		public double getFirst() {
			
			return first;
		}
		public double getSecond() {
			return second;
		}
	}
	
	public static  Pair minMax (Double[] val) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (double v : val) {
			if (min>v) min=v;
			if (max<v) max=v;
		}
		return new ArrayAlg.Pair (min,max);
	}
}

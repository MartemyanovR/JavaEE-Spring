package horstmann;

//import horstmann.ArrayAlg.*;

public class StaticInnerClassTest extends ArrayAlg.Pair {    //внутренний статик класс можно наследовать

	public StaticInnerClassTest(double f, double s) {
		super(f, s);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double[] d = new Double [30];
		for(int i=0; i<d.length; i++)
			d[i] = 100 * Math.random();
		/*ArrayAlg aa = new ArrayAlg();    //ðàáîòàåò òîëüêî ïðè èìïîðòå ArrayAlg
		Pair p = aa.minMax(d);
		System.out.println(p.getFirst());
		System.out.println(p.getSecond()); */
		ArrayAlg.Pair p = ArrayAlg.minMax(d);
		System.out.println(p.getFirst());
		System.out.println(p.getSecond());
	}

}

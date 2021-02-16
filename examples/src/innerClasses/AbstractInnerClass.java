package innerClasses;

public  abstract class AbstractInnerClass {
	public int[] num = new int[5];
	public int countNum = 0;
	
	public int getNum () { 		
		return num[countNum];
		}
		
	//нет доступа
	public class InerAbs{
		int i = 0;
		public int getNum() {
			return num[i];
		}
		
	}
	

}

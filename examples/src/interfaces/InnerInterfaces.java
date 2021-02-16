package interfaces;

public class InnerInterfaces {

	public static void main(String[] args) {
		
		
		
		AOut.Aint1.aintPrt2();
		AOut a = new AOut();
		
		a.Aaprint();
	/*	//если внутренний класс делаем приватным, то так не сработает, нет доступа
		AOut.Aaa aaa = a.new Aaa();
		aaa.protPrt();		*/
		a.Aaaprint();
		
		BOut b = new BOut();

		
		COut c = new COut();
		c.myinnerPrt();

		DOut d = new DOut();
		d.prt();
	}

}

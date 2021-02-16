package horstmann;

import javax.swing.JOptionPane;

public class InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TalkingClock tc = new TalkingClock(2500,true);
		TalkingClock2 tc2 = new TalkingClock2();
		//tc.start();
		tc2.start(3000,true);
		System.currentTimeMillis();
		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
	}

}

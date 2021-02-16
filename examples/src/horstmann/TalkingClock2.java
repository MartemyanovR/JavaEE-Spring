package horstmann;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

public class TalkingClock2 {

	public void start(int interval, final boolean beep) {
		System.out.println("1");
		ActionListener listener = new ActionListener() {
			public void actionPerformed (ActionEvent event) {
			System.out.println("1.5");
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if(beep) Toolkit.getDefaultToolkit().beep();
				
			}
		};
		System.out.println("2");
		Timer t = new Timer (interval,listener);
		System.out.println("3");
		t.start();
	System.out.println("4");
	}
}

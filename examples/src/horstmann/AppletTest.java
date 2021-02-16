package horstmann;

import java.awt.*;
import javax.swing.*;
import java.applet.*;

public class AppletTest extends JApplet {

	public void init(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JLabel label = new JLabel("Not a hello, world applet", SwingConstants.CENTER);
				add(label);
			}
		});
	}
}
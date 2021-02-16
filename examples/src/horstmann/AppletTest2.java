package horstmann;

import java.awt.*;
import javax.swing.*;

public class AppletTest2 extends JApplet {

	public void init() {
		add(new JButton(getParameter("buttonName")));
	}
}

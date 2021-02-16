package horstmann;

import java.awt.*;
import javax.swing.*;

public class AwtImaeTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame frame = new ImageFrame();
				frame.setTitle("ImageTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}

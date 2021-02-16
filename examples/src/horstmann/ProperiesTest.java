package horstmann;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ProperiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PropertiesFrame frame = new PropertiesFrame();
				/*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);*/
				frame.setVisible(true);
			}
		});

	}

}

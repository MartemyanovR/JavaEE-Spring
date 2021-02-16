package horstmann;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame {    //кнопки с рисунком

	public static void createGUI() {
		JFrame frame = new JFrame("Test frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();		

		JButton button1 = new JButton();
		ImageIcon icon1 = createIcon("cpu4848.jpg");
		button1.setIcon(icon1);
		panel.add(button1);
		
		
		JButton button2 = new JButton();
		ImageIcon icon2 = createIcon("crawler_crane_256.png");
		button2.setIcon(icon2);
		panel.add(button2);
		
		JButton button5 = new JButton();
		ImageIcon icon5 = createIcon("crawler_crane_256.png");
		button5.setIcon(icon5);
		panel.add(button5);
		
		JButton button3 = new JButton();
		ImageIcon icon3 = new ImageIcon("src/horstmann/gramofone.png");
		button3.setIcon(icon3);
		panel.add(button3);
		
		JButton button4 = new JButton();
		ImageIcon icon4 = new ImageIcon("src/horstmann/gramofone.png");
		button4.setIcon(icon4);
		panel.add(button4);

		frame.getContentPane().add(panel);
		frame.setPreferredSize(new Dimension(300, 200));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	protected static ImageIcon createIcon(String path) {
		URL imgURL = TestFrame.class.getResource(path);		
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("File not found " + path);
			return null;
		}
	}


	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				createGUI();
			}
		});
	}
}
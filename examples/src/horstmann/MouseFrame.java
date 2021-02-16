package horstmann;

import java.awt.EventQueue;

import javax.swing.*;

public class MouseFrame extends JFrame {
	private static int DEFAULT_WIDTH = 300;
	private static int DEFAULT_HIGHT = 200;
	
	public MouseFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
		add(new MouseComponent());
		//pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame frame = new MouseFrame();
				frame.setTitle("MouseFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	

}

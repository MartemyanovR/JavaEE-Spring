package horstmann;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame{
		private JPanel buttonPanel;
		private static int DEFAULT_WIDTH = 300;
		private static int DEFAULT_HIGHT = 200;
		
		public ButtonFrame() {
			setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
			
			ImageIcon icon = new ImageIcon("src/horstmann/american.png"); 
			JButton yellowButton = new JButton();
			yellowButton.setIcon(icon);
			JButton blueButton = new JButton("Blue");
			JButton redButton = new JButton("Red");
			
			buttonPanel = new JPanel();
			
			buttonPanel.add(yellowButton);
			buttonPanel.add(blueButton);
			buttonPanel.add(redButton);
			
			add(buttonPanel);
			
			ColorAction yellowAction = new ColorAction(Color.yellow);
			ColorAction blueAction = new ColorAction(Color.blue);
			ColorAction redAction = new ColorAction(Color.red);
			
			yellowButton.addActionListener(yellowAction);
			blueButton.addActionListener(blueAction);
			redButton.addActionListener(redAction);
			}
		
		private class ColorAction implements ActionListener{
			private Color backgroundColor;
			
			public ColorAction(Color c) {
				backgroundColor = c;
			}
			public void actionPerformed(ActionEvent event) {
				buttonPanel.setBackground(backgroundColor);
			}			
		}
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				
				public void run() {
					JFrame frame = new ButtonFrame();
					frame.setTitle("ButtonTest");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});


		}


}

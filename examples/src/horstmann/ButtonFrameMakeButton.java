package horstmann;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrameMakeButton extends JFrame{
	
	private JPanel buttonPanel;
	ImageIcon icon;
	private static int DEFAULT_WIDTH = 400;
	private static int DEFAULT_HIGHT = 150;
	
	public ButtonFrameMakeButton() {
		setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
		buttonPanel = new JPanel();
		add(buttonPanel);
		icon = new ImageIcon("src/horstmann/american.png"); 
		makeButton("BLACK", Color.BLACK);
		makeButton("Red", Color.PINK);
		makeButton("", Color.RED);
		makeButton("blue", Color.cyan);
	}
	
	public void makeButton(String name, final Color backgroundColor) {
		JButton button = new JButton(name);
		if (name == "") {
			button.setIcon(icon);
		}
		buttonPanel.add(button);
		button.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent event) {
					buttonPanel.setBackground(backgroundColor);
				}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new ButtonFrameMakeButton();
				frame.setTitle("ButtonTest2");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});		
		
		
	}
		
}

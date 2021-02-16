package horstmann;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ActionFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 200;
	private static final int DEFAULT_HIEGHT = 300;
	//private static final KeyStroke B = null;
	
	public ActionFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HIEGHT);
		buttonPanel = new JPanel();
		
		Action yellowAction = new ColorAction ("Yellow" , 
				new ImageIcon("src/horstmann/2019_03_04_15_23_29_Window.png"), Color.YELLOW );
		Action blueAction = new ColorAction ("Blue" , 
				new ImageIcon("src/horstmann/2019_03_04_15_23_29_Window.png"), Color.BLUE );
		Action redAction = new ColorAction ("Red" , 
				new ImageIcon("src/horstmann/2019_03_04_15_23_29_Window.png"), Color.RED );
		
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		add(buttonPanel);
		
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	
	public class ColorAction extends AbstractAction{
		private Color backgroundColor = Color.BLACK;
		
		public ColorAction (String name, Icon icon, Color c) {
			putValue(Action.NAME , name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION , "Set panel color to " + name.toUpperCase());
			putValue("color",c);
		}
		public void actionPerformed (ActionEvent event) {
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
		}
	}
	public static void main (String[] args) {
	EventQueue.invokeLater(new Runnable() {
		
		public void run() {
			JFrame frame = new ActionFrame();
			frame.setTitle("ActionFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	});	
	
	}
}


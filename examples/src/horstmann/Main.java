package horstmann;


import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class Main extends JFrame{
	 JComponent comp = new JLabel("Test label11111111111111111111111111111111111");
	 private static final int DEFAULT_WIDTH = 200;
	 private static final int DEFAULT_HIGHT = 200;

	  public Main() {
		  
		  comp.setToolTipText("Some tooltip text for component");
	    comp.setBorder(new TitledBorder("Button22222222222222222222222222"));
	    
	    System.out.println("X:" + comp.getX() + " Y:" + comp.getY() + " width:"
	        + comp.getWidth() + " height:" + comp.getHeight());

	   // setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HIGHT));
	    getContentPane().add(comp);
	    pack();

	    System.out.println("X:" + comp.getX() + " Y:" + comp.getY() + " width:"
	        + comp.getWidth() + " height:" + comp.getHeight());
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	  }

	public static void main(String[] args) {
		JFrame frame = new Main();
		
		//new Main();

	}

}

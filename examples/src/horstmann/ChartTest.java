package horstmann;

import java.awt.*;
import javax.swing.*;

public class ChartTest extends JApplet{
	
	public void init() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				play(getCodeBase(),"tada.wav");
			 JLabel label = new JLabel ("This is applet: ChartApplet", SwingConstants.LEFT); 	add(label);  
				String v = getParameter("values");
				if (v==null) return;
				int n = Integer.parseInt(v);
				double[] values = new double[n];
				String[] names = new String[n];
				for(int i=0; i<n; i++) {
					values[i] = Double.parseDouble(getParameter("value." + (i+1)));
					names[i]= getParameter("name." + (i+1));
				}
					
					add(new ChartComponent(values,names,getParameter("title")));	
					
				}
		});
	} 
}
	
	/*private static int DEFAULT_WIDTH = 300;
	private static int DEFAULT_HIGHT = 300;
	private int n=3;
	double[] values ={3200,500,750};
	String[] names ={"one", "two", "three"}; 
	
	public ChartTest() {
		add(new ChartComponent(values,names,"1234567890"));
		setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
		
		//pack();
	}
	
	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new ChartTest();
				frame.setTitle("ButtonTest2");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});		
	
	
	}
}*/	
	
	


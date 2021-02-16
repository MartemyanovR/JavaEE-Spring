package horstmann;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class ImageComponent extends JComponent {
	
	private static final int DEFAULT_WIDTH = 50;
	private static final int DEFAULT_HEIGHT= 30;
	private Image image;
	
	public ImageComponent() {
		
		image = new ImageIcon("src/horstmann/2019_03_04_15_23_29_Window.png").getImage();	
				
	}
	
	public void paintComponent (Graphics g) {
		if(image == null) return;
		
		
		int imageWidth = image.getWidth(this);
		System.out.println(getWidth());
		int imageHeight = image.getHeight(this);
		System.out.println(getHeight());
		
		g.drawImage(image,0, 0, null);
		
		for (int i = 0; i*imageWidth <= getWidth(); i++)
			for (int j=0; j*imageHeight <= getHeight(); j++) {
				//System.out.println(i);
				if(i+j > 0) 
					g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);}   
			
			}
	/*public Dimension getPreferrendSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
	}*/
	

}


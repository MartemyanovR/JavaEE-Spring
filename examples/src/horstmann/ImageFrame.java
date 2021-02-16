package horstmann;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class ImageFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT= 150;
	
	JComponent comp =new ImageComponent();
	
	
	public ImageFrame() {
		/*String path = "crawler_crane_256.png";
		URL imgURL = ImageFrame.class.getResource(path);
		ImageIcon icon = new ImageIcon(imgURL);*/
		
		add(comp);
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		pack();
		setLocationRelativeTo(null);
	}

}

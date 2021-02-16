package horstmann;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class RecourceTestFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public RecourceTestFrame() {
		// TODO Auto-generated constructor stub
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		URL aboutURL = getClass().getResource("american.png");
		System.out.println(aboutURL);
		Image img = new ImageIcon(aboutURL).getImage();
		setIconImage(img);
		
		
		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("about.txt");
		System.out.println(stream);
		Scanner in = new Scanner(stream);
		while(in.hasNext())
			textArea.append(in.nextLine() + "\n");
		add(textArea);
	}

}

package horstmann;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

import javax.swing.*;

public class ImageViewFrame extends JFrame{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	private JLabel label;
	private static final Logger logger = Logger.getLogger(
			"src.horstmann.coreJava");
	
	public ImageViewFrame() {
		logger.entering("ImageViewFrame", "init");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//установить строку меню
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new FileOpenListener());
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				logger.fine("Existing");
				System.exit(0);
			}
		});
		
		//использовать метку для обозначения изображений
		label = new JLabel();
		add(label);
		logger.exiting("ImageViewFrame", "init");
	}
	
	private class FileOpenListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
		logger.entering("ImageViewFrame.FileOpenListener",
				"actionPerformed", event);
		
	//установить компонент для выбора файлов
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		//принять все файлы с расширением gif
		chooser.setFileFilter(new javax.swing.filechooser
				.FileFilter() {
			public boolean accept (File f) {
				return f.getName().toLowerCase().endsWith(
						".gif") || f.isDirectory();
			}
			public String getDescription() {
				return "GIF Image";
			}
		});
		
		//показать диалоговое окно для выбора файлов
		int r = chooser.showOpenDialog(ImageViewFrame.this);
		
		//если файл изображения подходит, выбрать его
		//в качестве пиктограммы для метки
		if(r == JFileChooser.APPROVE_OPTION) {
			String name = chooser.getSelectedFile().getPath();
			logger.log(Level.FINE, "Reading file{0}", name);
			label.setIcon(new ImageIcon(name));
		}
		else logger.fine("File open dialog canceled.");
		logger.exiting("ImageViewFrame.FileOpenListener",
				"actionPerformed");
		}
		
	}

}

package horstmann;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.Properties;

public class PropertiesFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 500;
	
	private File propertiesFile;
	private Properties settings;
	
	public PropertiesFrame() {
		//получить положение, размеры и заголовок фрейма из свойств
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("path.separator"));
		String userDir = System.getProperty("user.dir");
		File propertiesDir = new File(userDir, ".corejava");
		System.out.println(propertiesDir);
		if(!propertiesDir.exists())propertiesDir.mkdir();
		propertiesFile = new File (propertiesDir, "program.properties");
		System.out.println(propertiesFile);
		
		Properties defaultSetting = new Properties();
		defaultSetting.put("left", "100");
		defaultSetting.put("top", "150");
		defaultSetting.put("width", "" + DEFAULT_WIDTH);
		defaultSetting.put("height", "" + DEFAULT_HEIGHT);
		defaultSetting.put("title" , "");
		settings = new Properties(defaultSetting);
		
		//загрузка свойств из файла
		if(propertiesFile.exists()) try {		
			FileInputStream in = new FileInputStream(propertiesFile);
			settings.load(in);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left,top,width,height);
		
		//если заголовок не задан, запросить его у пользователя
		String title = settings.getProperty("title");
		if(title.equals("")) title = JOptionPane.showInputDialog("Please supply a frame title:");
		if (title == null) title = "";
		setTitle(title);
		
		addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent event) {
				settings.put("left", "" + getX());
				settings.put("top" , "" + getY());
				settings.put("width", "" + getWidth());
				settings.put("height", "" + getHeight());
				settings.put("title", getTitle());
				try {
					FileOutputStream out = new FileOutputStream(propertiesFile);
					settings.store(out, "Program Properties");
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
	}		
}



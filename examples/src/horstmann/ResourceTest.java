package horstmann;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ResourceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				JFrame frame = new RecourceTestFrame();
				frame.setTitle("RecourceTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}


package horstmann;

import javax.swing.*;
import java.awt.*;

public class PlafFrame extends JFrame {
    private JPanel mPanel;
   
    public PlafFrame() throws HeadlessException {
        mPanel = new JPanel();
        String plaff = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
       //UIManager.LookAndFeelInfo[] inf = UIManager.getInstalledLookAndFeels();
        makeButton("com.sun.java.swing.plaf.motif.MotifLookAndFeel"/*inf[3].getName()*/, plaff /*inf[3].getClassName()*/);
        
       /* UIManager.LookAndFeelInfo[] infos =
                UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }*/

        add(mPanel);
        pack();
    }

    private void makeButton(String name, String className) {
        JButton btn = new JButton(name);
        mPanel.add(btn);

        btn.addActionListener(actionEvent -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(PlafFrame.this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
    public static void main (String []args) {
    EventQueue.invokeLater(new Runnable() {
		
		public void run() {
			JFrame frame = new PlafFrame();
			frame.setTitle("PlafTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	});
}

}
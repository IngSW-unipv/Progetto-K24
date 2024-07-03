package Messaggi;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class MessaggiView extends JFrame {
	public MessaggiView() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width*3/4, Toolkit.getDefaultToolkit().getScreenSize().height*3/4);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(0, 0);
		setVisible(true);
	}
}

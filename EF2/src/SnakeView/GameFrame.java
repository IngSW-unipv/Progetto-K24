package SnakeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GameFrame {

	GamePanel gamepanel;
	JFrame frame;

	public GameFrame() {
		frame = new JFrame();
		gamepanel = new GamePanel();
		frame.add(gamepanel);
		frame.setTitle("Snake");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);

	}

	public GamePanel getPanel() {

		return gamepanel;

	}
	public void setVisible() {
		
		frame.setVisible(true);
		
	}

}


/*
import javax.swing.JFrame;

public class GameFrame extends JFrame{

	public GameFrame(){
			
		this.add(new serpente());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
*/
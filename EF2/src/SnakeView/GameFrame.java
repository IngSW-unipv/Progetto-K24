package SnakeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
/*
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
       frame.setVisible(true);
	}

	public GamePanel getPanel() {

		return gamepanel;

	}
	

	

}
*/

import SnakeModel.serpente;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

	
	
	public GameFrame(){
			
		
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		
		this.setLocationRelativeTo(null);
		
	}
	 
	public void add() {
		
		this.add(getPanel());
		
		
	}
	public GamePanel getPanel() {

		return new GamePanel();

	}
	
	
	
}

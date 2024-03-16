package SnakeModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

public class GamePanel extends JPanel {

	static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 750;
	
	public GamePanel() {

		this.addKeyListener(new MyKeyAdapter());
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);

		
	}
	
	
	

}
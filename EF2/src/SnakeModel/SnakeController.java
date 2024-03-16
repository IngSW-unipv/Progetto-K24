package SnakeModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Main controller as part of MVC design pattern.
 *
 * @author Justin Beringer
 */
public class SnakeController extends JPanel implements ActionListener {

	private SnakeGame model;
	private GameFrame panel;

	//private char direction;

	public SnakeController(GameFrame panel, SnakeGame model) {

		this.model = model;
		this.panel = panel;

		Init();
		panel.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		model.ActionPerformed(panel.getPanel());

	}

	public void Init() {

	//addKeyListener(new MyKeyAdapter());
		startGame1();

	}
	
	public void startGame1() {
		model.newApple();
		 model.running = true;
		model.timer = new Timer(model.DELAY,this);
		model.timer.start();
		System.out.print("cccccc");		
	}

	
}

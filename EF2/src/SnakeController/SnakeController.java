package SnakeController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import SnakeModel.MyKeyAdapter;
import SnakeModel.SnakeGame;
import SnakeView.GameFrame;
import SnakeView.SnakeView;

/**
 * Main controller as part of MVC design pattern.
 *
 * @author Justin Beringer
 */
public class SnakeController implements ActionListener {

	private SnakeGame model;
	private SnakeView view;
	private Timer timer;
	// private char direction;

	public SnakeController(SnakeView view, SnakeGame model) {

		this.model = model;
		this.view = view;

		Init();
		//();

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		model.ActionPerformed();

	}

	public void Init() {

		
		
		model.setTimer(new Timer(model.DELAY, this));
		model.getTimer().start();
		view.getPanel().addKeyListener(new MyKeyAdapter());
		model.startGame(this);

	}

}

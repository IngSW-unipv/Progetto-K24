package SnakeController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Index.IndexModel;
import Index.IndexView;
import SnakeModel.SnakeGame;
import SnakeView.SnakeView;

public class SnakeController {

	public SnakeController(SnakeGame m,SnakeView v)
	
	{
		//JFrame frame = new JFrame("Snake Game");
		SnakeGame gameModel = new SnakeGame();
		SnakeView gameView = new SnakeView();
		v.getFrame().add(gameView);
		v.getFrame().pack();
		v.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		v.getFrame().setLocationRelativeTo(null);
		v.getFrame().setVisible(true);

	}

	public static void addListenersindex(IndexModel m, IndexView view) {

		ActionListener snake = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.snakePlay();

			}

		};

		view.getSnakeButton().addActionListener(snake);

	}

}

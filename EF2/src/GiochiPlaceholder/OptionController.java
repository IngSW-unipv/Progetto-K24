package GiochiPlaceholder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Index.IndexModel;
import Index.IndexView;

public class OptionController {

	public static void addListenersindex(IndexModel m, IndexView view) {

		ActionListener minesweeper = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.minesweeperPlay();

			}

		};

		view.getMinesweeperOption().addActionListener(minesweeper);

		ActionListener snake = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.snakePlay();

			}

		};

		view.getSnakeOption().addActionListener(snake);

		ActionListener solitario = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.solitarioPlay();

			}

		};

		view.getSolitarioOption().addActionListener(solitario);

		ActionListener spaceinvaders = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.spaceInvadersPlay();

			}

		};

		view.getSpaceInvadersOption().addActionListener(spaceinvaders);

		ActionListener tetris = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.solitarioPlay();

			}

		};

		view.getTetrisOption().addActionListener(tetris);

	}

}

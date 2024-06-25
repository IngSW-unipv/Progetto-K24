package GiochiPlaceholder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Index.IndexModel;
import Index.IndexView;

public class OptionController {

	public static void addListenersindex(IndexModel m, IndexView view) {

		view.getMinesweeperOption().addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				m.minesweeperPlay();
			}
		});
		
		view.getSnakeOption().addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				m.snakePlay();
			}
		});
		

		view.getSolitarioOption().addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				m.solitarioPlay();
			}
		});

		view.getSpaceInvadersOption().addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				m.spaceInvadersPlay();
			}
		});


		view.getTetrisOption().addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				m.tetrisPlay();
			}
		});

	}
	
}

package Minesweeper.MinesweeperController;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MineTile;
import Minesweeper.MinesweeperView.MinesweeperView;

public class MinesweeperController {
	private MinesweeperView view;
	private MinesweeperModel model;
	private ArrayList<MineTile> mineList;
	MouseAdapter al;

	// MineTile tile;
	public MinesweeperController() {
		this.view = new MinesweeperView();
		this.model = new MinesweeperModel();
		// view.setMineList(mineList);
		mineList = new ArrayList<MineTile>();

		model.initializeBoard(view.board);

		initcomponents();

		System.out.print(mineList.toString());

		view.Instanciate();

		System.out.print(mineList.toString());

		model.setMines(view.board, mineList, view.tile);// view.getMineList());

	}

	private void initcomponents() {

		al = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Se gameOver è vero si salta tutta la logica del Listener
				if (model.isGameOver()) {
					return;
				}
				view.tile = (MineTile) e.getSource();

				// leftclick, BUTTON1 rappresenta il tasto sinistro
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (view.tile.getText() == "") {
						// significa che ancora non l'abbiamo clickato come bottone
						if (mineList.contains(view.tile)) {

							model.revealMines(view.textLabel, mineList);

						} else {

							model.checkMine(view.tile.getRig(), view.tile.getCol(), view.board, view.textLabel,
									mineList, view.tile);
							System.out.println("CheckMine");
							System.out.println(mineList.contains(view.tile));

						}
					}
				}
				// Tasto destro (BUTTON3) per mettere le bandiere
				else if (e.getButton() == MouseEvent.BUTTON3) {
					if (view.tile.getText() == "" && view.tile.isEnabled()) {
						view.tile.setText("F");
					} else if (view.tile.getText() == "F") {
						view.tile.setText("");
					}
				}
			}
		};

		for (int r = 0; r < view.getNumRighe(); r++) {
			for (int c = 0; c < view.getNumColonne(); c++) {
				view.tile = new MineTile(r, c);
				view.getBoard()[r][c] = view.tile;
				view.tile.setFocusable(false);
				view.tile.setMargin(new Insets(0, 0, 0, 0));
				view.tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
				view.tile.addMouseListener(al);
				view.boardPanel.add(view.tile);
				System.out.println("test");

			}
		}
		System.out.println(view.getNumRighe());

	}

}

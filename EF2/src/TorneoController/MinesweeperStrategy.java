package TorneoController;

import Minesweeper.MinesweeperController.MinesweeperController;
import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MinesweeperView;


public class MinesweeperStrategy implements IStrategyGame {

	private MinesweeperModel modelm;
	private MinesweeperView view;

	public MinesweeperStrategy() {

	}

	@Override
	public Object getGameController() {
		// TODO Auto-generated method stub

		modelm = new MinesweeperModel();
		view = new MinesweeperView();
		System.out.print("Play mine");
		return new MinesweeperController(modelm, view);

	}

}

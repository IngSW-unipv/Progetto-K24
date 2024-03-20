package TorneoController;

import SnakeController.SnakeController;
import SnakeModel.SnakeGame;
import SnakeView.SnakeView;

public class SnakeStrategy implements IStrategyGame{

	@Override
	public Object getGameController() {
		// TODO Auto-generated method stub

		SnakeGame model = new SnakeGame();
		SnakeView view = new SnakeView();

		return new SnakeController(view, model);

	}

}

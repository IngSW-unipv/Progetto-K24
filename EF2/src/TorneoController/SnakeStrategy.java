package TorneoController;

import SnakeModel.SnakeController;

public class SnakeStrategy implements IStrategyGame{

	@Override
	public Object getGameController() {
		// TODO Auto-generated method stub
		
			return new SnakeController(null, null);
		
	}

}

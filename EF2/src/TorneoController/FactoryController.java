package TorneoController;

import java.lang.reflect.Constructor;


public class FactoryController {

	private IStrategyGame type;

	public IStrategyGame getGameStrategyController(String PROPERTYNAME) {

		if (type == null) {

			String GameClassName;

			try {

				GameClassName = "TorneoController." + PROPERTYNAME.substring(0, PROPERTYNAME.length() - 1) + "Strategy";

				Constructor<?> c = Class.forName(GameClassName).getConstructor();
				type = (IStrategyGame) c.newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				type = null;
			}

		}
		return type;
	}

}

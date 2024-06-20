package TorneoController;

import java.lang.reflect.Constructor;

import Strategy.IStrategyGame;

public class FactoryController {

	private IStrategyGame type;

	public IStrategyGame getGameStrategyController(String PROPERTYNAME) {
		if (PROPERTYNAME == null || PROPERTYNAME.isEmpty()) {
			throw new IllegalArgumentException("PROPERTYNAME cannot be null or empty");
		}

		if (type == null) {

			String gameClassName = "Strategy." + PROPERTYNAME
					+ "Strategy";
			try {
				Constructor c = Class.forName(gameClassName).getConstructor();
				type = (IStrategyGame) c.newInstance();
			} catch (ClassNotFoundException e) {
				System.err.println("Class not found: " + gameClassName);
				e.printStackTrace();
				type = null;
			} catch (NoSuchMethodException e) {
				System.err.println("No suitable constructor found for class: " + gameClassName);
				e.printStackTrace();
				type = null;
			} catch (InstantiationException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
				System.err.println("Error instantiating class: " + gameClassName);
				e.printStackTrace();
				type = null;
			}
		}

		return type;
	}
}
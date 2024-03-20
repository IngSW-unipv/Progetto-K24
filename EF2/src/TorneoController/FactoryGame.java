package TorneoController;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class FactoryGame {

	private IStrategyGame type;

	public IStrategyGame getGameStrategy(String PROPERTYNAME) {

		if (type == null) {

			Properties p = new Properties(System.getProperties());
			String GameClassName;

			try {
				File file = new File("properties/Strategy.txt");
				FileInputStream ph = new FileInputStream(file);
				PROPERTYNAME=PROPERTYNAME.replaceAll("\\s","");
				System.out.print(PROPERTYNAME);
				p.load(ph);
				
				GameClassName = p.getProperty(PROPERTYNAME);

				Constructor c = Class.forName(GameClassName).getConstructor();
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

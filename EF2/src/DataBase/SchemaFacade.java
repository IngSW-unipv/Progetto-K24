package DataBase;

public class SchemaFacade {

	private static SchemaFacade instance;

	private SchemaFacade() {

	}

	public static SchemaFacade getInstance() {
		if (instance == null)
			instance = new SchemaFacade();
		return instance;
	}

}

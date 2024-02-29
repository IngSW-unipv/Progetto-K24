package Utente;

import DataBase.TorneoDao;

public class FactoryGestioneTorneo {

	private TorneoDao torneodao;

	private static FactoryGestioneTorneo instance;

	private FactoryGestioneTorneo() {

	}

	public static FactoryGestioneTorneo getInstance() {
		if (instance == null) {
			instance = new FactoryGestioneTorneo();
		}
		return instance;
	}

	public TorneoDao creaTorneoDao() {

		return TorneoDao.getIstance();
		

	}

}

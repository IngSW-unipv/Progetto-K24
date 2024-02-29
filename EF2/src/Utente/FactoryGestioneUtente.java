package Utente;

import DataBase.UtenteDao;

public class FactoryGestioneUtente {

	private UtenteAutenticato utente;
	private UtenteDao utentedao;

	private static FactoryGestioneUtente instance;

	private FactoryGestioneUtente() {

	}

	public static FactoryGestioneUtente getInstance() {
		if (instance == null) {
			instance = new FactoryGestioneUtente();
		}
		return instance;
	}

	public UtenteAutenticato creaUtente() {

		utente = UtenteAutenticato.getInstance();

		return utente;

	}

	public UtenteDao creaUtentedao() {

		utentedao = UtenteDao.getInstance();

		return utentedao;

	}

}

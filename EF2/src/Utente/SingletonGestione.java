package Utente;

import DataBase.TorneoDao;
import DataBase.UtenteDao;

public class SingletonGestione {

	private static SingletonGestione instance = null;

	
	private UtenteAutenticato utente;
    private UtenteDao utentedao;
    private TorneoDao torneodao;

	// Costruttore privato
	private SingletonGestione() {
		// Inizializzazione oggetti
		
		utente = new UtenteAutenticato();
		utentedao=new UtenteDao();
		torneodao=new TorneoDao();
	}

	public UtenteDao getUtentedao() {
		return utentedao;
	}

	public void setUtentedao(UtenteDao utentedao) {
		this.utentedao = utentedao;
	}

	public TorneoDao getTorneodao() {
		return torneodao;
	}

	public void setTorneodao(TorneoDao torneodao) {
		this.torneodao = torneodao;
	}

	// Metodo pubblico per ottenere l'istanza Singleton
	public static SingletonGestione getInstance() {
		if (instance == null) {
			instance = new SingletonGestione();
		}
		return instance;
	}

	public UtenteAutenticato getUtente() {
		return utente;
	}

	public void setUtente(UtenteAutenticato utente) {
		this.utente = utente;
	}
	
	

}
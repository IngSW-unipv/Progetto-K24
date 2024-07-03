package Utente;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import DataBase.TorneoDao;
import DataBase.UtenteDao;
import Index.GiochiEnum;
import Messaggi.Messaggio;
import TorneoController.CreaTorneoController;
import TorneoView.CreaTorneoView;

public class UtenteAutenticato extends Utente {

	private static UtenteAutenticato instance;
	private ArrayList<GiochiEnum> preferiti;
	private ArrayList<Messaggio> messaggi;

	private UtenteAutenticato() {
		super("", "", "");
	}

	public static UtenteAutenticato getInstance() {
		if (instance == null) {
			instance = new UtenteAutenticato();
		}
		return instance;
	}

	// MI SEMBRA VAda BENE cosi ( e non CHE HA IN INGRESSO STRINGA e set avviene
	// qui. set avviene nel facade model )
	public void cambiaUsername() {
		UtenteDao.getInstance().updateSchemaUtente(this);
	}

	public void registrazioneCredenziali() throws SQLException {
		UtenteDao.getInstance().insertSchemaUtente(this);
	}

	public void eliminaAccount() {
		UtenteDao.getInstance().eliminaSchemaUtente(this);
	}

	public boolean ricercaUtente(String email) {
		return UtenteDao.getInstance().selectByEmail(email);
	}

	// Relativi ai tornei
	public boolean ricercaTorneo(String nometorneo) {
		return TorneoDao.getInstance().ricercaTorneo(nometorneo);
	}

	public boolean ricercaIscritto(String nometorneo, String emailUtente) {
		return TorneoDao.getInstance().ricercaIscritto(nometorneo, emailUtente);
	}

	public ArrayList<String> ricercaDatiTorneo(String nometorneo) {
		return TorneoDao.getInstance().selectAllByTorneo(nometorneo);
	}

	public void creazioneTorneo(String nometorneo, String nomecreatore, String gioco, java.util.Date date,
			java.util.Date date_) {

		try {
			if (TorneoDao.getInstance().ricercaTorneo(nometorneo)) {
				TorneoDao.getInstance().insertTorneo(nometorneo, nomecreatore, gioco, date, date_);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int iscrizioneTorneo(String emailutente, String nometorneo) {
		try {
			if (!TorneoDao.getInstance().selezionaUtenteTorneo(emailutente, nometorneo)) {
				TorneoDao.getInstance().insertpartecipante(emailutente, nometorneo, 0);
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		return 2;
	}

	public void disiscrizioneTorneo(String emailutente, String nometorneo) {
		try {
			if (!(TorneoDao.getInstance().ricercaTorneo(nometorneo)))
				TorneoDao.getInstance().deletePartecipante(emailutente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminaTorneo(String nometorneo, String nomeutente) {
		if (TorneoDao.getInstance().ricercaCreatore(nomeutente)) {
			TorneoDao.getInstance().deleteTorneo(nometorneo);
		}
	}

	public ArrayList<String> selezionalistatorneobypartecipante(String f) {
		return TorneoDao.getInstance().selezionalistatorneobypartecipante(f);
	}

	public HashMap<String, Integer> selezionaclassifica(String Torneo) {
		return TorneoDao.getInstance().selezionaclassifica(Torneo);
	}

	// Relative ai preferiti
	public void insertPreferiti(GiochiEnum gioco) {
		UtenteDao.getInstance().insertPreferiti(this, gioco);
		preferiti.add(gioco);
	}

	public void deletePreferiti(GiochiEnum gioco) {
		UtenteDao.getInstance().deletePreferiti(this, gioco);
		preferiti.remove(gioco);
	}

	// Equivale a un setter dei preferiti ma avviene esclusivamente attraverso il
	// dao con info dal db
	public void selectPreferiti() {
		preferiti = UtenteDao.getInstance().selectPreferiti(this);
	}

	public ArrayList<GiochiEnum> getPreferiti() {
		return preferiti;
	}

	public void clear() {
		this.setUsername(null);
		this.setEmail(null);
		this.setPassword("".toCharArray());
	}

}

//Non andavano accoppiati torneo e utente, serviva un facade che li prendesse a coppia
//Passare dal controller al model della modifica utente una stringa è sbagliatissimo, non c'è incapsulamento. 
//Non importa che l'utente fosse singleton, andava comunque passato come paramtero al metodo modificaAccount
//perché non possiamo passare una Stringa, accoppia troppo
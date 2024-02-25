package Utente;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import DataBase.TorneoDao;
import DataBase.UtenteDao;
import Torneo.Torneo;
import TorneoController.CreaTorneoController;
import TorneoView.CreaTorneoView;

public class UtenteAutenticato extends Utente {

	private UtenteDao dao;
	private TorneoDao daot;
	private static UtenteAutenticato instance;

	private UtenteAutenticato(String userName, String email, String password) {
		super(userName, email, password);

	}

	public static synchronized UtenteAutenticato getInstance(String userName, String email, String passwor) {
		if (instance == null)
			instance = new UtenteAutenticato(userName, email, passwor);
		return instance;

	}

	public void registrazioneCredenziali( UtenteAutenticato u,String username, String email, String password) throws SQLException {

		
		dao = new UtenteDao();
		dao.insertSchemaUtente(u);
        
		
	}
	
	// Come quello sotto è stato modifcato con un this
	//Ne serve uno nuovo per cambiare la password? Ma poi come si fa dall'interfaccia grafica a capire quale va cambiato
	public void cambiaUsername(String nomeNuovo) {
		setUsername(nomeNuovo);
		dao = new UtenteDao();
		dao.updateSchemaUtente(this);
	}

	/*  PRIMA ERA COSì, IO LI CAMBIEREI TUTTI CON THIS ANZICHE IL PASSAGGIO DI TUTTI I PARAMTERI PER LA CREAZIONE
	 * 	public void eliminaAccount(UtenteAutenticato utente, int id, String username, String email, String password) {
		utente = new UtenteAutenticato(username, email, password);
		dao = new UtenteDao();
		dao.eliminaSchemaUtente(utente);

	}
	 */
	public void eliminaAccount() {
		dao = new UtenteDao();
		dao.eliminaSchemaUtente(this);

	}

	public void istanziaTorneo(String nometorneo) {

		daot = new TorneoDao();
		var list = daot.selecttuplebytorneo(nometorneo);
		//Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));

	}

	public void creazioneTorneo(String nometorneo, String nomecreatore, String gioco, java.util.Date date,
			java.util.Date date_, String visibilità) {

		 daot = new TorneoDao();
		try {
			if (!(daot.elencatorneo().contains(nometorneo))) {
				daot.insertTorneo(nometorneo, nomecreatore, gioco, date, date_, visibilità);
				System.out.println(daot.insertTorneo(nometorneo, nomecreatore, gioco, date, date_, visibilità));
			}
		} catch (Exception e) {
			e.printStackTrace();
			creazioneControllerTorneo();

		}
	}

	public void creazioneControllerTorneo() {

		CreaTorneoController c = new CreaTorneoController();

	}

	public void iscrizioneTorneo(String emailutente, String nometorneo) { //manca controllo che il torneo sia iniziato e non finito

		daot = new TorneoDao();

		try {
			if (true) {      
				
				//(!(daot.selectbytorneo(nometorneo).contains(emailutente))&& daot.elencatorneo().contains(nometorneo))
				
				daot.insertpartecipante(emailutente, nometorneo, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disiscrizioneTorneo(String emailutente, String nometorneo) {

		daot = new TorneoDao();
		try {
			if (daot.selectbytorneo(nometorneo).contains(emailutente))
				daot.deletepartecipante(emailutente);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void eliminaTorneo(String nometorneo) { // va aggiunto un controllo che a eliminare il torneo può essere solo il creatore

		daot = new TorneoDao();
		daot.deleteTorneo(nometorneo);

	}

	public void visualizzaLista() {
		daot = new TorneoDao();
		daot.selectbyuser();

	}
	
}

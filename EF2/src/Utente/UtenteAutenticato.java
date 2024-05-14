package Utente;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import DataBase.TorneoDao;
import DataBase.UtenteDao;
import TorneoController.CreaTorneoController;
import TorneoView.CreaTorneoView;

public class UtenteAutenticato extends Utente {

	private static UtenteAutenticato instance;

	

	private UtenteAutenticato() {

		super("", "", "");

	}

	public static UtenteAutenticato getInstance() {

		if (instance == null) {

			instance = new UtenteAutenticato();

		}

		return instance;
	}

	public void cambiaUsername(String newUsername) {
		this.setUsername(newUsername);
		UtenteDao.getInstance().updateSchemaUtente(this);
	}

	public void registrazioneCredenziali(UtenteAutenticato u) throws SQLException {

		
		UtenteDao.getInstance().insertSchemaUtente(u);

	}

	public void eliminaAccount() {
		
		UtenteDao.getInstance().eliminaSchemaUtente(this);
	}

	public boolean ricercaUtente(String email) {

		
		return UtenteDao.getInstance().selectByEmail(email);

	}

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

	public void iscrizioneTorneo(String emailutente, String nometorneo) { 

		try {
			if (TorneoDao.getInstance().ricercaCreatore(emailutente))   {
				TorneoDao.getInstance().insertpartecipante(emailutente, nometorneo, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disiscrizioneTorneo(String emailutente, String nometorneo) {

		try {
			if (!(TorneoDao.getInstance().ricercaTorneo(nometorneo)))
				TorneoDao.getInstance().deletePartecipante(emailutente);
		}

		catch (Exception e) {
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
 
	public void clear() {
		this.setUsername(null);
		this.setEmail(null);
		this.setPassword(null); 
		
	}

}

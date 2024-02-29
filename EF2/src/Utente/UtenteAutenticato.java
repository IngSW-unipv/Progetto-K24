package Utente;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DataBase.TorneoDao;
import DataBase.UtenteDao;
import Torneo.Torneo;
import TorneoController.CreaTorneoController;
import TorneoView.CreaTorneoView;

public class UtenteAutenticato extends Utente {

	private static UtenteAutenticato istance;

	// costruttore da istanziare per utetne vuoto

	private UtenteAutenticato() {

		super("", "", "");

	}

	public static UtenteAutenticato getIstance() {

		if (istance == null) {

			istance = new UtenteAutenticato();

		}

		return istance;
	}

	public void cambiaUsername(String newUsername) {
		this.setUsername(newUsername);
		SingletonGestione.getInstance().getUtentedao().updateSchemaUtente(this);
	}

	public void registrazioneCredenziali(UtenteAutenticato u) throws SQLException {

		// SingletonGestione.getInstance().getUtentedao().insertSchemaUtente(u);
		UtenteDao.getIstance().insertSchemaUtente(u);

	}

	public void eliminaAccount() {
		// SingletonGestione.getInstance().getUtentedao().eliminaSchemaUtente(this);
		UtenteDao.getIstance().eliminaSchemaUtente(this);
	}

	public boolean ricercaUtente(String email) {

		// return SingletonGestione.getInstance().getUtentedao().selectByEmail(email);
		return UtenteDao.getIstance().selectByEmail(email);

	}

	public boolean ricercaTorneo(String nometorneo) {

		// return
		// SingletonGestione.getInstance().getTorneodao().ricercaTorneo(nometorneo);

		return TorneoDao.getIstance().ricercaTorneo(nometorneo);

	}

	public boolean ricercaIscritto(String nometorneo, String emailUtente) {

		return TorneoDao.getIstance().ricercaIscritto(nometorneo, emailUtente);

	}

	public ArrayList<String> ricercaDatiTorneo(String nometorneo) {

		return TorneoDao.getIstance().selectAllByTorneo(nometorneo);
		// Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2),
		// list.get(3), list.get(4), list.get(5));

	}

	public void creazioneTorneo(String nometorneo, String nomecreatore, String gioco, java.util.Date date,
			java.util.Date date_) {

		try {
			if (TorneoDao.getIstance().ricercaTorneo(nometorneo)) {
				TorneoDao.getIstance().insertTorneo(nometorneo, nomecreatore, gioco, date, date_);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// creazioneControllerTorneo();

		}
	}

	public void iscrizioneTorneo(String emailutente, String nometorneo) { // manca controllo che il torneo sia iniziato

		try {
			if (TorneoDao.getIstance().ricercaCreatore(emailutente)) {
				TorneoDao.getIstance().insertpartecipante(emailutente, nometorneo, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disiscrizioneTorneo(String emailutente, String nometorneo) {

		try {
			if (!(TorneoDao.getIstance().ricercaTorneo(nometorneo)))
				TorneoDao.getIstance().deletePartecipante(emailutente);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void eliminaTorneo(String nometorneo, String nomeutente) { // va aggiunto un controllo che a eliminare il
																		// torneo può essere solo

		// il creatore
		if (TorneoDao.getIstance().ricercaCreatore(nomeutente))
			TorneoDao.getIstance().deleteTorneo(nometorneo);

	}

}

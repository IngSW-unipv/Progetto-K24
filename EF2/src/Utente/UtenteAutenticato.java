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

	// costruttore da istanziare per utetne vuoto

	public UtenteAutenticato() {

		super("", "", "");

		
	}

	public UtenteAutenticato(String userName, String email, String password) {
		super(userName, email, password);
		daot = SingletonGestione.getInstance().getTorneodao();
		dao = SingletonGestione.getInstance().getUtentedao();
	}

	public void cambiaUsername(UtenteAutenticato utente, String nomeNuovo, String email) {
	
		 utente=SingletonGestione.getInstance().getUtente();

		dao.updateSchemaUtente(utente);
	}

	public void registrazioneCredenziali(UtenteAutenticato u, String username, String email, String password)
			throws SQLException {

		dao.insertSchemaUtente(u);

	}

	public void eliminaAccount(UtenteAutenticato utente, int id, String username, String email, String password) {
		utente = new UtenteAutenticato(username, email, password);

		dao.eliminaSchemaUtente(utente);

	}

	public void istanziaTorneo(String nometorneo) {

		var list = daot.selecttuplebytorneo(nometorneo);
		// Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2),
		// list.get(3), list.get(4), list.get(5));

	}

	public void creazioneTorneo(String nometorneo, String nomecreatore, String gioco, java.util.Date date,
			java.util.Date date_, String visibilità) {

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

	public void iscrizioneTorneo(String emailutente, String nometorneo) { // manca controllo che il torneo sia iniziato
																			// e non finito

		try {
			if (true) {

				// (!(daot.selectbytorneo(nometorneo).contains(emailutente))&&
				// daot.elencatorneo().contains(nometorneo))

				daot.insertpartecipante(emailutente, nometorneo, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disiscrizioneTorneo(String emailutente, String nometorneo) {

		try {
			if (daot.selectbytorneo(nometorneo).contains(emailutente))
				daot.deletepartecipante(emailutente);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void eliminaTorneo(String nometorneo) { // va aggiunto un controllo che a eliminare il torneo può essere solo
													// il creatore

		daot.deleteTorneo(nometorneo);

	}

	public void visualizzaLista() {

		daot.selectbyuser();

	}

}

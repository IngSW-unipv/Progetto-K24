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

	public UtenteAutenticato(int id, String userName, String email, String password) {
		super(id, userName, email, password);

	}

	public void cambiausername(UtenteAutenticato utente, String nomeNuovo, String email) {

		utente = new UtenteAutenticato(0, nomeNuovo, email, "");
		dao = new UtenteDao();
		dao.UpdateSchemautente(utente);
	}

	public void registrazionecredenziali(int id, String username, String email, String password) throws SQLException {

		dao = new UtenteDao();
		dao.insertSchemautente(new UtenteAutenticato(id, username, email, password));

	}

	public void eliminaAccount(UtenteAutenticato utente, int id, String username, String email, String password) {
		utente = new UtenteAutenticato(id, username, email, password);
		dao = new UtenteDao();
		dao.eliminaSchemautente(utente);

	}

	public void istanziatorneo(String nometorneo) {

		daot = new TorneoDao();
		var list =daot.selecttuplebytorneo(nometorneo);
		Torneo Torneo = new Torneo(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));

	}

	public void creazionetorneo(String nometorneo, String nomecreatore, String gioco, java.util.Date date,
			java.util.Date date_, String visibilità) {

		TorneoDao daot = new TorneoDao();
		try {
			if (!(daot.elencatorneo().contains(nometorneo))) {
				daot.insertTorneo(nometorneo, nomecreatore, gioco, date, date_, visibilità);
				System.out.println(daot.insertTorneo(nometorneo, nomecreatore, gioco, date, date_, visibilità));
			}
		} catch (Exception e) {
			e.printStackTrace();
			creazionecontrollertorneo();

		}
		// CreaTorneoView v=new CreaTorneoView();
		// CreaTorneoController c=new CreaTorneoController(v);

	}

	public void creazionecontrollertorneo() {

		CreaTorneoController c = new CreaTorneoController();

	}

	public void iscrizionetorneo(String emailutente,String nometorneo ,int punteggio) {

		daot = new TorneoDao();

		try {
			if ((!(daot.selectbytorneo(nometorneo).contains(emailutente)) &&daot.elencatorneo().contains(nometorneo)) ) {
				daot.insertpartecipante(emailutente, nometorneo, punteggio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disiscrizionetorneo(String emailutente,String nometorneo) {

		daot = new TorneoDao();
		try {
			if(daot.selectbytorneo(nometorneo).contains(emailutente))
			daot.deletepartecipante(emailutente);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void eliminatorneo(String nometorneo) {

		daot = new TorneoDao();
		daot.deleteTorneo(nometorneo);

	}

	public void visualizzalista() {
		daot = new TorneoDao();
		daot.selectbyuser();

	}

}

//amicizia
//giochi preferiti
//iscrizione tornei
//creazione tornei

//Queste necessitano di un collegamento al database
//disiscrizione
//cambio credenziali

// Chiedere al prof se ha senso usare questo pattern per utente.
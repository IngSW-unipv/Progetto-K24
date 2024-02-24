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

	public void cambiausername(UtenteAutenticato utente, String nomeNuovo, String email) {

		utente = new UtenteAutenticato(nomeNuovo, email, "");
		dao = new UtenteDao();
		dao.updateSchemaUtente(utente);
	}

	public void registrazioneCredenziali( UtenteAutenticato u,String username, String email, String password) throws SQLException {

		
		dao = new UtenteDao();
		dao.insertSchemaUtente(u);
        
		
	}

	public void eliminaAccount(UtenteAutenticato utente, int id, String username, String email, String password) {
		utente = new UtenteAutenticato(username, email, password);
		dao = new UtenteDao();
		dao.eliminaSchemaUtente(utente);

	}

	public void istanziatorneo(String nometorneo) {

		daot = new TorneoDao();
		var list = daot.selecttuplebytorneo(nometorneo);
		Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));

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

	public void iscrizionetorneo(String emailutente, String nometorneo) {

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

	public void disiscrizionetorneo(String emailutente, String nometorneo) {

		daot = new TorneoDao();
		try {
			if (daot.selectbytorneo(nometorneo).contains(emailutente))
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

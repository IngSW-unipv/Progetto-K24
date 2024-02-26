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

	public void eliminaAccount(UtenteAutenticato utente,  String username, String email, String password) {
		utente = new UtenteAutenticato(username, email, password);

		dao.eliminaSchemaUtente(utente);

	}
	
	public boolean ricercaUtente(String email) {
		

		return dao.selectByEmail(email);

	}
	
    public boolean ricercaTorneo(String nometorneo) {
		

		return daot.ricercaTorneo(nometorneo);

	}
    
    public boolean ricercaIscritto(String nometorneo,String emailUtente) {
		

		return daot.ricercaIscritto(nometorneo,emailUtente);

	}
    
    
    public  ArrayList<String> ricercaDatiTorneo(String nometorneo) {

		return daot.selectAllByTorneo(nometorneo);
		// Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2),
		// list.get(3), list.get(4), list.get(5));

	}
    

	public void istanziaTorneo(String nometorneo) {

		var list = daot.selectAllByTorneo(nometorneo);
		// Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2),
		// list.get(3), list.get(4), list.get(5));

	}

	public void creazioneTorneo(String nometorneo, String nomecreatore, String gioco, java.util.Date date,
			java.util.Date date_) {

		daot=new TorneoDao();
		
		try {
			if (daot.ricercaTorneo(nometorneo)) 
					{
				daot.insertTorneo(nometorneo, nomecreatore, gioco, date, date_);
				
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
			
		
		daot=new TorneoDao();
		try {
			if (true )//(!(daot.selectbytorneo(nometorneo).contains(emailutente))&&daot.elencatorneo().contains(nometorneo))) 
			{
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

	public void eliminaTorneo(String nometorneo,String nomeutente) { // va aggiunto un controllo che a eliminare il torneo può essere solo
				
		
		// il creatore
        if(SingletonGestione.getInstance().getTorneodao().isCreatore(nomeutente))
        	SingletonGestione.getInstance().getTorneodao().deleteTorneo(nometorneo);

	}

	public void visualizzaLista() {

		daot.selectbyuser();

	}

}

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

	// costruttore da istanziare per utetne vuoto

	public UtenteAutenticato() {

		super("", "", "");

		
	}

	public UtenteAutenticato(String userName, String email, String password) {
		super(userName, email, password);
		
	}

	public void cambiaUsername(String newUsername) {
		 this.setUsername(newUsername);
		 SingletonGestione.getInstance().getUtentedao().updateSchemaUtente(this);
	}

	public void registrazioneCredenziali(UtenteAutenticato u, String username, String email, String password)
			throws SQLException {

		SingletonGestione.getInstance().getUtentedao().insertSchemaUtente(u);

	}

	public void eliminaAccount() {
		SingletonGestione.getInstance().getUtentedao().eliminaSchemaUtente(this);
	}
	
	public boolean ricercaUtente(String email) {
		

		return SingletonGestione.getInstance().getUtentedao().selectByEmail(email);

	}
	
    public boolean ricercaTorneo(String nometorneo) {
		

		return SingletonGestione.getInstance().getTorneodao().ricercaTorneo(nometorneo);

	}
    
    public boolean ricercaIscritto(String nometorneo,String emailUtente) {
		

		return SingletonGestione.getInstance().getTorneodao().ricercaIscritto(nometorneo,emailUtente);

	}
    
    
    public  ArrayList<String> ricercaDatiTorneo(String nometorneo) {

		return SingletonGestione.getInstance().getTorneodao().selectAllByTorneo(nometorneo);
		// Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2),
		// list.get(3), list.get(4), list.get(5));

	}
    

	public void istanziaTorneo(String nometorneo) {

		var list = SingletonGestione.getInstance().getTorneodao().selectAllByTorneo(nometorneo);
		// Torneo Torneo = new Torneo(list.get(0), list.get(1), list.get(2),
		// list.get(3), list.get(4), list.get(5));

	}

	public void creazioneTorneo(String nometorneo, String nomecreatore, String gioco, java.util.Date date,
			java.util.Date date_) {

		
		
		try {
			if (SingletonGestione.getInstance().getTorneodao().ricercaTorneo(nometorneo)) 
					{
				SingletonGestione.getInstance().getTorneodao().insertTorneo(nometorneo, nomecreatore, gioco, date, date_);
				
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
			
		
	
		try {
			if (SingletonGestione.getInstance().getTorneodao().ricercaCreatore(emailutente)) 
			{
				SingletonGestione.getInstance().getTorneodao().insertpartecipante(emailutente, nometorneo, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disiscrizioneTorneo(String emailutente, String nometorneo) {

		
		try {
			if (!(SingletonGestione.getInstance().getTorneodao().ricercaTorneo(nometorneo)))
				SingletonGestione.getInstance().getTorneodao().deletePartecipante(emailutente);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void eliminaTorneo(String nometorneo,String nomeutente) { // va aggiunto un controllo che a eliminare il torneo può essere solo
				
		
		// il creatore
        if(SingletonGestione.getInstance().getTorneodao().ricercaCreatore(nomeutente))
        	SingletonGestione.getInstance().getTorneodao().deleteTorneo(nometorneo);

	}

	public void visualizzaLista() {

		SingletonGestione.getInstance().getTorneodao().selectbyuser();

	}

}

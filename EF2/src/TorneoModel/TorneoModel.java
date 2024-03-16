package TorneoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Utente.UtenteAutenticato;

public class TorneoModel {

	public TorneoModel() {

	}

	public void creaTorneo(String nome,String email ,String gioco,String date,String date_) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		
		
		
		Date date1 = null;
		try {
			date1 = dateFormat.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Date date_1 = null;
		try {
			date_1 = dateFormat.parse(date_);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		UtenteAutenticato.getInstance().creazioneTorneo(nome,email,gioco,date1,date_1);

	}

	public void disiscrizioneTorneo(String email, String nome) {

		UtenteAutenticato.getInstance().disiscrizioneTorneo(email,nome);

	}

	public void eliminaTorneo(String email, String nome) {

		UtenteAutenticato.getInstance().eliminaTorneo(email,nome); 

	}

	public void iscrizioneTorneo(String email, String nome) {

		UtenteAutenticato.getInstance().iscrizioneTorneo(email,nome);

	}
	
	public String getEmail() {
		
		
		return UtenteAutenticato.getInstance().getEmail();
		
	}
	
	public String getUsername() {
		
		
		return UtenteAutenticato.getInstance().getUsername();
		
	}

}

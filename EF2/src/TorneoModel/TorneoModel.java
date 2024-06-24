package TorneoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import DataBase.TorneoDao;
import Strategy.IStrategyGame;
import TorneoController.FactoryController;
import Utente.UtenteAutenticato;

public class TorneoModel {

	private IStrategyGame strategy;
	private FactoryController factory;

	public TorneoModel() {

	}

	public void creaTorneo(String nome, String email, String gioco, String date, String date_) {

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

		UtenteAutenticato.getInstance().creazioneTorneo(nome, email, gioco, date1, date_1);

	}

	public void disiscrizioneTorneo(String email, String nome) {

		UtenteAutenticato.getInstance().disiscrizioneTorneo(email, nome);

	}

	public void eliminaTorneo(String email, String nome) {

		UtenteAutenticato.getInstance().eliminaTorneo(email, nome);

	}

	public void iscrizioneTorneo(String email, String nome) {

		UtenteAutenticato.getInstance().iscrizioneTorneo(email, nome);

	}

	public HashMap<String, Integer> classificaTorneo(String Torneo) {

		var arraylist = UtenteAutenticato.getInstance().selezionaclassifica(Torneo);
		
		System.out.print(arraylist);

		//ha senso implementare metodo qui per riordino
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(arraylist.entrySet());
		/*
		 * Collections.sort(list, new Comparator<Entry<String, Integer>>() {
		 * 
		 * public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
		 * 
		 * return e1.getValue() - e2.getValue();
		 * 
		 * }
		 * 
		 * });
		 */

		return arraylist;

	}

	public void partecipaToreno(String nomeTorneo) {

		System.out.print("Partecipa al Torneo" + UtenteAutenticato.getInstance().ricercaDatiTorneo(nomeTorneo).get(0));

		factory = new FactoryController();

		strategy = factory.getGameStrategyController(UtenteAutenticato.getInstance().ricercaDatiTorneo(nomeTorneo).get(0));

		strategy.getGameController();

	}

	public String getEmail() {

		return UtenteAutenticato.getInstance().getEmail();

	}
	
	
	public ArrayList<String> selezionalistatorneobypartecipante(String s){
		
		return UtenteAutenticato.getInstance().selezionalistatorneobypartecipante(s);
		
	}
	

	public String getUsername() {

		return UtenteAutenticato.getInstance().getUsername();

	}

}

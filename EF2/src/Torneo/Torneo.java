package Torneo;


import java.util.List;


import Gestione.IGame;

public class Torneo {

	 private IGame gioco;

	 public Torneo(IGame gioco) {
	        this.gioco = gioco;
	  
	    }

	public Torneo(String string, String string2, String string3, String string4, String string5, String string6) {
		// TODO Auto-generated constructor stub
	}

	public IGame getGioco() {
		return gioco;
	}

	public void setGioco(IGame gioco) {
		this.gioco = gioco;
	}

	public void modificaPunteggio() {
		
	}
	public void verificaPunteggio() {
		
	}
	public void nuovaPartita() {
	
	}
	public void stampaClassifica() {
	
	}
	
	
	
}

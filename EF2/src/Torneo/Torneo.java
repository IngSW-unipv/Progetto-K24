package Torneo;


import java.util.List;


import Gestione.IGame;

public class Torneo {
	private String nomeTorneo;
	private IGame gioco;

	public Torneo(IGame gioco, String nome) {
	        this.gioco = gioco;
	        this.nome = nome;
	  
	    }

	public IGame getGioco() {
		return gioco;
	}

	public void setGioco(IGame gioco) {
		this.gioco = gioco;
	}

	public void modificaPunteggio(int nuovoPunteggio) {
		/* riceve nuovo punteggio, va a modificare il punteggio precedente dell'utente chiamante e del torneo corrente
		 * 
		 */
	}
	public void verificaPunteggio(int nuovoPunteggio) {
		/* riceve nuovo punteggio, prende dal database tramite metodo di torneoDao quello precedente, se il nuovo punteggio è maggiore chiama modificaPunteggio 
		 */
	}
	public void nuovaPartita() {
	/* inizializza controller (tramite il model del gioco?) che farà partire il gioco. raggiunta la fine del gioco, 
	 * si ottiene il valore del punteggio e lo si usa chiamando verificaPunteggio
	
	*/
	}
	public void stampaClassifica() {
		/* chiama metodo del dao che elenca tutti i giocatori di questo torneo e i loro punteggi, li mette in una mappa e poi li ordina per punteggio */
	}
	
	
	
}

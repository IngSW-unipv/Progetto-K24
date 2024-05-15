package Index;

import javax.swing.JButton;

public class GameButton extends JButton {
	private boolean preferito;
	private final GiochiEnum gioco;
	
	public GameButton(GiochiEnum gioco) {
		super(gioco.toString());
		this.gioco = gioco;
		preferito = false;
	}
	
	public GiochiEnum getGioco() {
		return gioco;
	}
	
	public boolean isPreferito() {
		return preferito;
	}
	
	public void aggiungiPreferito() {
		preferito = true;
	}
	
	public void rimuoviPreferito() {
		preferito = false;
	}
	
	
}

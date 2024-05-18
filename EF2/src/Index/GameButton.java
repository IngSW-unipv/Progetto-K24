package Index;

import javax.swing.JButton;

public class GameButton extends JButton {
	private final GiochiEnum gioco;
	
	public GameButton(GiochiEnum gioco) {
		super(gioco.toString());
		this.gioco = gioco;
	}
	
	public GiochiEnum getGioco() {
		return gioco;
	}

	
	
}

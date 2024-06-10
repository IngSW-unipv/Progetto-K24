package Index;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Autenticazionecontroller.LogoutController;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.ModificaAccountController;
import GiochiPlaceholder.OptionController;
import GiochiPlaceholder.PreferitiController;
import GiochiPlaceholder.SolitarioController;
import GiochiPlaceholder.SpaceInvadersController;
import GiochiPlaceholder.TetrisController;
import Minesweeper.MinesweeperController.MinesweeperController;
import SnakeController.SnakeController;
import TorneoController.CreaTorneoController;
import TorneoController.DisiscrizioneTorneoController;
import TorneoController.EliminaTorneoController;
import TorneoController.IscrizioneTorneoController;
import TorneoController.PartecipaTorneoController;

public class IndexFacadeController {

	private IndexView view;
	private IndexModel model;

	public IndexFacadeController(IndexModel model, IndexView view) {

		this.model = model;
		this.view = view;
		addListeners();
	}

	public void addListeners() {

		// modifica account ed elimina account, logout
		EliminaAccountController.addListenersindex(model, view);
		ModificaAccountController.addListenersindex(model, view);
		EliminaTorneoController.addListenersindex(model, view);
		DisiscrizioneTorneoController.addListenersindex(model, view);
		IscrizioneTorneoController.addListenersindex(model, view);
		CreaTorneoController.addListenersindex(model, view);
		PartecipaTorneoController.addListenersindex(model, view);
		MinesweeperController.addListenersindex(model, view);
		SnakeController.addListenersindex(model, view);
		LogoutController.addListenersindex(model, view);
		// BigFrameController.addListenersindex(model, view);
		TetrisController.addListenersindex(model, view);
		SpaceInvadersController.addListenersindex(model, view);
		SolitarioController.addListenersindex(model, view);

		for (GameButton b : view.getGameButtonList()) {
			MouseController.addMouseListenerGiochi(b, model, view);
		}

		inizializzaPreferiti();

		// Relativi ai bottoni nel menu dei preferiti
		OptionController.addListenersindex(model, view);
		PreferitiController.addListenersindex(model, view);

	}

	/*
	 * Al posto del metodo sotto si può fare nel main questo ciclo in modo da non
	 * dover usare l'informaizone che i bottoni sono GameButton for (int i=0;
	 * i<view.getMenuOptionList(); i++) { if
	 * (model.getPreferiti().contains(view.getMenuOptionList(i).getGioco) {
	 * //getGioco qui è un po'critico, forse view ha metodo che restituisce un gioco
	 * che chima agetGioco? view.getMenuPreferiti().add(view.getMenuOptionList(i); }
	 * }
	 * 
	 */
	// Chiama (dal DB) i preferiti, quindi inizializza il menu popup
	private void inizializzaPreferiti() {
		model.setPreferiti();
		for (GameButton g : view.getMenuOptionList()) {
			if (model.getPreferiti().contains(g.getGioco())) {
				view.getMenuPreferiti().add(g);
			}
		}
	}

	// Prende come ingresso il bottone princpiale del gioco (NON quello nel menu a
	// tendina) che è appena stato
	// messo preferito e cerca il bottone corrispondente fra quelli del menu a
	// tendina per poi aggiungerlo

}

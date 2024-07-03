package Index;

import Autenticazionecontroller.LogoutController;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.ModificaAccountController;
import GiochiPlaceholder.OptionController;
import GiochiPlaceholder.PreferitiController;
import GiochiPlaceholder.SolitarioController;
import GiochiPlaceholder.SpaceInvadersController;
import GiochiPlaceholder.TetrisController;
import Messaggi.MessaggiController;
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
		
		MessaggiController.addListenersindex(model, view);
		
//		for (GameButton b : view.getGameButtonList()) {
//			MouseController.addMouseListenerGiochi(b, null, model, view);
//		}
		
		
		model.setPreferiti();
		int i=0;
		for (GiochiEnum gioco : GiochiEnum.values()) {
			MouseController.addMouseListenerGiochi(view.getGameButtonList().get(i), view.getMenuOptionList().get(i), gioco, model, view);
			if (model.getPreferiti().contains(gioco)) {
				  view.getMenuPreferiti().add(view.getMenuOptionList().get(i)); 
			}
			i++;
		}
		
//		inizializzaPreferiti();

		// Relativi ai bottoni nel menu dei preferiti
		OptionController.addListenersindex(model, view);
		PreferitiController.addListenersindex(model, view);

	}


	// Chiama (dal DB) i preferiti, quindi inizializza il menu popup
//	private void inizializzaPreferiti() {
//		model.setPreferiti();
//		
////		for (GameButton g : view.getMenuOptionList()) {
////			if (model.getPreferiti().contains(g.getGioco())) {
////				view.getMenuPreferiti().add(g);
////			}
////		}
//		
//		for (int i=0; i<view.getMenuOptionList().size(); i++) { 
//			if (model.getPreferiti().contains(view.getMenuOptionList().get(i).getGioco())) {
//				  //getGioco qui è un po'critico, forse view ha metodo che restituisce un gioco
//				  view.getMenuPreferiti().add(view.getMenuOptionList().get(i)); }
//				  }
//		
//		
//	}

	// Prende come ingresso il bottone princpiale del gioco (NON quello nel menu a
	// tendina) che è appena stato
	// messo preferito e cerca il bottone corrispondente fra quelli del menu a
	// tendina per poi aggiungerlo

}

package Index;

import java.util.ArrayList;

import Autenticazionemodel.GestioneAccountModel;
import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;
import GestioneAccount.ModificaAccountController;
import GestioneAccount.ModificaAccountView;
import GiochiPlaceholder.*;
import Messaggi.MessaggiController;
import Messaggi.MessaggiView;
import Minesweeper.MinesweeperController.MinesweeperController;
import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MinesweeperView;
import SnakeController.SnakeController;
import SnakeModel.SnakeGame;
import SnakeView.SnakeView;
import TorneoController.CreaTorneoController;
import TorneoController.DisiscrizioneTorneoController;
import TorneoController.EliminaTorneoController;
import TorneoController.IscrizioneTorneoController;
import TorneoController.PartecipaTorneoController;
import TorneoModel.TorneoModel;
import TorneoView.CreaTorneoView;
import TorneoView.DisiscrizioneTorneoView;
import TorneoView.EliminaTorneoView;
import TorneoView.IscrizioneTorneoView;
import TorneoView.PartecipaTorneoView;
import Utente.UtenteAutenticato;

public class IndexModel {

	private TorneoModel model = new TorneoModel();

	// Relativi alla gestione account
	public void modificaAccount() {
		new ModificaAccountController(new GestioneAccountModel(), new ModificaAccountView());
	}

	public void eliminaAccount(IndexView lastView) {
		new EliminaAccountController(new GestioneAccountModel(), new EliminaAccountView(), lastView);
	}

	// Relativi ai tornei
	public void eliminatorneoController() {

		new EliminaTorneoController(new EliminaTorneoView(), model);

	}

	public void disiscrivitiTorneocontroller() {
		new DisiscrizioneTorneoController(new DisiscrizioneTorneoView(), model);
	}

	public void iscrivitiTorneocontroller() {

		new IscrizioneTorneoController(new IscrizioneTorneoView(), model);
	}

	public void creaTorneocontroller() {

		new CreaTorneoController(new CreaTorneoView(), model);
	}

	public void partecipaTorneocontroller() {

		new PartecipaTorneoController(new PartecipaTorneoView(), model);
	}

	// Relativi ai giochi
	public void minesweeperPlay() {

		new MinesweeperController(new MinesweeperModel(), new MinesweeperView());
	}

	public void snakePlay() {
		SnakeGame model = new SnakeGame();
		SnakeView view = new SnakeView();
		new SnakeController(model, view);
	}

	// Serie di metodi placeholder
	public void spaceInvadersPlay() {
		new SpaceInvadersPlaceholder();
	}

	public void tetrisPlay() {
		new TetrisPlaceholder();
	}

	public void solitarioPlay() {
		new SolitarioPlaceholder();
	}
	
	public void messaggiView() {
		new MessaggiView();
	}

	// Relativi alle preferenze
	// Mancano alcune cose erronamente messe nel controller
	public void insertPreferiti(GiochiEnum gioco) {
		UtenteAutenticato.getInstance().insertPreferiti(gioco);
	}

	public void deletePreferiti(GiochiEnum gioco) {
		UtenteAutenticato.getInstance().deletePreferiti(gioco);
	}

	
	public ArrayList<GiochiEnum> getPreferiti() {
		return UtenteAutenticato.getInstance().getPreferiti();
	}

	// A partire dai dati di UtenteAutenticato (che comunica con db chiedendo la
	// lista di preferti attraverso dao)
	// possiamo impostare nell'interfaccia grafica i preferiti
	// Lista di UtenteAut è diversa da quella di bottoni della view. Il set è
	// riferito a questi, non utente
	public void setPreferiti() {
		UtenteAutenticato.getInstance().selectPreferiti();
	}

	// Altro
	public void createBigFrame() {
		new BigFrameController(new BigFrameView(), new BigFrameModel());
	}

	public void clear() {
		UtenteAutenticato.getInstance().clear();
	}

}

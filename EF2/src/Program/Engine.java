package Program;

import java.util.ArrayList;

import Autenticazione.Autenticazionecontroller.RegistrazioneController;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.BigFrameController;
import Autenticazione.Autenticazioneview.BigFrameModel;
import Autenticazione.Autenticazioneview.BigFrameView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import Autenticazionemodel.GestioneAccountModel;
import GestioneAccount.ModificaAccountView;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;
import GestioneAccount.ModificaAccountController;
import Index.IndexController;
import Minesweeper.MinesweeperController.MinesweeperController;
import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MinesweeperView;
import SnakeModel.GameFrame;
import SnakeModel.GamePanel;
import SnakeModel.SnakeController;
import SnakeModel.SnakeGame;
import TorneoController.CreaTorneoController;
import TorneoController.IscrizioneTorneoController;
import TorneoView.CreaTorneoView;
import Utente.FactoryGestioneTorneo;
import Utente.FactoryGestioneUtente;

public class Engine {

	public static void main(String[] args) {

		
		FactoryGestioneTorneo.getInstance().creaTorneoDao();
		FactoryGestioneUtente.getInstance().creaUtentedao();
		FactoryGestioneUtente.getInstance().creaUtente();

		BigFrameModel model = new BigFrameModel();

		BigFrameView view = new BigFrameView();

		BigFrameController c = new BigFrameController(view, model);

		
		/*
		GameFrame frame =new GameFrame();
		SnakeGame model=new SnakeGame();
		
		
		SnakeController c=new SnakeController(frame,model);
		*/
		
	}

}

package Program;

import java.util.ArrayList;


import Autenticazionemodel.RegistrazioneModel;
import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import Autenticazioneview.RegistrazioneView;
import Autenticazionemodel.GestioneAccountModel;
import GestioneAccount.ModificaAccountView;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;
import GestioneAccount.ModificaAccountController;
import Index.IndexController;
import Index.IndexModel;
import Index.IndexView;
import Minesweeper.MinesweeperController.MinesweeperController;
import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MinesweeperView;
import SnakeController.SnakeController;
import SnakeModel.SnakeGame;
import SnakeView.GameFrame;
import SnakeView.GamePanel;
import SnakeView.SnakeView;
import TorneoController.CreaTorneoController;
import TorneoController.IscrizioneTorneoController;
import TorneoView.CreaTorneoView;
import Utente.FactoryGestioneTorneo;
import Utente.FactoryGestioneUtente;
import Utente.Password;

public class Engine {

	public static void main(String[] args) {


		FactoryGestioneTorneo.getInstance().creaTorneoDao();
		FactoryGestioneUtente.getInstance().creaUtentedao();
		FactoryGestioneUtente.getInstance().creaUtente();
		
		
		//new BigFrameController(new BigFrameView(), new BigFrameModel());

		new IndexController(new IndexModel(), new IndexView()); 
		//Password p = new Password("D".toCharArray());
		//System.out.println(p.getHashedPassword()+1);
		
	}

}

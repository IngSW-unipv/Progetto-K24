package Program;

import java.util.ArrayList;  


import Autenticazionemodel.RegistrazioneModel;
import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import Autenticazioneview.RegistrazioneView;
import DataBase.UtenteDao;
import Autenticazionemodel.GestioneAccountModel;
import GestioneAccount.ModificaAccountView;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;
import GestioneAccount.ModificaAccountController;
import Index.IndexController;
import Index.IndexModel;
import Index.IndexView;
import Messaggi.Messaggio;
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
import Utente.UtenteAutenticato;

public class Engine {

	public static void main(String[] args) {

		// Ha detto che solo utente ha senso averlo dicharato nel main, i DAO no, al massimo vanno dichiarati dentro UTente
		FactoryGestioneTorneo.getInstance().creaTorneoDao();
		FactoryGestioneUtente.getInstance().creaUtentedao();
		FactoryGestioneUtente.getInstance().creaUtente();
		
		
		new BigFrameController(new BigFrameView(), new BigFrameModel());
		
		UtenteAutenticato.getInstance().setEmail("luca@luca.luca");
		
		//new IndexController(new IndexModel(), new IndexView()); 
		Messaggio m = new Messaggio("passwordèD@icloud.com", "Hello world");
		UtenteDao.getInstance().insertMessaggio(UtenteAutenticato.getInstance(), m);
	}

}

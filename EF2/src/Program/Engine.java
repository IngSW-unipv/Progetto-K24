package Program;

import java.util.ArrayList;

import Autenticazione.Autenticazionecontroller.RegistrazioneController;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.BigFrameController;
import Autenticazione.Autenticazioneview.BigFrameView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import GestioneAccount.ModificaAccountView;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.ModificaAccount.ModificaAccountController;
import Index.IndexController;
import Minesweeper.MinesweeperController.MinesweeperController;
import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MinesweeperView;
import TorneoController.CreaTorneoController;
import TorneoController.IscrizioneTorneoController;
import TorneoView.CreaTorneoView;


public class Engine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//IscrizioneTorneoController c = new IscrizioneTorneoController();
		
		EliminaAccountController m = new EliminaAccountController();
		GestioneAccount.ModificaAccountController n = new GestioneAccount.ModificaAccountController();
		//CreaTorneoController c = new CreaTorneoController();
		
        //MinesweeperController ctrl = new MinesweeperController();
      
        //BigFrameController c=new BigFrameController();
		
	}

}

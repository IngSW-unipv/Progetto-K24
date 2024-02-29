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
		EliminaAccountView v = new EliminaAccountView();
		GestioneAccountModel m = new GestioneAccountModel();
		EliminaAccountController c = new EliminaAccountController(m, v);
		ModificaAccountView v1 = new ModificaAccountView();
		ModificaAccountController c1 = new ModificaAccountController(m, v1);
		//BigFrameModel model = new BigFrameModel();

		//BigFrameView view = new BigFrameView();

		//BigFrameController c = new BigFrameController(view, model);

	}

}

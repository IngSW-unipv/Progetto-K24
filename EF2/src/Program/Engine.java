package Program;

import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import DataBase.UtenteDao;
import Messaggi.Messaggio;
import Utente.FactoryGestioneUtente;
import Utente.UtenteAutenticato;

public class Engine {

	public static void main(String[] args) {

		FactoryGestioneUtente.getInstance().creaUtente();

		new BigFrameController(new BigFrameView(), new BigFrameModel());
	}

}

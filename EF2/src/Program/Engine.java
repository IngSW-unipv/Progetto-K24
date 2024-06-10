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

		// Ha detto che solo utente ha senso averlo dicharato nel main, i DAO no, al
		// massimo vanno dichiarati dentro UTente
		FactoryGestioneUtente.getInstance().creaUtente();

		new BigFrameController(new BigFrameView(), new BigFrameModel());

		UtenteAutenticato.getInstance().setEmail("luca@luca.luca");

		// new IndexController(new IndexModel(), new IndexView());
		Messaggio m = new Messaggio("passwordèD@icloud.com", "Hello world");
		UtenteDao.getInstance().insertMessaggio(UtenteAutenticato.getInstance(), m);
	}

}

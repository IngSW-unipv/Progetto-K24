package Autenticazione.Autenticazionemodel;

import java.io.IOException;

import DataBase.UtenteDao;
import Index.IndexController;
import Index.IndexModel;
import Index.IndexView;
import Utente.FactoryGestioneUtente;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

/*
 * Classe model per il login
 * essa contiene alcuni metodi che, insieme alla view e al controller, implementa il login seguendo il pattern MVC
 */
public class LoginModel {

	private UtenteAutenticato ut;

	public LoginModel() {
		// nothing

	}

	/// metodo per istanziare l'utente quando si autentica
	public void istanziaUtente(String userName, String email, String password) {
		// SingletonGestione.getInstance().setUtente(new UtenteAutenticato(userName,
		// email, password));
		UtenteAutenticato.getIstance().setEmail(email);
		UtenteAutenticato.getIstance().setPassword(password);

		// ut = SingletonGestione.getInstance().getUtente();
		
	}

	public void indexController() {

		new IndexController(new IndexModel(),new IndexView());

	}

	// verifica che le credenziali inserite siano corrette
	public boolean verificaCredenziali(String emailInput, String passwordInput) throws IOException {

		UtenteAutenticato.getIstance().setEmail(emailInput);
		UtenteAutenticato.getIstance().setPassword(passwordInput);

		
		return UtenteDao.getIstance().selectByEmailUser(UtenteAutenticato.getIstance());

		// SingletonGestione.getInstance().getUtentedao().selectByEmailUser(ut);
	}

	// getter and setters
	public UtenteAutenticato getUt() {
		return ut;
	}

	public void setUt(UtenteAutenticato ut) {
		this.ut = ut;
	}
}

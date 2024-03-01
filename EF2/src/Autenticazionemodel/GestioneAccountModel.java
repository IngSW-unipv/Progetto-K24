package Autenticazionemodel;

import java.io.IOException;

import DataBase.UtenteDao;
import Index.IndexController;
import Index.IndexModel;
import Index.IndexView;
import Utente.FactoryGestioneUtente;

import Utente.UtenteAutenticato;

/*
 * Classe model per il login e la gestione dell'account
 * essa contiene alcuni metodi che, insieme alla view e al controller, implementa il login seguendo il pattern MVC
 * e metodi per eseguire la modifica dei propri dati e l'eliminazione del proprio account
 */
public class GestioneAccountModel {

	public GestioneAccountModel() {
		// nothing

	}

	/// metodo per istanziare l'utente quando si autentica
	public void impostaUtente(String userName, String email, String password) {

		UtenteAutenticato.getInstance().setEmail(email);
		UtenteAutenticato.getInstance().setPassword(password.toCharArray());
		
	}

	public void indexController() {

		new IndexController(new IndexModel(),new IndexView());

	}

	// verifica che le credenziali inserite siano corrette
	public boolean verificaCredenziali(String emailInput, char[] passwordInput) throws IOException {

		UtenteAutenticato.getInstance().setEmail(emailInput);
		UtenteAutenticato.getInstance().setPassword(passwordInput);

		return UtenteDao.getInstance().selectByEmailUser(UtenteAutenticato.getInstance());

	}
	
	//modifica a partire dall'input utente il suo username
	public void modificaAccount(String newUsername) {	
		UtenteAutenticato.getInstance().setUsername(newUsername);
		UtenteDao.getInstance().updateSchemaUtente(UtenteAutenticato.getInstance());
	}
	
	//elimina l'account dell'utente dal database
	public void eliminaAccount() {
		UtenteDao.getInstance().eliminaSchemaUtente(UtenteAutenticato.getInstance());
 	}
	

}

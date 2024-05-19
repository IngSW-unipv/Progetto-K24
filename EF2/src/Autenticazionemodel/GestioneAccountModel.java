package Autenticazionemodel;

import java.io.IOException; 

import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import Autenticazionecontroller.RegistrazioneController;
import Autenticazionemodel.RegistrazioneModel;
import Autenticazioneview.RegistrazioneView;
import DataBase.UtenteDao;
import Index.IndexController;
import Index.IndexFacadeController;
import Index.IndexModel;
import Index.IndexView;


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

	public void istanziaIndex() {

	  //new IndexController(new IndexModel(),new IndexView());
       new IndexFacadeController(new IndexModel(),new IndexView());
	}
	
	public void istanziaBigFrame() {
		 new BigFrameController(new BigFrameView(), new BigFrameModel());
	}

	// verifica che le credenziali inserite siano corrette
	public boolean verificaCredenziali(String emailInput, char[] passwordInput) throws IOException {

		UtenteAutenticato.getInstance().setEmail(emailInput);   
		UtenteAutenticato.getInstance().setPassword(passwordInput); 

		return UtenteDao.getInstance().selectByEmailUser(UtenteAutenticato.getInstance());

	}
	
	//Ha senso avere wuesto metodo? Non è uguale ad aver il controller che chiama setUsernsme direttamente da UtAut?
	public void setUsername(String username) {
		UtenteAutenticato.getInstance().setUsername(username);
		}
	//modifica a partire dall'input utente il suo username (prima è chiamato il metodo di sopra)
	public void modificaAccount() {	
		UtenteAutenticato.getInstance().cambiaUsername();
	}
	
	//elimina l'account dell'utente dal database
	public void eliminaAccount() {
		
		UtenteAutenticato.getInstance().eliminaAccount();
		UtenteAutenticato.getInstance().clear();
 	}

	public void istanziaRegistration() {
		 new RegistrazioneController(new RegistrazioneModel(), new RegistrazioneView());		
	}


	

}

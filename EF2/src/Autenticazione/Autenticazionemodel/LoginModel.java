package Autenticazione.Autenticazionemodel;

import java.io.IOException;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class LoginModel {

	private UtenteAutenticato ut;

	// costruttore
	public LoginModel() {
//nothing

	}
	// fine costruttore

	public UtenteAutenticato istanziaUtente(String userName, String email, String password) {

		SingletonGestione.getInstance().setUtente(new UtenteAutenticato(userName, email, password));
		ut = SingletonGestione.getInstance().getUtente();

		return ut;

	}

	public boolean verificaCredenziali(String emailInput, String passwordInput) throws IOException {
		
		ut = istanziaUtente(emailInput,emailInput,passwordInput);
		System.out.println(emailInput);
		System.out.println(ut.getHashedPassword());
        System.out.println(passwordInput);
		System.out.println(SingletonGestione.getInstance().getUtentedao().selectByEmailUser(ut));
		return SingletonGestione.getInstance().getUtentedao().selectByEmailUser(ut);
	}

	public UtenteAutenticato getUt() {
		return ut;
	}

	public void setUt(UtenteAutenticato ut) {
		this.ut = ut;
	}

}

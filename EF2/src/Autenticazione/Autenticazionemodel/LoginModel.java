package Autenticazione.Autenticazionemodel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import DataBase.UtenteDao;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class LoginModel {

	
	private UtenteAutenticato ut;

	// costruttore
	public LoginModel() {
//nothing
		
	}
	// fine costruttore

	public UtenteAutenticato istanziautente(String userName, String email, String password) {

		SingletonGestione.getInstance().setUtente(new UtenteAutenticato(userName,email,password));
		ut = SingletonGestione.getInstance().getUtente();

		return ut;

	}

	public boolean verificaCredenziali(String usernameInput, String passwordInput) throws IOException {

		
		SingletonGestione.getInstance().setUtente(new UtenteAutenticato(usernameInput, usernameInput, passwordInput));
		
		ut =SingletonGestione.getInstance().getUtente();


		System.out.println(passwordInput);
		System.out.println(usernameInput);
	

	    return SingletonGestione.getInstance().getUtentedao().selectByEmailUser(ut);

		
	}

	public UtenteAutenticato getUt() {
		return ut;
	}

	public void setUt(UtenteAutenticato ut) {
		this.ut = ut;
	}

}

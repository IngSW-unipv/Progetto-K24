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

	private UtenteDao dao;
	private UtenteAutenticato ut;

	// costruttore
	public LoginModel() {
//nothing
		dao = new UtenteDao();
	}
	// fine costruttore

	public UtenteAutenticato istanziautente(String userName, String email, String password) {

		SingletonGestione.getInstance().setUtente(new UtenteAutenticato());
		ut = SingletonGestione.getInstance().getUtente();

		return ut;

	}

	public boolean verificaCredenziali(String usernameInput, String passwordInput) throws IOException {

		ut = new UtenteAutenticato(usernameInput, usernameInput, passwordInput);


		System.out.println(passwordInput);
		System.out.println(usernameInput);
		// System.out.println(ut.getPassword());
		// System.out.println(ut.getHashedPassword());
		// System.out.println(ut.checkPassword(passwordInput));

		if (dao.selectByEmailUser(ut)) {
			return true;

		} else

		{
			return false;
		}

	}

	public UtenteAutenticato getUt() {
		return ut;
	}

	public void setUt(UtenteAutenticato ut) {
		this.ut = ut;
	}

}

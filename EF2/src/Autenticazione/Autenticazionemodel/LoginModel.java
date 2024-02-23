package Autenticazionemodel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import DataBase.UtenteDao;
import Utente.UtenteAutenticato;

public class LoginModel {

	// private static final String FILE_PATH =
	// "C:\\Users\\azera\\Desktop\\file.txt";
	private UtenteDao dao;
	private UtenteAutenticato ut;

	// costruttore
	public LoginModel() {
//nothing
		dao = new UtenteDao();
	}
	// fine costruttore

	public UtenteAutenticato istanziautente( String userName, String email, String password ) {
		
		
		ut=UtenteAutenticato.getInstance(userName,email,password);
		
		return ut;
		
		
	}
	
	public boolean verificaCredenziali(String usernameInput, String passwordInput) throws IOException {
		// String file = "C:\\Users\\azera\\Desktop\\file.txt";

		ut.getInstance(usernameInput, usernameInput, passwordInput);

		// BufferedReader br = new BufferedReader(new FileReader(file));
		// ArrayList<Schemautente> st = null;
		// while ( st ==dao.selectByUsername(ut) ) {dao.count>0 ||
		// String[] parole = st.split(", ");
		// dao.selectByUsername(ut);

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

}

package Utente;

import DataBase.Password;

/**
 * La classe astratta utente si occupa di definire i dati dell'utente in
 * un'unica classe. Tali dati vengono estratti dalla registrazione di ciascun
 * utente Questa classe astratta è poi implementata dalle classi
 * UtenteAutenticato, Amministratore.
 */
public abstract class Utente {
	private String userName;
	private Password password;
	private String email;
	private int id;

	/**
	 * Costruttore della classe
	 * 
	 * @param userName Il nome utente
	 * @param password La password sotto forma di stringa
	 * @param email    La email asscoiata all'utente
	 */
	public Utente(int id, String userName, String password, String email) {
		this.userName = userName;
		this.password = new Password(password.toCharArray());
		this.email = email;
		this.id = id;
	}

	public Password getPassword() {
		return password;

	}

	public String getHashedPassword() {
		return password.getHashedPassword();

	}

	/**
	 * Per controllare se la password inserita dall'utente che vuole autenticarsi è
	 * corretta invochiamo il metodo checkPassword della classe Password
	 * 
	 * @param input La password inserita dall'utente che vuole accedere
	 * @return true se è andato a buon fine, false altrimenti
	 */
	public boolean checkPassword(String input) {
		return password.checkPassword(input.toCharArray());
	}

	public String getUsername() {
		return userName;

	}

	public String getEmail() {
		return email;

	}

	public int getId() {
		return id;
	}

}

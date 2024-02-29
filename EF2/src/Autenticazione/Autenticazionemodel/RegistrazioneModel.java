package Autenticazione.Autenticazionemodel;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataBase.UtenteDao;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

/*
 * Classe model per la registrazione
 * essa contiene alcuni metodi che, insieme alla view e al controller, implementa la registrazione seguendo il pattern MVC
 */
public class RegistrazioneModel {

	private static final int MINLENGTH = 7, MAXLENGTH = 15;
	private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");// almeno una maiuscola
	private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*"); // almeno una minuscola
	private static final Pattern SPECIALCHAR_PATTERN = Pattern.compile(".*[!=$%@#^&*()-+?<>].*");// almeno un carattere speciale
	private static final Pattern NUMBER_PATTERN = Pattern.compile(".*[1-9].*"); // almeno un numero
	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // pattern per la mail
	public static final int NOME_NON_VALIDO = 1;
	public static final int COGNOME_NON_VALIDO =2;
	static final int USERNAME_NON_VALIDO = 3;
	static final int EMAIL_NON_VALIDA = 4;
	static final int PASSWORD_NON_UGUALI = 5;
	static final int PASSWORD_NON_VALIDA = 6;
	static final int TUTTO_CORRETTO = 7;
	
	
	public RegistrazioneModel() {
		// nothing
	}

	
	// verifica se nome e cognome rispettano certi requisiti
	public boolean isNomeCognomeValido(String nome) {
		return ((nome != null) && (!nome.isEmpty()) && (nome.matches("[A-Za-z]+")));
	}

	//verifica che username rispetta requisiti di lunghezza
	public boolean isUsernameValido(String username) {
			return ((username != null) && (username.length() > MINLENGTH) && (username.length()<MAXLENGTH));
	}
	
	// verifica se la mail rispetta certi requisiti
	public boolean isEmailValida(String email) {
		Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
		return (emailMatcher.find());
	}

	// verifica se la password rispetta determinati requisiti
	public boolean isPasswordValida(char[] passwordChars) {
		final String password = new String(passwordChars);
		
		return ((password != null) && // password non deve essere nulla
				(password.length() > MINLENGTH) && // la password deve avere almeno 7 caratteri
				(password.length() < MAXLENGTH) && // la password deve avere un massimo di caratteri
				(UPPERCASE_PATTERN.matcher(password).find()) && // la password deve avere almeno una maiuscola
				(LOWERCASE_PATTERN.matcher(password).find()) && // la password deve avere almeno una minuscola
				(SPECIALCHAR_PATTERN.matcher(password).find()) && // la password deve avere almeno un carattere speciale
				(NUMBER_PATTERN.matcher(password).find())); // la password deve contenere almeno un numero
	}

	// verifica se le due password inserite sono uguali
	public boolean isPasswordUguali(char[] password1, char[] password2) {

		String pswd1 = new String(password1);
		String pswd2 = new String(password2);

		return pswd1.equals(pswd2);

	}

	// verifica se la mail è già presente nel database
	public boolean isEmailInesistente(String email) {
		return !(UtenteDao.getInstance().selectByEmail(email));
	}

	//registra le credenziali nel database
	public void registrazioneCredenziali(UtenteAutenticato u) throws SQLException {
		UtenteDao.getInstance().insertSchemaUtente(u);
	}

	// istanzia un nuovo utente di tipo UtenteAutenticato
	public void impostaUtente(String nome, String emailutente, String password) {
		//SingletonGestione.getInstance().setUtente(new UtenteAutenticato(nome, emailutente, password));
		
		//UtenteAutenticato utente = SingletonGestione.getInstance().getUtente();
		
		UtenteAutenticato.getInstance().setUsername(nome);
		UtenteAutenticato.getInstance().setEmail(emailutente);
		UtenteAutenticato.getInstance().setPassword(password);
		
	}
	
	//metodo che verifica se i dati inseriti sono corretti, esso restituisce un intero in funzione dell'errore presente
	public int validaDati(String nome, String cognome, String username, String email, char[] passwordChars1, char[] passwordChars2) {
        if (!isNomeCognomeValido(nome)) {
            return NOME_NON_VALIDO;
        } else if (!isNomeCognomeValido(cognome)) {
            return COGNOME_NON_VALIDO;
        } else if (!isUsernameValido(username)) {
            return USERNAME_NON_VALIDO;
        } else if (!isEmailValida(email)) {
            return EMAIL_NON_VALIDA;
        } else if (!isPasswordUguali(passwordChars1, passwordChars2)) {
            return PASSWORD_NON_UGUALI;
        } else if (!isPasswordValida(passwordChars1)) {
            return PASSWORD_NON_VALIDA;
        } else {
            return TUTTO_CORRETTO; // Nessun errore
        }
    }

	//getters and setters
	
	public static int getNomeNonValido() {
		return NOME_NON_VALIDO;
	}


	public static int getUsernameNonValido() {
		return USERNAME_NON_VALIDO;
	}


	public static int getCognomeNonValido() {
		return COGNOME_NON_VALIDO;
	}


	public static int getEmailNonValida() {
		return EMAIL_NON_VALIDA;
	}


	public static int getPasswordNonUguali() {
		return PASSWORD_NON_UGUALI;
	}


	public static int getPasswordNonValida() {
		return PASSWORD_NON_VALIDA;
	}


	public static int getTuttoCorretto() {
		return TUTTO_CORRETTO;
	}	
}
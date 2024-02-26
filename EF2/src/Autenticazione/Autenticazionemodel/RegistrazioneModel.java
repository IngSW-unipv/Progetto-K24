package Autenticazione.Autenticazionemodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class RegistrazioneModel {

	private static final int MINLENGTHPASS = 7, MAXLENGTHPASS = 15;
	private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");// almeno una maiuscola
	private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*"); // almeno una minuscol
	private static final Pattern SPECIALCHAR_PATTERN = Pattern.compile(".*[!=$%@#^&*()-+?<>].*");// contiene almeno un
																									// carattere
																									// speciale
	private static final Pattern NUMBER_PATTERN = Pattern.compile(".*[1-9].*");
	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	// costruttore
	public RegistrazioneModel() {

	}
	// fine costruttore

	// verifica se nome e cognome rispettano certi requisiti
	public boolean isNomeCognomeValido(String nome) {
		return ((nome != null) && (!nome.isEmpty()) && (nome.matches("[A-Za-z]+")));// ritorna true se il nome non è
																					// nullo e contiene solo lettere
																					// (non può contenere nemmeno spazi)
	}// nome!=null serve per evitare il nullPointerException

	// verifica se la mail rispetta certi requisiti
	public boolean isEmailValida(String email) {
		Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
		return (emailMatcher.find());
	}

	// verifica se la password rispetta determinati requisiti
	public boolean isPasswordValida(char[] passwordChars) {
		String password=new String(passwordChars);
		Matcher uppercaseMatcher = UPPERCASE_PATTERN.matcher(password);
		Matcher lowercaseMatcher = LOWERCASE_PATTERN.matcher(password);
		Matcher specialcharMatcher = SPECIALCHAR_PATTERN.matcher(password);
		Matcher numberMatcher = NUMBER_PATTERN.matcher(password);

		if ((password != null) && // password non deve essere nulla
				(password.length() > MINLENGTHPASS) && // la password deve avere almeno 7 caratteri
				(password.length() < MAXLENGTHPASS) && // la password deve avere un massimo di caratteri
				(uppercaseMatcher.find()) && // la password deve avere almeno una maiuscola
				(lowercaseMatcher.find()) && // la password deve avere almeno una minuscola
				(specialcharMatcher.find()) && // la password deve avere almeno un carattere speciale
				(numberMatcher.find()) // la password deve contenere almeno un numero
		) {
			return true;
		} else {
			return false;
		}
	}

	// verifica se le due password inserite sono uguali
	public boolean isPasswordUguali(char[] password1, char[] password2) {
		
		String password_0=new String(password1);
		String password_1=new String(password2);
		
		return password_0.equals(password_1);
		
	}

	public UtenteAutenticato istanziautente(String nome, String emailutente, char[] password) {

		String password_0=new String(password);
		
		SingletonGestione.getInstance().setUtente(new UtenteAutenticato(nome, emailutente, password_0));

		UtenteAutenticato utente = SingletonGestione.getInstance().getUtente();

		return utente;
	}

}
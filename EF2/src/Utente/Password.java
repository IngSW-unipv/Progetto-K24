package Utente;

import java.util.Arrays;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * La classe Password si occupa della creazione, hashing e verifica della
 * password
 */
public class Password {

	/**
	 * La password è espressa non come stringa ma come array di caratteri per motivi
	 * di sicurezza, poiché la stringa una volta dichiarata è immutabile, e quando
	 * si finisce di usare la password occorerebbe aspettare il garbage collector
	 * per liberarsi della password in memoria
	 */
	private char[] password;

	/** Usiamo una stringa per esprimere l'hash della password */
	private String hashedPassword;

	/**
	 * Costruttore della classe
	 * 
	 * @param password La password da memorizzare
	 */
	public Password(char[] password) {
		this.password = password;
		this.hashedPassword = hashPassword(password);
	}

	/**
	 * Usando la libreria java.security e in particolare la classe MessageDigest
	 * facciamo l'hashing della password con l'algoritmo SHA-256
	 * 
	 * @param password La password di cui viene fatto hash
	 * @return Una stringa contenente l'hash della password
	 */
	private String hashPassword(char[] password) {
		/*
		 * Dichiariamo la Stringa hashed che ci serve per memorizzare temporaneamente
		 * come stringa l'hash. La inizializzamo come stringa vuota altrimenti potremmo
		 * avere return di qualcosa di non inizializzato nel caso in cui venga lanciata
		 * l'eccezione.
		 */
		String hashed = "";
		try {

			// Utilizziamo l'algoritmo SHA-256 per l'hashing della password.
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			/*
			 * Dichiariamo localmente una stringa che sia composta dall'array di caratteri
			 * password, e convertiamola in byte con il metodo getByte() di String. Ora
			 * usiamo il metodo digest(byte[] input) di MessageDigest per ottenere l'hash
			 * della stringa inserita sotto forma di array di byte.
			 */
			byte[] hash = md.digest(new String(password).getBytes());
			// Convertiamo l'array di byte in una stringa.
			hashed = new String(hash);

		} catch (NoSuchAlgorithmException e) {
			// Gestisce l'eccezione nel caso in cui l'algoritmo di hash non sia disponibile.
			e.printStackTrace();
		}

		return hashed;
	}

	/**
	 * Verifica se la password fornita coincide con quella memorizzata.
	 * 
	 * @param input La password da verificare.
	 * @return true se la password coincide, false altrimenti.
	 */
	public boolean checkPassword(char[] input) {

		/*
		 * Facciamo hashing dell'array di char di input e la coonfrontiamo con la
		 * password hashed effettiva. Restituiamo il risultato del confronto.
		 */
		System.out.println("char" + input);
		System.out.println(hashedPassword);
		return hashPassword(input).equals(hashedPassword);
	}

	/**
	 * Cancella la password memorizzata nell'istanza corrente. Questo metodo è utile
	 * per eliminare la password dalla memoria quando non è più necessaria.Non
	 * sarebbe possibile se la password fosse String: dovremmo aspettare che garbage
	 * collector la cancelli.
	 */
	public void clearPassword() {
		// Riempie l'array di caratteri con '0' per cancellare la password dalla
		// memoria.
		Arrays.fill(password, '0');
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

}

/*
 * NOTA: il fatto di aver scelto di accettare come parametro del costruttore non
 * una stringa ma un array di caratteri fa sì che si debbano avere accorgimenti
 * più avanti: nell'interazione con l'interfaccia grafica, lutente inserirà la
 * propria password in un JTextField o JPasswordField, e usanod il metodo
 * getText() di questi oggetti i dati messi dall'utente sono sotto forma di
 * stringa e non array di char, sarà quindi necessario convertire la password
 * ottenuta (String) con il metodo di String toCharArray().
 */

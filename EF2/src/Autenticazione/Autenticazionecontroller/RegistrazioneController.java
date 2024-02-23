package Autenticazionecontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Autenticazionemodel.LoginModel;
import Autenticazionemodel.RegistrazioneModel;
import Autenticazioneview.LoginView;
import Autenticazioneview.RegistrazioneView;
import DataBase.UtenteDao;
import Utente.UtenteAutenticato;

public class RegistrazioneController implements ActionListener {

	private String username;
	private String nome;
	private String cognome;
	private String email;
	private char[] password;
	private RegistrazioneModel model;
	private RegistrazioneView view;
	private LoginModel loginModel;
	private LoginView loginView;
	private UtenteAutenticato utente;

	// costruttore
	public RegistrazioneController(RegistrazioneModel model, RegistrazioneView view) {
		this.model = model;
		this.view = view;
		view.getPasswordsCheckBox().addActionListener(this); // gestisce l'evento della checkbox
		view.getRegistratiButton().addActionListener(this);
		view.getAccediButton().addActionListener(this);

		model.istanciateuser(utente);
	}
	// fine costruttore

	@Override
	public void actionPerformed(ActionEvent e) {

		// gestisce il bottone AccediButton
		if (e.getSource() == view.getAccediButton()) {// se clicco sul bottone AccediButton
			loginModel = new LoginModel();
			loginView = new LoginView();
			view.dispose();
			new LoginController(loginModel, loginView);
		}
		// fine

		// gestisce l'evento della checkBox
		if (e.getSource() == view.getPasswordsCheckBox()) {
			if (view.isPasswordsCheckBoxSelected()) {
				view.setPasswordFieldsEchochar((char) 0);
			} else if (!(view.isPasswordsCheckBoxSelected())) {
				view.setPasswordFieldsEchochar('•');
			}
		}
		// fine gestione evento checkBox

		// evento che agisce dopo aver cliccato su bottone registrati
		if (e.getSource() == view.getRegistratiButton()) {
			char[] passwordChars1 = view.getPassword1Text().getPassword();
			String password1 = new String(passwordChars1);
			char[] passwordChars2 = view.getPassword2Text().getPassword();
			String password2 = new String(passwordChars2);

			if (model.isNomeCognomeValido(view.getNomeText().getText())) { // verifica che nome è valido
				if (model.isNomeCognomeValido(view.getCognomeText().getText())) { // verifica che il cognome sia valido
					if (model.isEmailValida(view.getEmailText().getText())) {// se la mail inserita è valida
						if (model.isPasswordUguali(password1, password2)) { // se le due password sono uguali allora
																			// verifica che la password rispetta certi
																			// requisiti
							if (model.isPasswordValida(password1)) {
								// utente =new UtenteAutenticato();
								try {
									utente.registrazionecredenziali(34, view.getNomeText().getText(),
											view.getPassword1Text().getText(), view.getEmailText().getText());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								// salvaDati();

								System.out.println("Inserimento Terminato nel database");
							} else {// Se la password non è valida
								view.getErroreLabel().setText(
										"<html>LA PASSWORD INSERITA NON E' VALIDA, DEVE CONTENTERE: <br>MAIUSCOLA, MINUSCOLA, CARATTERE SPECIALE E NUMERO<br> e deve avere tra gli 8 e i 15 caratteri</html>");
							}
						} else { // se le password sono diverse
							view.getErroreLabel().setText("LE PASSWORD INSERITE NON CORRISPONDONO");
						}
					} else {// se la mail inserita non è valida
						view.getErroreLabel().setText("LA MAIL INSERITA NON E' VALIDA");
					}
				} else {// se il cognome non è valido
					view.getErroreLabel().setText("IL COGNOME INSERITO NON E' VALIDO");
				}
			} else {// se il nome non è valido
				view.getErroreLabel().setText("IL NOME INSERITO NON E' VALIDO");
			}
		} // fine dell'if che riguarda il registratiButton
	}

	// salva i dati nel file
	public void salvaDati() {
		String file = "C:\\Users\\azera\\Desktop\\file.txt";

		nome = view.getNomeText().getText();
		cognome = view.getCognomeText().getText();
		email = view.getEmailText().getText();
		username = model.usernameString(view.getEmailText().getText()); // salva lo username
		password = view.getPassword1Text().getPassword();

		String passwordString = new String(password);

		String datiUtente = String.join(", ", nome, cognome, email, username, passwordString);
		try {
			// Crea un oggetto Path dal percorso del file
			Path path = Paths.get(file);
			// Scrivi il contenuto nel file
			Files.write(path, Arrays.asList(datiUtente), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			view.getErroreLabel().setForeground(Color.green);
			view.getErroreLabel().setText("Ti sei registrato con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

}

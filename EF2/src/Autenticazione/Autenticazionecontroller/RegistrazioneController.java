package Autenticazione.Autenticazionecontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import Utente.UtenteAutenticato;
/*
 * RegistrazioneController è la classe che completa, insieme a RegistrazioneModel e RegistrazioneView,
 * il caso d'uso del login,seguendo il pattern MVC
 */

public class RegistrazioneController {

	private String username;
	private String nome;
	private String cognome;
	private String email;
	private char[] password;
	private RegistrazioneModel model;
	private RegistrazioneView view;

	private UtenteAutenticato utente;

	public RegistrazioneController(RegistrazioneModel model, RegistrazioneView view) {
		this.model = model;
		this.view = view;
		addListeners();
	}

	// tutti i listeners
	private void addListeners() {
		view.getAccediButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				new LoginController();
			}
		});

		view.getPasswordsCheckBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.isPasswordsCheckBoxSelected()) {
					view.setPasswordFieldsEchochar((char) 0);
				} else {
					view.setPasswordFieldsEchochar('•');
				}
			}
		});

		view.getRegistratiButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Map<Integer, Supplier<String>> errorMessages = new HashMap<>();
		        errorMessages.put(RegistrazioneModel.getNomeNonValido(), () -> "Nome non valido.");
		        errorMessages.put(RegistrazioneModel.getCognomeNonValido(), () -> "Cognome non valido.");
		        errorMessages.put(RegistrazioneModel.getUsernameNonValido(), () -> "Username non valido.");
		        errorMessages.put(RegistrazioneModel.getEmailNonValida(), () -> "Email non valida.");
		        errorMessages.put(RegistrazioneModel.getPasswordNonUguali(), () -> "Password diverse");
		        errorMessages.put(RegistrazioneModel.getPasswordNonValida(), () -> "Password non valida.");
		        errorMessages.put(RegistrazioneModel.getTuttoCorretto(), () -> "Registrazione eseguita");
		        char[] passwordChars1 = view.getPassword1Text().getPassword();
		        char[] passwordChars2 = view.getPassword2Text().getPassword();
				String paswrd = new String(passwordChars1);

		        
		        int validationResult = model.validaDati(view.getNomeText().getText(),
		                view.getCognomeText().getText(),
		                view.getUsernameText().getText(),
		                view.getEmailText().getText(),
		                passwordChars1,
		                passwordChars2);
		        String errore = errorMessages.get(validationResult).get(); // Directly call get()

		        if (errore=="Registrazione eseguita") {
		        	if (model.isEmailInesistente(view.getEmailText().getText())) {
		        		try {

							utente = model.istanziautente(view.getUsernameText().getText(),
									view.getEmailText().getText(), paswrd);
							model.registrazioneCredenziali(utente);
							// utente.registrazioneCredenziali(utente, view.getNomeText().getText(),
							// view.getEmailText().getText(),
							// view.getPassword1Text().getPassword().toString());
						} catch (SQLException e1) {
							view.getErroreLabel().setText("Errore nella registrazione, riprova");
							e1.printStackTrace();
						}
						view.getErroreLabel().setForeground(Color.green);
						view.getErroreLabel().setText("REGISTRAZIONE CORRETTA");

					} else {
						view.getErroreLabel().setForeground(Color.red);
						view.getErroreLabel().setText("Email già esistente.");
					}
		        }
		        else {
		        	view.getErroreLabel().setForeground(Color.RED);
			        view.getErroreLabel().setText(errore);
		        }
			}
		});
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
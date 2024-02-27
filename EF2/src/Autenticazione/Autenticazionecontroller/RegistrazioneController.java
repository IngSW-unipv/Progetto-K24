package Autenticazione.Autenticazionecontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.LoginView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import Utente.UtenteAutenticato;

public class RegistrazioneController {

	private String username;
	private String nome;
	private String cognome;
	private String email;
	private char[] password;
	private RegistrazioneModel model;
	private RegistrazioneView view;

	private UtenteAutenticato utente;

	public RegistrazioneController() {
		this.model = new RegistrazioneModel();
		this.view = new RegistrazioneView();
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
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] passwordChars1 = view.getPassword1Text().getPassword();
				char[] passwordChars2 = view.getPassword2Text().getPassword();
				String paswrd = new String(passwordChars1);

				if (model.isNomeCognomeValido(view.getNomeText().getText())
						&& model.isNomeCognomeValido(view.getCognomeText().getText())
						&& model.isEmailValida(view.getEmailText().getText())
						&& model.isPasswordUguali(passwordChars1, passwordChars2)
						&& model.isPasswordValida(passwordChars1)
						 ) {

					if(model.isEmailEsistente(view.getEmailText().getText()))
					{
					view.getErroreLabel().setForeground(Color.green);
					view.getErroreLabel().setText("REGISTRAZIONE CORRETTA");

					// utente = model.istanziautente(view.getNomeText().getText(),
					// view.getEmailText().getText(),
					// view.getPassword1Text().getPassword());

					try {

						utente = model.istanziautente(view.getUsernameText().getText(), view.getEmailText().getText(),
								paswrd);

						System.out.println(paswrd);

						model.registrazioneCredenziali(utente);
						// utente.registrazioneCredenziali(utente, view.getNomeText().getText(),
						// view.getEmailText().getText(),
						// view.getPassword1Text().getPassword().toString());
					} catch (SQLException e1) {
						view.getErroreLabel().setText("Errore nella registrazione, riprova");
						e1.printStackTrace();
					}
					
				}
					else{
					view.getErroreLabel().setForeground(Color.red);
					view.getErroreLabel().setText("Email esistente.");
				}

				} else {
					view.getErroreLabel().setForeground(Color.red);
					view.getErroreLabel().setText("Errore nei dati inseriti.");
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
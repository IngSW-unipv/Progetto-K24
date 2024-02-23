package Autenticazionecontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import Autenticazionemodel.LoginModel;
import Autenticazionemodel.RegistrazioneModel;
import Autenticazioneview.LoginView;
import Autenticazioneview.RegistrazioneView;
import DataBase.UtenteDao;
import Utente.UtenteAutenticato;

public class LoginController implements ActionListener {

	private RegistrazioneModel registrazioneModel;
	private RegistrazioneView registrazioneView;
    private UtenteAutenticato utente;
	private LoginModel model;
	private LoginView view;

	public LoginController(LoginModel model, LoginView view) {
		this.model = model;
		this.view = view;

		view.getPasswordsCheckBox().addActionListener(this);
		view.getRegistratiButton().addActionListener(this);
		view.getLoginButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.getPasswordsCheckBox()) { // listener per la password checkBox

			if (view.isPasswordsCheckBoxSelected()) {
				view.setPasswordFieldsEchochar((char) 0);
			} else if (!(view.isPasswordsCheckBoxSelected())) {
				view.setPasswordFieldsEchochar('•');
			}
		}

		if (e.getSource() == view.getRegistratiButton()) {
			registrazioneModel = new RegistrazioneModel(); // li devo istanziare dentro l'if altrimenti se istanzio sia
															// registraiozne che login fuori dal'if mi apre tutto a
															// prescindere
			registrazioneView = new RegistrazioneView();
			view.dispose();
			new RegistrazioneController(registrazioneModel, registrazioneView);
		}

		if (e.getSource() == view.getLoginButton()) {
			char[] password = view.getPasswordText().getPassword();
			String passwordString = new String(password);
			try {
				if (model.verificaCredenziali(passwordString, view.getUsernameText().getText())) // view.getUsernameText().getText()
				{
					view.getErroreText().setForeground(Color.green);
					view.getErroreText().setText("ACCESSO CORRETTO");
                    utente =model.istanziautente( view.getUsernameText().getText(),
				    view.getEmailText().getText(),view.getPasswordText().getText());                 
				} else {
					view.getErroreText().setForeground(Color.red);
					view.getErroreText().setText("USERNAME O PASSWORD ERRATI");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public UtenteAutenticato getUtente() {
		return utente;
	}

	public void setUtente(UtenteAutenticato utente) {
		this.utente = utente;
	}

}

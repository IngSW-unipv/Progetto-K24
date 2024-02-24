package Autenticazione.Autenticazionecontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.LoginView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import DataBase.UtenteDao;
import Utente.UtenteAutenticato;
import Autenticazione.Autenticazionecontroller.RegistrazioneController;

public class LoginController  {

	private Autenticazione.Autenticazionemodel.RegistrazioneModel registrazioneModel;
	private RegistrazioneView registrazioneView;
    private UtenteAutenticato utente;
	private Autenticazione.Autenticazionemodel.LoginModel model;
	private Autenticazione.Autenticazioneview.LoginView view;

	public LoginController(Autenticazione.Autenticazionemodel.LoginModel model, Autenticazione.Autenticazioneview.LoginView view) {
		this.model = model;
		this.view = view;
        addListeners();
	}

	
    private void addListeners() {
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
                view.dispose();
                registrazioneModel = new RegistrazioneModel();
                registrazioneView = new RegistrazioneView();
                new RegistrazioneController(registrazioneModel, registrazioneView);
            }
        });

        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
    }

	public UtenteAutenticato getUtente() {
		return utente;
	}

	public void setUtente(UtenteAutenticato utente) {
		this.utente = utente;
	}

}

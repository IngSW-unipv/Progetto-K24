package Autenticazione.Autenticazionecontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.LoginView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import Index.IndexController;

/*
 * LoginController è la classe che completa, insieme a LoginModel e LoginView, il caso d'uso del login,
 * seguendo il pattern MVC
 */

public class LoginController  {

	private LoginModel model;
	private LoginView view;
	

	public LoginController(LoginModel model, LoginView view) {
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
                new RegistrazioneController(new RegistrazioneModel(), new RegistrazioneView());
            }
        });

        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	char[] password = view.getPasswordText().getPassword();
    			String passwordString = new String(password);
    			try {
    				if (model.verificaCredenziali( view.getUsernameText().getText(),passwordString))
    				{
    					view.getErroreText().setForeground(Color.green);
    					view.getErroreText().setText("ACCESSO CORRETTO"); 
    					model.istanziaUtente(view.getUsernameText().getText(),view.getUsernameText().getText(),view.getPasswordText().getPassword().toString());
                        model.indexController();
                        
                        
    				} else {
    					view.getErroreText().setForeground(Color.red);
    					view.getErroreText().setText("EMAIL O PASSWORD ERRATI");
    				}
    			} catch (IOException e1) {
    				view.getErroreText().setText("Errore, riprova a registrarti");
    				e1.printStackTrace();
    			}
    			
            }
        });
    }


	public Autenticazione.Autenticazionemodel.LoginModel getModel() {
		return model;
	}


	public void setModel(Autenticazione.Autenticazionemodel.LoginModel model) {
		this.model = model;
	}

}

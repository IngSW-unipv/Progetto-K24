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
import Index.IndexController;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;
import Autenticazione.Autenticazionecontroller.RegistrazioneController;

public class LoginController  {

	private LoginModel model;
	private LoginView view;

	public LoginController() {
		this.model = new LoginModel();
		this.view = new LoginView();
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
              
                new RegistrazioneController();
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
    					model.istanziautente(view.getUsernameText().getText(),view.getUsernameText().getText(),view.getPasswordText().getPassword().toString());
                        IndexController c=new IndexController();
                        
                        
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


	public Autenticazione.Autenticazionemodel.LoginModel getModel() {
		return model;
	}


	public void setModel(Autenticazione.Autenticazionemodel.LoginModel model) {
		this.model = model;
	}

}

package Autenticazionecontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import Autenticazionemodel.RegistrazioneModel;
import Autenticazioneview.LoginView;
import Autenticazioneview.RegistrazioneView;
import Autenticazionemodel.GestioneAccountModel;
import Index.IndexController;
import Utente.UtenteAutenticato;

/*
 * LoginController è la classe che completa, insieme a LoginModel e LoginView, il caso d'uso del login,
 * seguendo il pattern MVC
 */

public class LoginController  {

	private GestioneAccountModel model;
	private Autenticazioneview.LoginView view;
	

	public LoginController(GestioneAccountModel model, Autenticazioneview.LoginView view) {
		this.model = model;
		this.view = view;
        addListeners();
	}

	
    private void addListeners() {
        view.getPasswordsCheckBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.isPasswordsCheckBoxSelected()) {
                    view.setPasswordFieldsEchocharNull();
                } else {
                    view.setPasswordFieldsEchocharPoint();
                }
            }
        });

        view.getRegistratiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                model.istanziaRegistration();
            }
        });

        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	char[] password = view.getPasswordText().getPassword();
    			String passwordString = new String(password);
    			System.out.println(password);
    			System.out.println(UtenteAutenticato.getInstance().getHashedPassword());
    			try {
    				if (model.verificaCredenziali( view.getUsernameText().getText(),password))
    				{
    					System.out.println(password);
    					
    					System.out.println(UtenteAutenticato.getInstance().getHashedPassword());
    					System.out.println(model.verificaCredenziali( view.getUsernameText().getText(),password));
    					
    					view.displayText(0);
    					model.impostaUtente(view.getUsernameText().getText(),view.getUsernameText().getText(),view.getPasswordText().getPassword().toString());
                        model.istanziaIndex();
                        view.dispose();                        
                        
    				} else {
    					view.displayText(1);
    				}
    			} catch (IOException e1) {
    				view.displayText(2);
    				e1.printStackTrace();
    			}  
    			
            }
        });
    }


	

}

package GestioneAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Autenticazionemodel.GestioneAccountModel;
import GestioneAccount.ModificaAccountView;
import Utente.UtenteAutenticato;

public class ModificaAccountController {
	private GestioneAccountModel model;
	private ModificaAccountView view;
	
	public ModificaAccountController(GestioneAccountModel model, ModificaAccountView view) {
		this.model = model;
		this.view = view;
		addListeners();
	}
	
	private void addListeners() {
		view.getPasswordCheckBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                if (view.isPasswordCheckBoxSelected()) {
                    view.setPasswordFieldsEchocharNull();
                } else {
                    view.setPasswordFieldsEchocharPoint();
                } 
            }
        });
		
		view.getIndietroButton().addActionListener(new ActionListener() {
			@Override
			public  void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
		
	     view.getModificaButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	char[] password = view.getPasswordText().getPassword();
	            	String passwordString = new String(password);
	    			try {
	    				//Usiamo lo stesso metodo di verifica credenziali del login, però non è necessario qui inserire il nome utente
	    				if (model.verificaCredenziali(UtenteAutenticato.getInstance().getEmail(),password))
	    				{ 
	    					model.setUsername(view.getUsernameText().getText());
	    					model.modificaAccount();
	    					view.dispose();
	                        
	    				} else {
	    					view.displayErrore();
	    				}
	    			} catch (IOException e1) {
	    				view.getErroreText().setText("Errore");
	    				e1.printStackTrace();
	    			}
	    			
	            }
	        });
	}
}

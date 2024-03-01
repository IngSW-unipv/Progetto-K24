package GestioneAccount;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Autenticazione.Autenticazioneview.BigFrameController;
import Autenticazione.Autenticazioneview.BigFrameModel;
import Autenticazione.Autenticazioneview.BigFrameView;
import Autenticazionemodel.GestioneAccountModel;
import Utente.UtenteAutenticato;



public class EliminaAccountController {
	private GestioneAccountModel model;
	private EliminaAccountView view;

	public EliminaAccountController(GestioneAccountModel model, EliminaAccountView view) {
		this.model = model;
		this.view = view;
		addListeners();
	}

	private void addListeners() {
		view.getPasswordCheckBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.isPasswordCheckBoxSelected()) {
					view.setPasswordFieldsEchochar((char) 0);
				} else {
					view.setPasswordFieldsEchochar('•');
				}
			}
		});
		
		view.getIndietroButton().addActionListener(new ActionListener() {
			@Override
			public  void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
		
		
		view.getEliminaButton().addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				char[] password = view.getPasswordText().getPassword();
    			String passwordString = new String(password);
    			try {
    				if (model.verificaCredenziali(UtenteAutenticato.getInstance().getEmail(),password))
    				{
 
    					model.eliminaAccount();
    					view.dispose();
    					model.istanziaBigFrame();
                         
    				} else {
    					view.getErroreText().setForeground(Color.red); 
    					view.getErroreText().setText("Password errata");
    				}
    			} catch (IOException e1) {
    				view.getErroreText().setText("Errore");
    				e1.printStackTrace();
    			}

			}
		});
	}
}

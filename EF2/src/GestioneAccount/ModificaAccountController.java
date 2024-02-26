package GestioneAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GestioneAccount.ModificaAccountView;
import Utente.UtenteAutenticato;

public class ModificaAccountController {
	private ModificaAccountModel model;
	private ModificaAccountView view;
	
	public ModificaAccountController() {
		this.model = new ModificaAccountModel();
		this.view = new ModificaAccountView();
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
		
		view.getModificaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				//Chiama effettivamente il model per cambiare i dati
				model.modificaAccount(view.getUsernameText().getText());
				
			}
		});
	}
}

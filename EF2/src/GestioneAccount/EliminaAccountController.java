package GestioneAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Autenticazionemodel.GestioneAccountModel;



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

		view.getEliminaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				// Chiama effettivamente il model per cambiare i dati

				model.eliminaAccount();

			}
		});
	}
}

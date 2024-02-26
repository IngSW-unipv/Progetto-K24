package GestioneAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Utente.SingletonGestione;

public class EliminaAccountController {
	private EliminaAccountModel model;
	private EliminaAccountView view;

	public EliminaAccountController() {
		this.model = new EliminaAccountModel();
		this.view = new EliminaAccountView();
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

				model.eliminaUtente();

			}
		});
	}
}

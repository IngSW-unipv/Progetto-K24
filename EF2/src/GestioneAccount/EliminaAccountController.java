package GestioneAccount;

import java.awt.Color; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import Index.IndexView;
import Autenticazionemodel.GestioneAccountModel;
import Utente.UtenteAutenticato;



public class EliminaAccountController {
	private GestioneAccountModel model;
	private EliminaAccountView view;
	private IndexView lastView;

		//E' giusto passare questa indexview? o è meglio fare in modo che se si apre questanuova view
	// in automatico la index si chiude, e se si decide di non eliminare account viene riaperto?
	public EliminaAccountController(GestioneAccountModel model, EliminaAccountView view, IndexView lastView) {
		this.model = model;
		this.view = view;
		this.lastView = lastView;
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
    					lastView.dispose();
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

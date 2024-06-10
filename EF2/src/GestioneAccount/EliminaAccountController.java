package GestioneAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameView;
import Index.IndexModel;
import Index.IndexView;
import Autenticazioneview.BigFrameModel;
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

	public static void addListenersindex(IndexModel m,IndexView view) {
		
		
		ActionListener eliminaccount=new ActionListener() {@Override
			
		public void actionPerformed(ActionEvent e) {
			
			manageAction();
			
		}
		
		private void manageAction() {
			
			
			m.eliminaAccount(view);
			
			
		}
		
		};
		
		view.getEliminaButton().addActionListener(eliminaccount);
		
	};
	
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

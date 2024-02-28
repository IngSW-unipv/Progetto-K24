package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Autenticazione.Autenticazionecontroller.LoginController;
import Autenticazione.Autenticazionemodel.LoginModel;
import TorneoView.CreaTorneoView;
import TorneoView.DisiscrizioneTorneoView;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class DisiscrizioneTorneoController {

	private DisiscrizioneTorneoView view;
	private UtenteAutenticato utente;
	private LoginModel loginmodel;
	
	public DisiscrizioneTorneoController(DisiscrizioneTorneoView view){
		
		this.view = view;
		view.getDisiscrizioneTorneo().addActionListener(listenerdisiscrizione);
		//modelcontroller=new LoginController();
	}
	
	ActionListener listenerdisiscrizione = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getDisiscrizioneTorneo()) {
			
                utente =SingletonGestione.getInstance().getUtente();
				utente.disiscrizioneTorneo( utente.getEmail(),view.getNomeText().getText());

			}

		}
	};
	
}

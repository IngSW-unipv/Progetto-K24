package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Autenticazione.Autenticazionecontroller.LoginController;
import Autenticazione.Autenticazionemodel.LoginModel;
import TorneoView.IscrizioneTorneoView;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class IscrizioneTorneoController {

	private IscrizioneTorneoView view;
	private UtenteAutenticato utente;

	public IscrizioneTorneoController() {
		this.view = new IscrizioneTorneoView();
		view.getIscrivitiTorneo().addActionListener(listeneriscrizione);
	}

	ActionListener listeneriscrizione = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getIscrivitiTorneo()) {

				utente = SingletonGestione.getInstance().getUtente();
				utente.iscrizioneTorneo(utente.getEmail(), view.getNomeText().getText());

			}

		}
	};

}

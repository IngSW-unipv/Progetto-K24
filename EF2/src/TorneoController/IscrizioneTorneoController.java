package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Autenticazione.Autenticazionecontroller.LoginController;
import Autenticazione.Autenticazionemodel.LoginModel;
import TorneoView.IscrizioneTorneoView;
import Utente.UtenteAutenticato;

public class IscrizioneTorneoController {

	private IscrizioneTorneoView view;
    private UtenteAutenticato utente;
    private LoginController logincontroller;
    private LoginModel loginmodel;
	public IscrizioneTorneoController() {
		this.view = new IscrizioneTorneoView();
		view.getIscrivitiTorneo().addActionListener(listeneriscrizione);
        loginmodel=new LoginModel();
	}

	ActionListener listeneriscrizione = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getIscrivitiTorneo()) {
				// da togliere
				utente =loginmodel.istanziautente("Abramo",  "12345","Abramo@gmail.com");//logincontroller.getUtente();
				utente.iscrizioneTorneo(utente.getEmail(), view.getNomeText().getText());

			}

		}
	};

}

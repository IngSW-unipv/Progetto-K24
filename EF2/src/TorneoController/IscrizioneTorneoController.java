package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import TorneoView.IscrizioneTorneoView;
import Utente.UtenteAutenticato;

public class IscrizioneTorneoController {

	private IscrizioneTorneoView view;

	public IscrizioneTorneoController() {
		this.view = new IscrizioneTorneoView();
		view.getIscrivitiTorneo().addActionListener(listeneriscrizione);

	}

	ActionListener listeneriscrizione = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getIscrivitiTorneo()) {
				// da togliere
				UtenteAutenticato utente = new UtenteAutenticato(0, "", "", "");

				utente.iscrizionetorneo(utente.getEmail(), view.getName());

			}

		}
	};

}

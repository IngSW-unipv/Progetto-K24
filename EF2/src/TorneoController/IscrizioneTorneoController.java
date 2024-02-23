package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import TorneoView.IscrizioneTorneoView;
import Utente.UtenteAutenticato;

public class IscrizioneTorneoController  implements ActionListener{

	private IscrizioneTorneoView view;

	public IscrizioneTorneoController() {
		this.view = new IscrizioneTorneoView();
		view.getIscrivitiTorneo().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == view.getIscrivitiTorneo()) {
			
			UtenteAutenticato utente = new UtenteAutenticato(0, "", "", "");

			utente.iscrizionetorneo(utente.getEmail(),view.getName(), 0);

		}

	}

	
	
}

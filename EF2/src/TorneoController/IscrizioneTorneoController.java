package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Autenticazione.Autenticazionecontroller.LoginController;
import Torneo.TorneoModel;
import TorneoView.IscrizioneTorneoView;
import Utente.UtenteAutenticato;

public class IscrizioneTorneoController {

	private IscrizioneTorneoView view;
	private UtenteAutenticato utente;
	private TorneoModel model;
	public IscrizioneTorneoController(IscrizioneTorneoView view, TorneoModel model) {
		this.view = view;
		this.model=model;
		addListeners();
	}
	
	private void addListeners() {
		view.getIscrivitiTorneo().addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getIscrivitiTorneo()) {

				
				model.IscrizioneTorneo(UtenteAutenticato.getInstance().getEmail(), view.getNomeText().getText() );
				
			}

		}
	});
	}
}

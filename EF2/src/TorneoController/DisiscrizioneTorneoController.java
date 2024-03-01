package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import TorneoModel.TorneoModel;

import TorneoView.DisiscrizioneTorneoView;

import Utente.UtenteAutenticato;

public class DisiscrizioneTorneoController {

	private DisiscrizioneTorneoView view;
	
	private TorneoModel model;

	public DisiscrizioneTorneoController(DisiscrizioneTorneoView view, TorneoModel model) {

		this.view = view;
		this.model = model;
		addListeners();
		
	}

	private void addListeners() {
		view.getDisiscrizioneTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == view.getDisiscrizioneTorneo()) {

					
					model.disiscrizioneTorneo(UtenteAutenticato.getInstance().getEmail(), view.getNomeText().getText());

				}

			}
		});
	}
}

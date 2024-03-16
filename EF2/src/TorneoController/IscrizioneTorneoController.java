package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import TorneoModel.TorneoModel;
import TorneoView.IscrizioneTorneoView;
import Utente.UtenteAutenticato;

public class IscrizioneTorneoController {

	private IscrizioneTorneoView view;
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
			

			if (e.getSource() == view.getIscrivitiTorneo()) { 

				
				model.iscrizioneTorneo(model.getEmail(), view.getNomeText().getText() );
				
			}

		}
	});
	}
}

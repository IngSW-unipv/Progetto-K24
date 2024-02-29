package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import TorneoView.CreaTorneoView;
import TorneoView.EliminaTorneoView;
import Utente.UtenteAutenticato;

public class EliminaTorneoController {

	private EliminaTorneoView view;
	private UtenteAutenticato utente;
	

	public EliminaTorneoController(EliminaTorneoView view){
		
		
		this.view = view;
		addListeners();
	}
	
	private void addListeners() {
		view.getEliminaTorneo().addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getEliminaTorneo()) {
				
				
				UtenteAutenticato.getIstance().eliminaTorneo(view.getNomeText().getText(),utente.getUsername());

			}

		}
	});
	
	}
}

package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import TorneoView.CreaTorneoView;
import TorneoView.EliminaTorneoView;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class EliminaTorneoController {

	private EliminaTorneoView view;
	private UtenteAutenticato utente;
	

	public EliminaTorneoController(){
		
		
		this.view = new EliminaTorneoView();
		view.getEliminaTorneo().addActionListener(listenerelimina);
	}
	
	ActionListener listenerelimina = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getEliminaTorneo()) {
				
				utente=SingletonGestione.getInstance().getUtente();
				
				utente.eliminaTorneo(view.getName());

			}

		}
	};
	
	
}

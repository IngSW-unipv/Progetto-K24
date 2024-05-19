package GiochiPlaceholder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Index.IndexModel;
import Index.IndexView;

public class PreferitiController {

	
public static void addListenersindex(IndexModel m,IndexView view) {
		
		
		ActionListener preferiti=new ActionListener() {@Override
			
		public void actionPerformed(ActionEvent e) {
			
			manageAction();
			
		}
		
		private void manageAction() {
			
			
			m.setPreferiti();
			// Per ogni bottone di opzione, controlla se il gioco è nei preferiti
			// NOTA QUI SI PUO USARE getPreferiti e non getPreferitiFromDB SOLO SE TUTTE LE
			// OPERAZIONI DI MODIFICA DEI PREFERITI SUBITO DOPO AVER AGGIORNATO
			// IL DB CHIAMANO LA SELECT DELL'UTENTEAUTENTICATO PER AGGIORNARE ANCHE
			// L'ARRAYLIST LOCALE CONTENENTE I PREFERITI
//SPostato in InizializzaMenuPreferiti
			// Dopo aver scelto solo i bottoni dei giochi, fa apparire le opzioni
			view.getMenuPreferiti().show(view.getPreferitiButton(), 0, view.getPreferitiButton().getHeight());
			
		}
		
		};
		
		view.getPreferitiButton().addActionListener(preferiti);
		
	}

	
	
}

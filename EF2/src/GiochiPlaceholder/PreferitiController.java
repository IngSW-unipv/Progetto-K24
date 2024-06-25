package GiochiPlaceholder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Index.IndexModel;
import Index.IndexView;

public class PreferitiController {

	
public static void addListenersindex(IndexModel m,IndexView view) {
		
		view.getPreferitiButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				m.getPreferiti();
				
				// Dopo aver scelto solo i bottoni dei giochi, fa apparire le opzioni
				view.getMenuPreferiti().show(view.getPreferitiButton(), 0, view.getPreferitiButton().getHeight());
								
			}
		});
		
	}

	
	
}

package TorneoController;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import DataBase.TorneoDao;
import Index.IndexModel;
import Index.IndexView;
import TorneoModel.TorneoModel;
import TorneoView.CreaTorneoView;
import Utente.UtenteAutenticato;

public class CreaTorneoController {

	private CreaTorneoView view;

	private TorneoModel model;


	public CreaTorneoController(CreaTorneoView view, TorneoModel model) {
		this.view = view;
		this.model = model;
		addListeners(); 
	}
	 public static void addListenersindex(IndexModel m,IndexView view) {
			
			
			ActionListener creatorneo=new ActionListener() {@Override
				
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
				
			}
			
			private void manageAction() {
				
				
				m.creaTorneocontroller();
				
				
			}
			
			};
			
			view.getCreaTorneo().addActionListener(creatorneo);
			
		}
	private void addListeners() {
		view.getCreaTorneo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				model.creaTorneo(view.getNomeText().getText(), model.getEmail(), view.getComboText(),
						view.getDatainzioText().getText(), view.getDatafineText().getText());
				view.dispose();
			} 
		});
	}

}

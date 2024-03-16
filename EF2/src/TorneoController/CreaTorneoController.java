package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import Autenticazione.Autenticazionecontroller.LoginController;

import DataBase.TorneoDao;
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

	private void addListeners() {
		view.getCreaTorneo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				model.creaTorneo(view.getNomeText().getText(), model.getEmail(), view.getComboText(),
						view.getDatainzioText().getText(), view.getDatafineText().getText());

			} 
		});
	}

}

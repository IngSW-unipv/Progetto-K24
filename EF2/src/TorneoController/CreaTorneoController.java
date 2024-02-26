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
import Autenticazione.Autenticazionemodel.LoginModel;
import DataBase.TorneoDao;
import TorneoView.CreaTorneoView;
import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class CreaTorneoController {

	private CreaTorneoView view;
	private UtenteAutenticato utente;
    private boolean istrue;

	public void setIstrue(boolean istrue) {
		this.istrue = istrue;
	}

	public CreaTorneoController() {
		this.view = new CreaTorneoView();
		view.getCreaTorneo().addActionListener(listenercreazione);

	}

	ActionListener listenercreazione = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == view.getCreaTorneo()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

				Date date = null;
				try {
					date = dateFormat.parse(view.getDatafineText().getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Date date_ = null;
				try {
					date_ = dateFormat.parse(view.getDatainzioText().getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				SingletonGestione.getInstance();
				utente = SingletonGestione.getInstance().getUtente();

				System.out.println(utente.getEmail());
				System.out.println(utente.getUsername());
				System.out.println(utente.getHashedPassword());
                
				
				
				utente.creazioneTorneo(view.getNomeText().getText(), utente.getEmail(), view.getComboText(), date, date_);
                
				
			}

		}
	};

}

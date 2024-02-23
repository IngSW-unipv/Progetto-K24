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
import Utente.UtenteAutenticato;

public class CreaTorneoController {

	private CreaTorneoView view;
    private UtenteAutenticato utente;
	private LoginModel logincontroller;
	public CreaTorneoController() {
		this.view = new CreaTorneoView();
		view.getCreaTorneo().addActionListener(listenercreazione);
        logincontroller=new LoginModel();
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
				// LocalDate date_ = LocalDate.parse(view.getDatafineText().getText());
				// LocalDate date = LocalDate.parse(view.getDatainzioText().getText());
				
                utente=logincontroller.istanziautente("Abramo", "Abramo@gmail.com", "12345");
				utente.creazionetorneo(view.getNomeText().getText(), utente.getUsername(), "gioco1", date, date_,
						view.getVisibilitaText().getText());

			}

		}
	};

}

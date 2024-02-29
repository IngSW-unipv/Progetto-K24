package Autenticazione.Autenticazioneview;

import Autenticazione.Autenticazionecontroller.LoginController;
import Autenticazione.Autenticazionecontroller.RegistrazioneController;
import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;

public class BigFrameModel {

	public BigFrameModel() {

	}

	public void registrazioneController() {

		new RegistrazioneController(new RegistrazioneModel(), new RegistrazioneView());

	}

	public void loginController() {

		new LoginController(new LoginModel(), new LoginView());

	}

}

package Autenticazioneview;

import Autenticazione.Autenticazionecontroller.LoginController;
import Autenticazionecontroller.RegistrazioneController;
import Autenticazione.Autenticazioneview.*;
import Autenticazionemodel.RegistrazioneModel;
import Autenticazionemodel.GestioneAccountModel;

public class BigFrameModel {

	public BigFrameModel() {

	}

	public void registrazioneController() {

		new RegistrazioneController(new RegistrazioneModel(), new RegistrazioneView());

	}

	public void loginController() {

		new LoginController(new GestioneAccountModel(), new LoginView());

	}

}

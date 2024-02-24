package Autenticazione.Autenticazioneview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Autenticazione.Autenticazionecontroller.LoginController;
import Autenticazione.Autenticazionecontroller.RegistrazioneController;
import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazionecontroller.*;
import Autenticazione.Autenticazionemodel.*;

import java.awt.Window;



public class BigFrameController{

	private BigFrameView view;
	private RegistrazioneModel registrazioneModel;
	private RegistrazioneView registrazioneView;
	private LoginModel loginModel;
	private LoginView loginView;
	
	
	public BigFrameController () {
		this.view=new BigFrameView();
		addListeners();
	}
	
	public void addListeners() {
		
		view.getRegistrazioneButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	view.dispose();
				registrazioneModel = new RegistrazioneModel(); //li devo istanziare dentro l'if altrimenti se istanzio sia registraiozne che login fuori dal'if mi apre tutto a prescindere
		        registrazioneView = new RegistrazioneView();
				new RegistrazioneController(registrazioneModel, registrazioneView);
			}
		});
		
		view.getLoginButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        view.dispose();
		    	loginModel=new LoginModel();
		        loginView=new LoginView();
		        new LoginController(loginModel, loginView);
			}
		});
	}	
}


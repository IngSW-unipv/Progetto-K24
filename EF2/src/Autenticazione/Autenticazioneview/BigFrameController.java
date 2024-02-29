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
	private BigFrameModel model;
	private RegistrazioneModel registrazioneModel;
	private RegistrazioneView registrazioneView;
	private LoginModel loginModel;
	private LoginView loginView;
	
	
	public BigFrameController (BigFrameView view,BigFrameModel model ) {
		this.view=view;
		this.model=model;
		
		addListeners();
	}
	
	public void addListeners() {
		
		view.getRegistrazioneButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	view.dispose();
		    	model.registrazioneController();
				
			}
		});
		
		view.getLoginButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        view.dispose();
		       model.loginController();
			}
		});
	}	
}


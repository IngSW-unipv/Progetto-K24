package Autenticazioneview;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import Autenticazionemodel.GestioneAccountModel;

public class BigFrameController {

	private BigFrameView view;
	private BigFrameModel model;
	private Autenticazionemodel.RegistrazioneModel registrazioneModel;
	private RegistrazioneView registrazioneView;
	private GestioneAccountModel loginModel;
	private LoginView loginView;

	public BigFrameController(BigFrameView view, BigFrameModel model) {
		this.view = view;
		this.model = model;

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

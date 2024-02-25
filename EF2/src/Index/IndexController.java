package Index;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.LoginView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import TorneoController.CreaTorneoController;
import TorneoController.DisiscrizioneTorneoController;
import TorneoController.EliminaTorneoController;
import TorneoController.IscrizioneTorneoController;

public class IndexController {

	private IndexView view;
	private IndexModel model;
	
	
	private RegistrazioneModel registrazioneModel;
	private RegistrazioneView registrazioneView;
	private LoginModel loginModel;
	private LoginView loginView;
	
	public IndexController() {
		
		this.model=new IndexModel();
		this.view=new IndexView();
		addListeners();
	}
	
	public void addListeners() {
		
		
		//modifica account ed elimina account
	/*	view.getRegistrazioneButton().addActionListener(new ActionListener() {
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
		});*/
		
		view.getCreaTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new CreaTorneoController();
			}
		});
		
		view.getIscrivitiTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new IscrizioneTorneoController();
			}
		});
		
		
		view.getDisiscrivitiTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new DisiscrizioneTorneoController();
			}
		});
		
		view.getEliminaTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new EliminaTorneoController();
			}
		});
		
		
	}
	
	
	
}
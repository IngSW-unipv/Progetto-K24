package Index;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.LoginView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;
import GestioneAccount.GestioneAccountModel;
import GestioneAccount.ModificaAccountView;
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
	
	public IndexController(IndexModel model,IndexView view) {
		
		this.model=model;		
		this.view=view ;
		addListeners();
	}
	
	public void addListeners() {
		
		
		//modifica account ed elimina account
		view.getEliminaButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	EliminaAccountController m = new EliminaAccountController(new GestioneAccountModel(),new EliminaAccountView());
			}
		});
		
		view.getModificaButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	GestioneAccount.ModificaAccountController n = new GestioneAccount.ModificaAccountController(new GestioneAccountModel(),new ModificaAccountView());
			}
		});
		
		view.getCreaTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.Creatorneocontroller();
			}
		});
		
		view.getIscrivitiTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.Iscrivititorneocontroller();
			}
		});
		
		
		view.getDisiscrivitiTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.Disiscrivititorneocontroller();
			}
		});
		
		view.getEliminaTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.Eliminatorneocontroller();
			}
		});
		
		
	}
	
	
	
}

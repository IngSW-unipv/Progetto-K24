package Index;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.BigFrameController;
import Autenticazione.Autenticazioneview.BigFrameModel;
import Autenticazione.Autenticazioneview.BigFrameView;
import Autenticazione.Autenticazioneview.LoginView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import Autenticazionemodel.GestioneAccountModel;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;

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
	private GestioneAccountModel loginModel;
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
		    	model.creaTorneoontroller();
			}
		});
		
		view.getIscrivitiTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.iscrivitiTorneocontroller();
			}
		});
		
		
		view.getDisiscrivitiTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.disiscrivitiTorneocontroller();
			}
		});
		
		view.getEliminaTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.eliminatorneoController();
			}
		});
		
		view.getLogoutButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.clear();
				view.dispose();
				new BigFrameController(new BigFrameView(), new BigFrameModel());
			}
		});
		
		view.getMinesweeper().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.minesweeperPlay();
			}
		});
		
	}
	
	
	
}

package Index;


import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Autenticazionemodel.RegistrazioneModel;
import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import Autenticazioneview.LoginView;
import Autenticazioneview.RegistrazioneView;
import DataBase.UtenteDao;
import Autenticazionemodel.GestioneAccountModel;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;
import GestioneAccount.ModificaAccountView;
import Utente.UtenteAutenticato;


public class IndexController {

	private IndexView view;
	private IndexModel model;
	
	
	private Autenticazionemodel.RegistrazioneModel registrazioneModel;
	private Autenticazionemodel.RegistrazioneModel registrazioneView;
	private GestioneAccountModel loginModel;
	private Autenticazioneview.LoginView loginView;
	
	public IndexController(IndexModel model,IndexView view) {
		
		this.model=model;		
		this.view=view ;
		addListeners();
	}
	
	public void addListeners() {
		
		
		//modifica account ed elimina account, logout
		view.getEliminaButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.eliminaAccount(view);		    	
			}
		});
		
		view.getModificaButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.modificaAccount();
		    }
		});
		
		view.getLogoutButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				model.clear();
				view.dispose();
				model.createBigFrame();
			}
		});
		
		// Relativi ai tornei
		view.getCreaTorneo().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.creaTorneocontroller();
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
		
		
		view.getPartecipaTorneo().addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
			    	model.partecipaTorneocontroller();
				} 
		});
		
		// Relativi ai giochi
		view.getMinesweeperButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.minesweeperPlay();
			} 
		});
		
		view.getSnakeButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.snakePlay();
			} 
		});
		
		//Metodi per chiamare i frame placholder per i giochi non disponibili
		view.getTetrisButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.tetrisPlay();
			} 
		});
		view.getSpaceInvadersButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.spaceInvadersPlay();
			} 
		});
		view.getSolitarioButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.solitarioPlay();
			} 
		});
		
		
		
		for (GameButton b : view.getGameButtonList()) {
			addMouseListenerPreferiti(b);
		}
		
		
		view.getPreferitiButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Si deve aprire fienstra coi preferiti direi attraverso UtenteDAO e un arraylist con is preferiti dell'utente
				//Questo dopo va tolto e solo prova
				if (UtenteDao.getInstance().insertPreferiti(UtenteAutenticato.getInstance())) System.out.println("UAAAAA");
			}
		});
		
	}
	
	private void addMouseListenerPreferiti(GameButton button) {
		button.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (SwingUtilities.isRightMouseButton(e)) {
	            	// A seconda che il gioco sia già nei preferiti o no
	            	if (!button.isPreferito()) {
	            		
		                int scelta = JOptionPane.showConfirmDialog(
		                        null,
		                        "Vuoi aggiungere questo gioco ai preferiti?",
		                        "Conferma",
		                        JOptionPane.YES_NO_OPTION
		                );
		                if (scelta == JOptionPane.YES_OPTION) {
		                    // Esegui l'operazione desiderata
		                    System.out.println("Operazione eseguita!");
		                    button.aggiungiPreferito();
		                    //Tutto da fare dentro il model con tanto di chiamata del DAO
		                }
		                
	            	} else {
	            		int scelta = JOptionPane.showConfirmDialog(
		                        null,
		                        "Vuoi rimuovere questo gioco dai preferiti?",
		                        "Conferma",
		                        JOptionPane.YES_NO_OPTION
		                );
		                if (scelta == JOptionPane.YES_OPTION) {
		                    // Esegui l'operazione desiderata
		                    System.out.println("Operazione eseguita!");
		                    button.rimuoviPreferito();
	            	}
	            	

	            }
	        }
	        
	        } 
	    });
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				view.getInfoLabel().setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				view.getInfoLabel().setVisible(false);

			}
		});
		
		
	}
}
	


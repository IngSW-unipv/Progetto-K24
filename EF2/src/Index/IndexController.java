package Index;


import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
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
	private LoginView loginView;
	
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
		
//		for (GameButton b : view.getGameButtonList()) {
//			addMouseListenerGiochi(b);
//		}
		
//		inizializzaPreferiti();
				
		// Relativi ai bottoni nel menu dei preferiti
		view.getMinesweeperOption().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.minesweeperPlay();
			} 
		});
		
		view.getSnakeOption().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.snakePlay();
			} 
		});
		
		view.getTetrisOption().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.tetrisPlay();
			} 
		});
		view.getSpaceInvadersOption().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.spaceInvadersPlay();
			} 
		});
		view.getSolitarioOption().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	model.solitarioPlay();
			} 
		});
		
//		view.getPreferitiButton().addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				model.setPreferiti();
//				// Per ogni bottone di opzione, controlla se il gioco è nei preferiti
//				//NOTA QUI SI PUO USARE getPreferiti e non getPreferitiFromDB SOLO SE TUTTE LE OPERAZIONI DI MODIFICA DEI PREFERITI SUBITO DOPO AVER AGGIORNATO
//				// IL DB CHIAMANO LA SELECT DELL'UTENTEAUTENTICATO PER AGGIORNARE ANCHE L'ARRAYLIST LOCALE CONTENENTE I PREFERITI
////SPostato in InizializzaMenuPreferiti
//				// Dopo aver scelto solo i bottoni dei giochi, fa apparire le opzioni
//			    view.getMenuPreferiti().show(view.getPreferitiButton(), 0, view.getPreferitiButton().getHeight());
//			}
//		});
		
	}
	
	/* Al posto del metodo sotto si può fare nel main questo ciclo in modo da non dover usare l'informaizone che i bottoni sono GameButton
	 * for (int i=0; i<view.getMenuOptionList(); i++) {
	 * 		if (model.getPreferiti().contains(view.getMenuOptionList(i).getGioco) { //getGioco qui è un po'critico, forse view ha metodo che restituisce un gioco che chima agetGioco?
	 * 			view.getMenuPreferiti().add(view.getMenuOptionList(i);
	 * 		}
	 * }
	 * 
	 */
//	// Chiama (dal DB) i preferiti, quindi inizializza il menu popup
//	private void inizializzaPreferiti() {
//		model.setPreferiti();
//		for (GameButton g : view.getMenuOptionList()) {
//			if (model.getPreferiti().contains(g.getGioco())) {
//				view.getMenuPreferiti().add(g);
//			}
//		}
//	}
//	
//	// Prende come ingresso il bottone princpiale del gioco (NON quello nel menu a tendina) che è appena stato
//	// messo preferito e cerca il bottone corrispondente fra quelli del menu a tendina per poi aggiungerlo 
//	private void addOptionToMenu(GameButton button) {
//		for (GameButton g : view.getMenuOptionList()) {
//        	if (g.getGioco() == button.getGioco()) {
//        		view.getMenuPreferiti().add(g);		                    	}
//        }	
//	}
//	
//	private void removeOptionFromMenu(GameButton button) {
//		for (GameButton g : view.getMenuOptionList()) {
//        	if (g.getGioco() == button.getGioco()) {
//        		view.getMenuPreferiti().remove(g);
//        	}
//        }
//	}
	
//	private void addMouseListenerGiochi(GameButton button) {
//		button.addMouseListener(new MouseAdapter() {
//	        @Override
//	        public void mouseClicked(MouseEvent e) {
//	            if (SwingUtilities.isRightMouseButton(e)) {
//	            	// A seconda che il gioco sia già nei preferiti o no
//	            	if (!model.getPreferiti().contains(button.getGioco())) { 
//		                int scelta = JOptionPane.showConfirmDialog(
//		                        null,
//		                        "Vuoi aggiungere questo gioco ai preferiti?",
//		                        "Conferma",
//		                        JOptionPane.YES_NO_OPTION
//		                );
//		                if (scelta == JOptionPane.YES_OPTION) {
//		                    System.out.println("Operazione eseguita!");
//		                    //button.aggiungiPreferito();
//		                    // Aggiunta al db
//		                    model.insertPreferiti(button.getGioco());
//		                    // Aggiornamento lista preferiti utente
//		                    model.setPreferiti();
//		                    // AGgiunta al menu preferiti
//		                    addOptionToMenu(button);
//		                   
//		                }
//		                
//	            	} else {
//	            		int scelta = JOptionPane.showConfirmDialog(
//		                        null,
//		                        "Vuoi rimuovere questo gioco dai preferiti?",
//		                        "Conferma",
//		                        JOptionPane.YES_NO_OPTION
//		                );
//		                if (scelta == JOptionPane.YES_OPTION) {
//		                    System.out.println("Operazione eseguita!");
//		                    //button.rimuoviPreferito();
//		                    // Rimozione dal db
//		                    model.deletePreferiti(button.getGioco());
//		                    // Aggiornamento lista preferiti utente
//		                    model.setPreferiti();
//		                    // Rimozione dal menù preferiti
//		                    removeOptionFromMenu(button);
//	            	}
//	            	
//
//	            }
//	        }
//	        
//	        } 
//	    });
//		
//		button.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				view.getInfoLabel().setVisible(true);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				view.getInfoLabel().setVisible(false);
//
//			}
//		});
//		
//		
//	}
	}

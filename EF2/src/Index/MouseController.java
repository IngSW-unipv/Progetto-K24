package Index;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MouseController {

	private static void addOptionToMenu(GameButton button, IndexView view) {
		for (GameButton g : view.getMenuOptionList()) {
			if (g.getGioco() == button.getGioco()) {
				view.getMenuPreferiti().add(g);
			}
		}
	}

	private static void removeOptionFromMenu(GameButton button, IndexView view) {
		for (GameButton g : view.getMenuOptionList()) {
			if (g.getGioco() == button.getGioco()) {
				view.getMenuPreferiti().remove(g);
			}
		}
	}

	public static void addMouseListenerGiochi(GameButton button, IndexModel model, IndexView view) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					// A seconda che il gioco sia già nei preferiti o no
					if (!model.getPreferiti().contains(button.getGioco())) { // Oppure è meglio usare metodo del bottone
																				// isPreferito

						int scelta = JOptionPane.showConfirmDialog(null, "Vuoi aggiungere questo gioco ai preferiti?",
								"Conferma", JOptionPane.YES_NO_OPTION);
						if (scelta == JOptionPane.YES_OPTION) {
							System.out.println("Operazione eseguita!");
							// button.aggiungiPreferito();
							// Aggiunta al db
							model.insertPreferiti(button.getGioco());
							// Aggiornamento lista preferiti utente
							model.setPreferiti();
							// AGgiunta al menu preferiti
							addOptionToMenu(button, view);

						}

					} else {
						int scelta = JOptionPane.showConfirmDialog(null, "Vuoi rimuovere questo gioco dai preferiti?",
								"Conferma", JOptionPane.YES_NO_OPTION);
						if (scelta == JOptionPane.YES_OPTION) {
							System.out.println("Operazione eseguita!");
							// button.rimuoviPreferito();
							// Rimozione dal db
							model.deletePreferiti(button.getGioco());
							// Aggiornamento lista preferiti utente
							model.setPreferiti();
							// Rimozione dal menù preferiti
							removeOptionFromMenu(button, view);
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

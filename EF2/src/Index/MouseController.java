package Index;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MouseController {

//	private static void addOptionToMenu(GiochiEnum gioco, IndexView view) {
//		for (GameButton g : view.getMenuOptionList()) {
//			if (g.getGioco() == gioco) {
//				view.getMenuPreferiti().add(g);
//			}
//		}
//	}
//
//	private static void removeOptionFromMenu(GiochiEnum gioco, IndexView view) {
//		for (GameButton g : view.getMenuOptionList()) {
//			if (g.getGioco() == gioco) {
//				view.getMenuPreferiti().remove(g);
//			}
//		}
//	}

	public static void addMouseListenerGiochi(GameButton button, GameButton option, GiochiEnum gioco, IndexModel model, IndexView view) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					// A seconda che il gioco sia già nei preferiti o no
					if (!model.getPreferiti().contains(gioco)) { 

						if (view.confermaSceltaPreferiti(0)) {
							// Aggiunta al db e aggiornamento dei preferiti di UtAut
							model.insertPreferiti(gioco);
							// AGgiunta al menu preferiti
							/////////addOptionToMenu(gioco, view);
							view.getMenuPreferiti().add(option);
							System.out.println("Operazione eseguita!");
						}

					} else {
						
						if (view.confermaSceltaPreferiti(1)) {
							// Rimozione dal db e rimozione dai preferiti di UtAUt
							model.deletePreferiti(gioco);
							// Rimozione dal menù preferiti
							/////////////////removeOptionFromMenu(gioco, view);
							view.getMenuPreferiti().remove(option);
							System.out.println("Operazione eseguita!");
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

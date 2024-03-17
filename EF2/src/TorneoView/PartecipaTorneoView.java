package TorneoView;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PartecipaTorneoView extends JFrame {

	private JPanel panel = new JPanel();
	private JLabel GiocoLabel = new JLabel("GIOCA:");
	private JLabel ClassificaLabel = new JLabel("Classifica:");
	private JButton PartecipaTorneo = new JButton("Gioca Torneo");
	private JButton ClassificaTorneo = new JButton("Classifica Torneo");
	private JLabel erroreLabel = new JLabel();

	// inizio costruttore
	public PartecipaTorneoView() {
		panel.setLayout(null);
		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		// Creazione e aggiunta della JComboBox al pannello

		GiocoLabel.setBounds(200, 120, 150, 25);
		ClassificaLabel.setBounds(200, 150, 150, 25);
		PartecipaTorneo.setBounds(370, 120, 150, 25);
		ClassificaTorneo.setBounds(370, 150, 150, 25);
		erroreLabel.setBounds(200, 240, 500, 50);
		erroreLabel.setForeground(Color.RED);

		// aggiungo i label al pannello
		panel.add(PartecipaTorneo);
		panel.add(ClassificaTorneo);
		panel.add(ClassificaLabel);
		panel.add(GiocoLabel);

		panel.add(erroreLabel);

		// rendo il frame e il label visibili
		setVisible(true);
	}

}

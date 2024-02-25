package TorneoView;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisiscrizioneTorneoView extends JFrame{

	private JPanel panel = new JPanel();

	public void setNomeText(JTextField nomeText) {
		this.nomeText = nomeText;
	}
	
	private JLabel nomeLabel = new JLabel("NOME TORNEO: ");
	
	private JTextField nomeText = new JTextField();
	
	private JButton  DisiscrizioneTorneo = new JButton(" Disiscrizione Torneo");

	// inizio costruttore
	public DisiscrizioneTorneoView() {
		panel.setLayout(null);
		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		// setto le dimensioni e le posizioni dei label
		nomeLabel.setBounds(200, 30, 100, 25);
		nomeText.setBounds(300, 30, 100, 25);

		DisiscrizioneTorneo.setBounds(200, 290, 150, 25);

		
		// aggiungo i label al pannello
		panel.add(nomeLabel);
		
		panel.add(nomeText);
		
		panel.add(DisiscrizioneTorneo);

		// rendo il frame e il label visibili
		setVisible(true);
	}
	// fine costruttore

	// getters e setters vari

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	
	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	
	public JButton getDisiscrizioneTorneo() {
		return DisiscrizioneTorneo;
	}

	public void setDisiscrizioneTorneo(JButton creaTorneo) {
		DisiscrizioneTorneo = creaTorneo;
	}

	public JTextField getNomeText() {
		return nomeText;
	}
	
}

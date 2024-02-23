package TorneoView;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EliminaTorneoView extends JFrame{
	private JPanel panel = new JPanel();

	public void setNomeText(JTextField nomeText) {
		this.nomeText = nomeText;
	}

	public void setVisibilitaText(JTextField visibilitaText) {
		this.visibilitaText = visibilitaText;
	}

	private JLabel datainizioLabel = new JLabel("DATA INIZIO: ");
	private JLabel datafineLabel = new JLabel("DATA FINE: ");
	private JLabel nomeLabel = new JLabel("NOME TORNEO: ");
	
	private JTextField nomeText = new JTextField();
	private JTextField visibilitaText = new JTextField();
	
	
	private JTextField datainzioText = new JTextField();
	private JTextField datafineText = new JTextField();
	private JButton EliminaTorneo = new JButton("Elimina Torneo ");

	

	// inizio costruttore
	public EliminaTorneoView() {
		panel.setLayout(null);
		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		// setto le dimensioni e le posizioni dei label
		nomeLabel.setBounds(200, 30, 100, 25);
		nomeText.setBounds(300, 30, 100, 25);
		
		datainizioLabel.setBounds(200, 165, 100, 25);
		datainzioText.setBounds(300, 165, 100, 25);

		datafineLabel.setBounds(200, 210, 100, 25);
		datafineText.setBounds(300, 210, 100, 25);

		EliminaTorneo.setBounds(200, 290, 150, 25);

		
		// aggiungo i label al pannello
		panel.add(nomeLabel);
		panel.add(datainizioLabel);
		panel.add(datafineLabel);
		panel.add(nomeText);
		panel.add(visibilitaText);
		panel.add(datainzioText);
		panel.add(datafineText);
		panel.add(EliminaTorneo);

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

	public JLabel getDatainizioLabel() {
		return datainizioLabel;
	}

	public void setDatainizioLabel(JLabel datainizioLabel) {
		this.datainizioLabel = datainizioLabel;
	}

	public JLabel getDatafineLabel() {
		return datafineLabel;
	}

	public void setDatafineLabel(JLabel datafineLabel) {
		this.datafineLabel = datafineLabel;
	}

	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	
	
	public JTextField getDatainzioText() {
		return datainzioText;
	}

	public void setDatainzioText(JTextField datainzioText) {
		this.datainzioText = datainzioText;
	}

	public JTextField getDatafineText() {
		return datafineText;
	}

	public void setDatafineText(JTextField datafineText) {
		this.datafineText = datafineText;
	}

	public JButton getEliminaTorneo() {
		return EliminaTorneo;
	}

	public void setEliminaTorneo(JButton creaTorneo) {
		EliminaTorneo = creaTorneo;
	}

	public JTextField getVisibilitaText() {
		return visibilitaText;
	}

	public JTextField getNomeText() {
		return nomeText;
	}

	public JTextField getCognomeText() {
		return visibilitaText;
	}	
	
}

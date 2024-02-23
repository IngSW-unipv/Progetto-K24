package TorneoView;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreaTorneoView extends JFrame {

	// aggiungo i label
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
	private JLabel visibilitaLabel = new JLabel("VISIBILITA: ");
	private JTextField nomeText = new JTextField();
	private JTextField visibilitaText = new JTextField();
	private JLabel GiocoLabel = new JLabel("GIOCO: ");
	private JTextField GiocoText = new JTextField();
	private JTextField datainzioText = new JTextField();
	private JTextField datafineText = new JTextField();
	private JButton CreaTorneo = new JButton("Crea Torneo");

	private JLabel erroreLabel = new JLabel();

	// inizio costruttore
	public CreaTorneoView() {
		panel.setLayout(null);
		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		// Creazione e aggiunta della JComboBox al pannello
		String[] options = { "Minesweeper 1", "Snake 2" };
		JComboBox<String> comboBox = new JComboBox<>(options);
		comboBox.setBounds(300, 120, 100, 25);
		var name = comboBox.toString();
		panel.add(comboBox);

		// setto le dimensioni e le posizioni dei label
		nomeLabel.setBounds(200, 30, 100, 25);
		nomeText.setBounds(300, 30, 100, 25);

		visibilitaLabel.setBounds(200, 75, 100, 25);
		visibilitaText.setBounds(300, 75, 100, 25);

		GiocoLabel.setBounds(200, 120, 100, 25);
		// GiocoText.setBounds(300, 120, 100, 25);

		datainizioLabel.setBounds(200, 165, 100, 25);
		datainzioText.setBounds(300, 165, 100, 25);

		datafineLabel.setBounds(200, 210, 100, 25);
		datafineText.setBounds(300, 210, 100, 25);

		CreaTorneo.setBounds(200, 290, 150, 25);

		erroreLabel.setBounds(200, 240, 500, 50);
		erroreLabel.setForeground(Color.RED);

		// aggiungo i label al pannello
		panel.add(nomeLabel);
		panel.add(visibilitaLabel);
		panel.add(GiocoLabel);
		panel.add(datainizioLabel);
		panel.add(datafineLabel);
		panel.add(nomeText);
		panel.add(visibilitaText);
		panel.add(GiocoText);
		panel.add(datainzioText);
		panel.add(datafineText);
		panel.add(CreaTorneo);

		panel.add(erroreLabel);

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

	public JLabel getVisibilitaLabel() {
		return visibilitaLabel;
	}

	public void setVisibilitaLabel(JLabel visibilitaLabel) {
		this.visibilitaLabel = visibilitaLabel;
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

	public JButton getCreaTorneo() {
		return CreaTorneo;
	}

	public void setCreaTorneo(JButton creaTorneo) {
		CreaTorneo = creaTorneo;
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

	public void setErroreLabel(JLabel erroreLabel) {
		this.erroreLabel = erroreLabel;
	}

	public JLabel getErroreLabel() {
		return erroreLabel;
	}

	public String getComboText() {

		return getName();

	}

	// fine getters e setters vari

}
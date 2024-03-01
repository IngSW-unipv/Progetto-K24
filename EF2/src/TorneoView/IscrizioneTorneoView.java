package TorneoView;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataBase.TorneoDao;

public class IscrizioneTorneoView extends JFrame {

	private JPanel panel = new JPanel();

	public void setNomeText(JTextField nomeText) {
		this.nomeText = nomeText;
	}

	private JLabel nomeLabel = new JLabel("NOME TORNEO: ");
	private JLabel listaLabel = new JLabel("LISTA TORNEI: ");
	private JTextField nomeText = new JTextField();

	private JButton IscrivitiTorneo = new JButton("Iscrizione Torneo");
	private String[] options = {};
	private ArrayList<String> lista = new ArrayList<String>();
	private JComboBox<String> comboBox;

	// inizio costruttore
	public IscrizioneTorneoView() {
		panel.setLayout(null);
		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		// setto le dimensioni e le posizioni dei label

		lista = TorneoDao.getInstance().selezionalistatorneo();

		options = lista.toArray(options);

		comboBox = new JComboBox<>(options);

		comboBox.setBounds(300, 20, 100, 25);
		listaLabel.setBounds(200, 20, 100, 25);

		nomeLabel.setBounds(200, 50, 100, 25);
		nomeText.setBounds(300, 50, 100, 25);

		IscrivitiTorneo.setBounds(200, 170, 150, 25);

		// aggiungo i label al pannello
		panel.add(nomeLabel);
		panel.add(listaLabel);

		panel.add(nomeText);

		panel.add(IscrivitiTorneo);
		panel.add(comboBox);

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

	public JButton getIscrivitiTorneo() {
		return IscrivitiTorneo;
	}

	public void setIscrivitiTorneo(JButton creaTorneo) {
		IscrivitiTorneo = creaTorneo;
	}

	public JTextField getNomeText() {
		return nomeText;
	}

}

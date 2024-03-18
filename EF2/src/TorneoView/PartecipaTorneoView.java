package TorneoView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DataBase.TorneoDao;

public class PartecipaTorneoView extends JFrame {

	private JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel panel_ = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JLabel GiocoLabel = new JLabel("Gioca:");
	private JLabel ClassificaLabel = new JLabel("Classifica:");
	private JButton PartecipaTorneo = new JButton("Gioca Torneo");
	private String[] options = {};
	private JComboBox<String> Torneo ;
	private JLabel TorneiLabel = new JLabel("Tornei disponibili:");
	private JTable table = new JTable(2, 2);
	private JButton ClassificaTorneo = new JButton("Classifica Torneo");
	private JLabel erroreLabel = new JLabel();
	private JPanel panelLayout = new JPanel(new BorderLayout());
	private static final int BUTTON_SPACING = 15;

	// inizio costruttore
	public PartecipaTorneoView() {
		// panel.setLayout(null);
		// panel_.setLayout(null);
		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);

		add(panelLayout);
		panel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 10));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		// Creazione e aggiunta della JComboBox al pannello
		
		Torneo=new JComboBox<>(options);
		
		GiocoLabel.setBounds(200, 120, 150, 25);
		ClassificaLabel.setBounds(200, 150, 150, 25);
		PartecipaTorneo.setBounds(370, 120, 150, 25);
		ClassificaTorneo.setBounds(370, 150, 150, 25);
		Torneo.setBounds(200, 90, 150, 25);
		TorneiLabel.setBounds(370, 90, 200, 25);
		erroreLabel.setBounds(200, 240, 500, 50);
		erroreLabel.setForeground(Color.RED);
        
		Torneo.setAlignmentX(CENTER_ALIGNMENT);
		//Torneo.setAlignmentY(TOP_ALIGNMENT);
		TorneiLabel.setAlignmentX(CENTER_ALIGNMENT);
		//TorneiLabel.setAlignmentY(TOP_ALIGNMENT);
		//PartecipaTorneo.setAlignmentY(CENTER_ALIGNMENT);
		PartecipaTorneo.setAlignmentX(CENTER_ALIGNMENT);
		//ClassificaTorneo.setAlignmentY(BOTTOM_ALIGNMENT);
		//ClassificaLabel.setAlignmentY(BOTTOM_ALIGNMENT);
		ClassificaTorneo.setAlignmentX(CENTER_ALIGNMENT);
		ClassificaLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		//GiocoLabel.setAlignmentY(CENTER_ALIGNMENT);
		GiocoLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		// aggiungo i label al pannello
		panel.add(Box.createRigidArea(new Dimension( 0,BUTTON_SPACING)));
		panel.add(GiocoLabel);
		panel.add(Box.createRigidArea(new Dimension( 0,BUTTON_SPACING)));
		panel.add(PartecipaTorneo);
		panel.add(Box.createRigidArea(new Dimension( 0,BUTTON_SPACING)));
		panel.add(ClassificaLabel);
		panel.add(Box.createRigidArea(new Dimension( 0,BUTTON_SPACING)));
		panel.add(ClassificaTorneo);
		panel.add(Box.createRigidArea(new Dimension( 0,BUTTON_SPACING)));
		panel.add(TorneiLabel);
		panel.add(Box.createRigidArea(new Dimension( 0,BUTTON_SPACING)));
		panel.add(Torneo);
		panel.add(erroreLabel);
		panel_.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 10));
		
		panel_.setLayout(new BoxLayout(panel_, BoxLayout.X_AXIS));
		panel_.add(Box.createRigidArea(new Dimension( 0,0)));
		
		table.setAlignmentX(CENTER_ALIGNMENT);
		
		panel_.add(new JScrollPane(table));
		panelLayout.add(panel, BorderLayout.CENTER);
		panelLayout.add(panel_, BorderLayout.SOUTH);
		// aggiungo tabella

		// rendo il frame e il label visibili

		

		setVisible(true);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JComboBox<String> getTorneo() {
		return Torneo;
	}

	public void setTorneo(JComboBox<String> torneo) {
		Torneo = torneo;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getClassificaTorneo() {
		return ClassificaTorneo;
	}

	public void setClassificaTorneo(JButton classificaTorneo) {
		ClassificaTorneo = classificaTorneo;
	}

	public JButton getPartecipaTorneo() {
		return PartecipaTorneo;
	}

	public void setPartecipaTorneo(JButton partecipaTorneo) {
		PartecipaTorneo = partecipaTorneo;
	}

}

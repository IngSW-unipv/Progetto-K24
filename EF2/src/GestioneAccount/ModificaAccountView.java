package GestioneAccount;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ModificaAccountView extends JFrame{
	private JLabel istruzioniLabel = new JLabel("Inserisci il nuovo username e la tua attuale password per confermare:");
	private JLabel newUsernameLabel = new JLabel("Nuovo username: ");
	private JLabel passwordLabel = new JLabel("Password: ");
	private JTextField usernameText = new JTextField();
	private JPasswordField passwordText = new JPasswordField();
	private JButton modificaButton = new JButton("Modifica");
	private JCheckBox passwordsCheckBox = new JCheckBox("Mostra password");
	private JLabel erroreText = new JLabel();
	
	// costruttore
	public ModificaAccountView() {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		//Impostazione dimensioni e posizioni nel pannello
		istruzioniLabel.setBounds(160, 15, 400, 30);
		newUsernameLabel.setBounds(180, 50, 120, 30);
		passwordLabel.setBounds(200, 150, 100, 30);
		usernameText.setBounds(300, 50, 100, 30);
		passwordText.setBounds(300, 150, 100, 30);
		usernameText.setSize(150, 30);
		passwordText.setSize(150, 30);
		modificaButton.setBounds(200, 240, 100, 30);
		passwordsCheckBox.setBounds(480, 150, 150, 30);
		erroreText.setBounds(200,  195, 500, 35);
		
		//Aggiunta delle label al pannello
		panel.add(istruzioniLabel);
		panel.add(newUsernameLabel);
		panel.add(passwordLabel);
		panel.add(usernameText);
		panel.add(passwordText);
		panel.add(modificaButton);
		panel.add(passwordsCheckBox);
		panel.add(erroreText);

		//Visibilità
		setVisible(true);
	}
}
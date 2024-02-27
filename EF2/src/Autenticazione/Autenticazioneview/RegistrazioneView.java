package Autenticazione.Autenticazioneview;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * La classe RegistrazioneView estende JFrame e rappresenta la view
 * per il caso d'uso che riguarda la registrazione
 */

public class RegistrazioneView extends JFrame {

	private static final long serialVersionUID = 1L;

	// elementi UI
	private JLabel nomeLabel;
	private JLabel cognomeLabel;
	private JLabel usernameLabel;
	private JTextField usernameText;
	private JLabel emailLabel;
	private JLabel password1Label;
	private JLabel password2Label;
	private JTextField nomeText;
	private JTextField cognomeText;
	private JTextField emailText;
	private JPasswordField password1Text;
	private JPasswordField password2Text;
	private JButton registratiButton;
	private JLabel accediLabel;
	private JButton accediButton;
	private JCheckBox passwordsCheckBox;
	private JLabel erroreLabel;

	public RegistrazioneView() {

		// inizializzazione elementi usati
		this.nomeLabel = new JLabel("Nome: ");
		this.cognomeLabel = new JLabel("Cognome: ");
		this.usernameLabel = new JLabel("Username: ");
		this.usernameText = new JTextField();
		this.emailLabel = new JLabel("Email: ");
		this.password1Label = new JLabel("Password: ");
		this.password2Label = new JLabel("Conferma Password: ");
		this.nomeText = new JTextField();
		this.cognomeText = new JTextField();
		this.emailText = new JTextField();
		this.password1Text = new JPasswordField();
		this.password2Text = new JPasswordField();
		this.registratiButton = new JButton("Registrati");
		this.accediLabel = new JLabel("Sei già registrato? Clicca su questo bottone:");
		this.accediButton = new JButton("Accedi");
		this.passwordsCheckBox = new JCheckBox("Mostra password");
		this.erroreLabel = new JLabel();
		this.nomeText.setColumns(20); // Imposta la dimensione delle colonne
		this.cognomeText.setColumns(20);
		this.usernameText.setColumns(20);
		this.emailText.setColumns(20);
		this.password1Text.setColumns(20);
		this.password2Text.setColumns(20);

		JPanel panel = new JPanel(new GridBagLayout());
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		add(panel);

		c.insets = new Insets(0, 10, 10, 10);

		//posizioni degli elementi
		c.gridx = 0;
		c.gridy = 0;
		panel.add(nomeLabel, c);

		c.gridx = 1;
		panel.add(nomeText, c);

		c.gridx = 0;
		c.gridy = 1;
		panel.add(cognomeLabel, c);

		c.gridx = 1;
		panel.add(cognomeText, c);

		c.gridx = 0;
		c.gridy = 2;
		panel.add(usernameLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		panel.add(usernameText, c);

		c.gridx = 0;
		c.gridy = 3;
		panel.add(emailLabel, c);

		c.gridx = 1;
		panel.add(emailText, c);

		c.gridx = 0;
		c.gridy = 4;
		panel.add(password1Label, c);

		c.gridx = 1;
		c.gridy = 4;
		panel.add(password1Text, c);

		c.gridx = 0;
		c.gridy = 5;
		panel.add(password2Label, c);

		c.gridx = 1;
		c.gridy = 5;
		panel.add(password2Text, c);

		c.gridx = 2;
		c.gridy = 4;
		panel.add(passwordsCheckBox, c);

		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		panel.add(registratiButton, c);

		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 2;
		panel.add(accediLabel, c);

		c.gridx = 2;
		c.gridy = 7;
		c.gridwidth = 1;
		panel.add(accediButton, c);

		c.gridx = 1;
		c.gridy = 8;
		panel.add(erroreLabel, c);

		setVisible(true);
	}

	// getters and setters
	public JTextField getUsernameText() {
		return usernameText;
	}

	public boolean isPasswordsCheckBoxSelected() {
		return passwordsCheckBox.isSelected();
	}

	public void setPasswordFieldsEchochar(char echoChar) {
		password1Text.setEchoChar(echoChar);
		password2Text.setEchoChar(echoChar);
	}

	public JCheckBox getPasswordsCheckBox() {
		return passwordsCheckBox;
	}

	public JPasswordField getPassword1Text() {
		return password1Text;
	}

	public JPasswordField getPassword2Text() {
		return password2Text;
	}

	public JButton getRegistratiButton() {
		return registratiButton;
	}

	public JTextField getNomeText() {
		return nomeText;
	}

	public JTextField getCognomeText() {
		return cognomeText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public void setErroreLabel(JLabel erroreLabel) {
		this.erroreLabel = erroreLabel;
	}

	public JLabel getErroreLabel() {
		return erroreLabel;
	}

	public JButton getAccediButton() {
		return accediButton;
	}
}
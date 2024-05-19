package Autenticazione.Autenticazioneview;

import java.awt.Color; 
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
 * Classe LoginView che estende JFrame e implementa la view per il login
 * Il login è implementato seguendo l'architettura MVC
 */

public class LoginView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// elementi UI
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JLabel registratiLabel;
	private JButton registratiButton;
	private JCheckBox passwordsCheckBox;
	private JLabel erroreText;
	GridBagConstraints c;

	public LoginView() {

		//inizializzazione elementi UI
		this.usernameLabel = new JLabel("EMAIL: ");
		this.passwordLabel = new JLabel("PASSWORD: ");
		this.usernameText = new JTextField();
		this.passwordText = new JPasswordField();
		this.loginButton = new JButton("Login");
		this.registratiLabel = new JLabel("Non sei ancora registrato? clicca su questo bottone:");
		this.registratiButton = new JButton("Registrati");
		this.passwordsCheckBox = new JCheckBox("Mostra password");
		this.erroreText = new JLabel();
		this.usernameText.setColumns(10); // setto la dimensione delle colonne dello usernameText e passwordText
		this.passwordText.setColumns(10);
		c = new GridBagConstraints();

		JPanel panel = new JPanel(new GridBagLayout());
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		add(panel);

		c.insets = new Insets(10, 5, 10, 5);

		c.gridx = 0;
		c.gridy = 0;
		panel.add(usernameLabel, c);

		c.gridx = 1;
		panel.add(usernameText, c);

		c.gridx = 0;
		c.gridy = 1;
		panel.add(passwordLabel, c);

		c.gridx = 1;
		panel.add(passwordText, c);

		c.gridx = 0;
		c.gridy = 2;
		panel.add(loginButton, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		panel.add(registratiLabel, c);

		c.gridx = 2;
		c.gridwidth = 1;
		panel.add(registratiButton, c);

		c.gridx = 2;
		c.gridy = 1;
		panel.add(passwordsCheckBox, c);

		c.gridx = 1;
		c.gridy = 5;
		panel.add(erroreText, c);

		setVisible(true);
	}

	// getters and setters
	public JCheckBox getPasswordsCheckBox() {
		return passwordsCheckBox;
	}

	public boolean isPasswordsCheckBoxSelected() {
		return passwordsCheckBox.isSelected();
	}

	public void setPasswordFieldsEchocharNull() {
		passwordText.setEchoChar((char) 0);
	}
	
	public void setPasswordFieldsEchocharPoint() {
		passwordText.setEchoChar('•');
	}

	public JButton getRegistratiButton() {
		return registratiButton;
	}

	public JLabel getErroreText() {
		return erroreText;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JTextField getUsernameText() {
		return usernameText;
	}

	public JPasswordField getPasswordText() {
		return passwordText;
	}
	
	public void displayText(int i) {
		if (i==0) {
			erroreText.setForeground(Color.green);
			erroreText.setText("ACCESSO CORRETTO"); 
		} else if (i==1){
			erroreText.setForeground(Color.red);
			erroreText.setText("Password errata");
		} else {
			erroreText.setForeground(Color.orange);
			erroreText.setText("Errore, riprova a registrarti");
		}

	}
	
	public void setErroreText(JLabel erroreText) {
		this.erroreText = erroreText;
	}
}
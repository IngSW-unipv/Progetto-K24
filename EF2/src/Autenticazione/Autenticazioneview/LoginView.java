package Autenticazione.Autenticazioneview;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private JLabel usernameLabel = new JLabel("EMAIL: ");
	private JLabel passwordLabel = new JLabel("PASSWORD: ");
	private JTextField usernameText = new JTextField();
	private JPasswordField passwordText = new JPasswordField();
	private JButton loginButton = new JButton("Login");
	private JLabel registratiLabel = new JLabel("Non sei ancora registrato? clicca su questo bottone:");
	private JButton registratiButton = new JButton("Registrati");
	private JCheckBox passwordsCheckBox = new JCheckBox("Mostra password");
	private JLabel erroreText = new JLabel();
	
	// costruttore
	public LoginView() {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		// setto le dimensioni e le posizioni dei label
		usernameLabel.setBounds(200, 50, 100, 30);
		passwordLabel.setBounds(200, 150, 100, 30);
		usernameText.setBounds(300, 50, 100, 30);
		passwordText.setBounds(300, 150, 100, 30);
		usernameText.setSize(150, 30);
		passwordText.setSize(150, 30);
		loginButton.setBounds(200, 240, 100, 30);
		registratiLabel.setBounds(200, 270, 300, 30);
		registratiButton.setBounds(500, 270, 100, 30);
		passwordsCheckBox.setBounds(480, 150, 150, 30);
		erroreText.setBounds(200,  195, 500, 35);
		
		// aggiungo i label al pannello
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(usernameText);
		panel.add(passwordText);
		panel.add(loginButton);
		panel.add(registratiLabel);
		panel.add(registratiButton);
		panel.add(passwordsCheckBox);
		panel.add(erroreText);
		// fine label

		// fine eyeCheckBox

		// rendo il frame e il label visibili
		setVisible(true);
		// fine costruttore
	}

	// getters and setters
	public JCheckBox getPasswordsCheckBox() {
		return passwordsCheckBox;
	}

	public boolean isPasswordsCheckBoxSelected() {
		return passwordsCheckBox.isSelected();
	}
	
	public void setPasswordFieldsEchochar(char echoChar) {
		passwordText.setEchoChar(echoChar);
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

	public JTextField getEmailText() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//fine getters and setters


}

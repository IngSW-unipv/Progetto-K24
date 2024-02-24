package Autenticazione.Autenticazioneview;

import java.awt.Color;
import java.awt.Toolkit;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrazioneView extends JFrame {

	// aggiungo i label
	private JPanel panel = new JPanel();
	public void setNomeText(JTextField nomeText) {
		this.nomeText = nomeText;
	}

	public void setCognomeText(JTextField cognomeText) {
		this.cognomeText = cognomeText;
	}

	public void setEmailText(JTextField emailText) {
		this.emailText = emailText;
	}

	private JLabel password1Label = new JLabel("PASSWORD: ");
	private JLabel password2Label = new JLabel("PASSWORD: ");
	private JLabel nomeLabel = new JLabel("NOME: ");
	private JLabel cognomeLabel = new JLabel("COGNOME: ");
	private JTextField nomeText = new JTextField();
	private JTextField cognomeText = new JTextField();
	private JPasswordField password1Text = new JPasswordField();
	private JPasswordField password2Text = new JPasswordField();
	private JButton registratiButton = new JButton("Registrati");
	private JLabel accediLabel = new JLabel("Sei già registrato? Clicca su questo bottone:");
	private JButton accediButton = new JButton("Accedi");
	private JCheckBox passwordsCheckBox = new JCheckBox("Mostra password");
	private JLabel emailLabel=new JLabel("EMAIL: ");
	private JTextField emailText= new JTextField();
	private JLabel erroreLabel=new JLabel ();
	
	// inizio costruttore
	public RegistrazioneView() {
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

		cognomeLabel.setBounds(200, 75, 100, 25);
		cognomeText.setBounds(300, 75, 100, 25);
		
		emailLabel.setBounds(200, 120, 100, 25);
		emailText.setBounds(300, 120, 100, 20);
		
		password1Label.setBounds(200, 165, 100, 25);
		password1Text.setBounds(300, 165, 100, 25);

		password2Label.setBounds(200, 210, 100, 25);
		password2Text.setBounds(300, 210, 100, 25);

		registratiButton.setBounds(200, 290, 90, 25);
		accediLabel.setBounds(200, 320, 250, 25);
		accediButton.setBounds(470, 320, 90, 25);
		passwordsCheckBox.setBounds(410, 165, 150, 25);
		
		erroreLabel.setBounds(200,  240,  500,  50);
		erroreLabel.setForeground(Color.RED);

		// aggiungo i label al pannello
		panel.add(nomeLabel);
		panel.add(cognomeLabel);
		panel.add(emailLabel);
		panel.add(emailText);
		panel.add(password1Label);
		panel.add(password2Label);
		panel.add(nomeText);
		panel.add(cognomeText);
		panel.add(password1Text);
		panel.add(password2Text);
		panel.add(registratiButton);
		panel.add(accediLabel);
		panel.add(accediButton);
		panel.add(passwordsCheckBox);
		panel.add(erroreLabel);
		//accediButton.addActionListener(e->{
			//frame.dispose();
		//});
		// fine label

		// rendo il frame e il label visibili
		setVisible(true);
	}
	// fine costruttore

	//ritorna vero se la checkBox è selezionata
	public boolean isPasswordsCheckBoxSelected() {
		return passwordsCheckBox.isSelected();
	}

	//gestisce la password, modificando i caratteri che si vedono,
	//nel controller è gestita in modo che se la checkBox è selezionata allora la password compare
	//altrimenti compaiono dei punti
	public void setPasswordFieldsEchochar(char echoChar) {
		password1Text.setEchoChar(echoChar);
		password2Text.setEchoChar(echoChar);
	}

	//ritorna la passwordsCheckBox, è un getter
	public JCheckBox getPasswordsCheckBox() {
		return passwordsCheckBox;
	}

	//getters e setters vari
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
	
	//fine getters e setters vari

}
package GestioneAccount;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EliminaAccountView extends JFrame{
	private JLabel istruzioniLabel = new JLabel("Se vuoi confermare l'operazione inserisci la password:");
	private JLabel passwordLabel = new JLabel("Password: ");
	private JPasswordField passwordText = new JPasswordField();
	private JButton eliminaButton = new JButton("Elimina");
	private JCheckBox passwordCheckBox = new JCheckBox("Mostra password");
	private JLabel erroreText = new JLabel();
	private JButton indietroButton = new JButton("Indietro");

	
	// costruttore
	public EliminaAccountView() {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// lavoro sul frame
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4,
				Toolkit.getDefaultToolkit().getScreenSize().height / 4);
		add(panel);

		//Impostazione dimensioni e posizioni nel pannello
		istruzioniLabel.setBounds(160, 15, 400, 30);
		passwordLabel.setBounds(200, 120, 100, 30);
		passwordText.setBounds(300, 120, 100, 30);
		passwordText.setSize(150, 30);
		eliminaButton.setBounds(200, 240, 100, 30);
		indietroButton.setBounds(350, 240, 100, 30);
		passwordCheckBox.setBounds(480, 120, 150, 30);
		erroreText.setBounds(200,  195, 500, 35);
		
		//Aggiunta delle label al pannello
		panel.add(istruzioniLabel);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(eliminaButton);
		panel.add(indietroButton);
		panel.add(passwordCheckBox);
		panel.add(erroreText);

		//Visibilità
		setVisible(true);
	}
	
	public boolean isPasswordCheckBoxSelected() {
		return passwordCheckBox.isSelected();
	}
	
	public void setPasswordFieldsEchocharNull() {
		passwordText.setEchoChar((char) 0);
	}
	
	public void setPasswordFieldsEchocharPoint() {
		passwordText.setEchoChar('•');
	}

	public JCheckBox getPasswordCheckBox() {
		return passwordCheckBox;
	}
	

	public JButton getEliminaButton() {
		return eliminaButton;
	}
	
	public JButton getIndietroButton() {
		return indietroButton;
	}
	
	public void displayErrore() {
		erroreText.setForeground(Color.red);
		erroreText.setText("Password errata");
	}
	
	public JLabel getErroreText() {
		return erroreText;
	}

	public JPasswordField getPasswordText() {
		return passwordText;
	}

	public void setErroreText(JLabel erroreText) {
		this.erroreText = erroreText;
	}

}

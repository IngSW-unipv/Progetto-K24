package Autenticazioneview;

import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;


public class BigFrameView extends JFrame{
	
	private JButton loginButton;
	private JButton registrazioneButton;

	
	//costruttore
	public BigFrameView () {
		loginButton = new JButton("Login");
		registrazioneButton = new JButton("Registrazione");
		
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/4, Toolkit.getDefaultToolkit().getScreenSize().height/4);
				
		//inserisco un panel usando il flowlayout		
		Panel panelLayout=new Panel();
		add(panelLayout);
		
		//inserisco i bottoni
		panelLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 10, Toolkit.getDefaultToolkit().getScreenSize().height/4));
		panelLayout.add(loginButton);
		panelLayout.add(registrazioneButton);
		panelLayout.setVisible(true);
		
		setVisible(true);
	}
	//fine costruttore


	public JButton getLoginButton() {
		return loginButton;
	}


	public JButton getRegistrazioneButton() {
		return registrazioneButton;
	}
	
	
	
}





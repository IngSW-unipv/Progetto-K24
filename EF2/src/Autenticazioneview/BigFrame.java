package Autenticazioneview;

import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Autenticazionecontroller.LoginController;
import Autenticazionecontroller.RegistrationController1;
import Autenticazionecontroller.RegistrazioneController;
import Autenticazionemodel.LoginModel;
import Autenticazionemodel.RegistrazioneModel;

public class BigFrame extends JFrame implements ActionListener{

	private RegistrazioneModel registrazioneModel;
	private RegistrazioneView registrazioneView;
	private LoginModel loginModel;
	private LoginView loginView;
	
	private JButton loginButton = new JButton("Login");
	private JButton registrazioneButton = new JButton("Registrazione");

	
	//costruttore
	public BigFrame() {
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
		
		getRegistrazioneButton().addActionListener(this);
getLoginButton().addActionListener(this);
		
		setVisible(true);
	}
	//fine costruttore


	@Override
	public void actionPerformed(ActionEvent e) {


        

		if (e.getSource()==registrazioneButton) { //se clicco sul bottone RegistrazioneView
			registrazioneModel = new RegistrazioneModel(); //li devo istanziare dentro l'if altrimenti se istanzio sia registraiozne che login fuori dal'if mi apre tutto a prescindere
	        registrazioneView = new RegistrazioneView();
			dispose();
			new RegistrationController1(registrazioneModel, registrazioneView);
		}
		if(e.getSource()==loginButton) {
	         loginModel=new LoginModel();
	         loginView=new LoginView();
	         dispose();
	         new LoginController(loginModel, loginView);
		}
		
		

	}


	//getters e setters
	public JButton getLoginButton() {
		return loginButton;
	}


	public JButton getRegistrazioneButton() {
		return registrazioneButton;
	}
	
	
	
	
	

	
}

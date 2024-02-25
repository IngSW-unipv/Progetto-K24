package Autenticazione.Autenticazionecontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Autenticazione.Autenticazionemodel.LoginModel;
import Autenticazione.Autenticazionemodel.RegistrazioneModel;
import Autenticazione.Autenticazioneview.LoginView;
import Autenticazione.Autenticazioneview.RegistrazioneView;
import Utente.UtenteAutenticato;

public class RegistrazioneController{

	private String username;
	private String nome;
	private String cognome;
	private String email;
	private char[] password;
	private RegistrazioneModel model;
	private RegistrazioneView view;

	private UtenteAutenticato utente;

	
	public RegistrazioneController() {
        this.model = new RegistrazioneModel();
        this.view = new RegistrazioneView();
        addListeners();
    }

    private void addListeners() {
    	try {
        view.getAccediButton().addActionListener(new AccediButtonListener());
        view.getPasswordsCheckBox().addActionListener(new PasswordsCheckBoxListener());
        view.getRegistratiButton().addActionListener(new RegistratiButtonListener());
    	}
    	catch (Exception e1) {
    		e1.printStackTrace();
    		System.out.print("exceptionAbramo");
    	}
    }

    private class AccediButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            view.dispose();
            new LoginController();
        }
    }

    private class PasswordsCheckBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.isPasswordsCheckBoxSelected()) {
                view.setPasswordFieldsEchochar((char) 0);
            } else {
                view.setPasswordFieldsEchochar('•');
            }
        }
    }

     class RegistratiButtonListener implements ActionListener {
        @SuppressWarnings("deprecation")
		@Override
        public void actionPerformed(ActionEvent e) {
           char[] passwordChars1 = view.getPassword1Text().getPassword();
            String password1 = new String(passwordChars1);
            char[] passwordChars2 = view.getPassword2Text().getPassword();
            String password2 = new String(passwordChars2);

            if (model.isNomeCognomeValido(view.getNomeText().getText()) &&
                    model.isNomeCognomeValido(view.getCognomeText().getText()) &&
                    model.isEmailValida(view.getEmailText().getText()) &&
                    model.isPasswordUguali(password1, password2) &&
                    model.isPasswordValida(password1)) {
            		view.getErroreLabel().setForeground(Color.green);
                    view.getErroreLabel().setText("REGISTRAZIONE CORRETTA");
                    
                    utente = model.istanziautente(view.getNomeText().getText(),
							view.getPassword1Text().getText(), view.getEmailText().getText());
					
					
					try {
						utente.registrazioneCredenziali( utente,view.getNomeText().getText(),
								view.getPassword1Text().getText(), view.getEmailText().getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		
            } else {
            	view.getErroreLabel().setForeground(Color.red);
                view.getErroreLabel().setText("Errore nei dati inseriti.");
            }
           
        	   
           
        }
    }

  //getters and setters
  	public String getUsername() {
  		return username;
  	}



  	public void setUsername(String username) {
  		this.username = username;
  	}



  	public String getNome() {
  		return nome;
  	}



  	public void setNome(String nome) {
  		this.nome = nome;
  	}



  	public String getCognome() {
  		return cognome;
  	}



  	public void setCognome(String cognome) {
  		this.cognome = cognome;
  	}



  	public String getEmail() {
  		return email;
  	}



  	public void setEmail(String email) {
  		this.email = email;
  	}



  	public char[] getPassword() {
  		return password;
  	}



  	public void setPassword(char[] password) {
  		this.password = password;
  	}


   
	

}
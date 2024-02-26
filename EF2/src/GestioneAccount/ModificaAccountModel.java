package GestioneAccount;

import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class ModificaAccountModel {

	
	public ModificaAccountModel() {
		
	}
	
	public void modificaAccount(String newUsername) {
		
		SingletonGestione.getInstance().getUtente().setUsername(newUsername);
		SingletonGestione.getInstance().getUtentedao().updateSchemaUtente(SingletonGestione.getInstance().getUtente());
		
		
	}
	
}

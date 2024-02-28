package GestioneAccount;

import Utente.SingletonGestione;

public class GestioneAccountModel {
	
	public GestioneAccountModel() {
		
	}
	
	public void modificaAccount(String newUsername) {	
		SingletonGestione.getInstance().getUtente().setUsername(newUsername);
		SingletonGestione.getInstance().getUtentedao().updateSchemaUtente(SingletonGestione.getInstance().getUtente());
	}
	
	public void eliminaUtente() {
		SingletonGestione.getInstance().getUtentedao().eliminaSchemaUtente(SingletonGestione.getInstance().getUtente());
	}

}

package GestioneAccount;

import Utente.SingletonGestione;

public class EliminaAccountModel {

	public EliminaAccountModel() {

	}

	public void eliminaUtente() {

		SingletonGestione.getInstance().getUtentedao().eliminaSchemaUtente(SingletonGestione.getInstance().getUtente());

	}

}

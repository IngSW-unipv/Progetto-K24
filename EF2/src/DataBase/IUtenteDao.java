package DataBase;

import java.sql.SQLException;
import java.util.ArrayList;

import Index.GiochiEnum;
import Messaggi.Messaggio;
import Utente.UtenteAutenticato;

public interface IUtenteDao {

	public ArrayList<String> selectAll();
	public ArrayList<UtenteAutenticato> selectByUsername(UtenteAutenticato fornInput);
	public boolean insertSchemaUtente(UtenteAutenticato f) throws SQLException;
	public boolean selectByEmail(String email);
	public boolean insertPreferiti(UtenteAutenticato f, String gioco); 
	public boolean deletePreferiti(UtenteAutenticato f, String gioco); 
	public ArrayList<GiochiEnum> selectPreferiti(UtenteAutenticato f); 
	public boolean insertMessaggio(UtenteAutenticato f, Messaggio m);
	public ArrayList<Messaggio> selectMessaggio(UtenteAutenticato f);

}

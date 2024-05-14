package DataBase;

import java.sql.SQLException;
import java.util.ArrayList;

import Utente.UtenteAutenticato;

public interface IUtenteDao {

	public ArrayList<String> selectAll();
	public ArrayList<UtenteAutenticato> selectByUsername(UtenteAutenticato fornInput);
	public boolean insertSchemaUtente(UtenteAutenticato f) throws SQLException;
	public boolean selectByEmail(String email);
	public boolean insertPreferiti(UtenteAutenticato f); ////CHE ALTRO PARAMETRO
	public boolean deletePreferiti(UtenteAutenticato f); ////CHE ALTRO PARAMETRO
	public ArrayList<String> selectPreferiti(UtenteAutenticato f); ///NON STRINGHE

}

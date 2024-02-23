package DataBase;

import java.sql.SQLException;
import java.util.ArrayList;

import Utente.UtenteAutenticato;

public interface IUtenteDao {

	public ArrayList<UtenteAutenticato> selectAll();
	public ArrayList<UtenteAutenticato> selectByUsername(UtenteAutenticato fornInput);
	public boolean insertSchemaUtente(UtenteAutenticato f) throws SQLException;
	
}

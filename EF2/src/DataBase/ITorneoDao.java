package DataBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.time.LocalDate;

public interface ITorneoDao {

	public boolean insertTorneo(String nometorneo, String nome, String gioco, Date date, Date date_);

	public boolean insertpartecipante(String emailutente, String nometorneo, int punteggio);

	public boolean deleteTorneo(String nometorneo);

	public boolean deletePartecipante(String emailutente);

	public ArrayList<String> selectAllByTorneo(String nometorneo);

	public boolean ricercaIscritto(String nometorneo, String emailutente);

	public boolean ricercaTorneo(String nomeutente);

	public void modificapunteggiobyuser();

	public ArrayList<String> selezionalistatorneo();
	
	public HashMap<String,Integer> selezionaclassifica(String nometorneo);

	public boolean selectbyuser(String id, String emailUtente);

	public boolean ricercaCreatore(String nomeutente);

	public boolean selezionaUtenteTorneo(String emailUtente);

}

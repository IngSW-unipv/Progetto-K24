package DataBase;

import java.util.ArrayList;
import java.util.Date;

import Torneo.Torneo;

import java.time.LocalDate;

public interface ITorneoDao {

	public boolean insertTorneo(String nometorneo, String nome, String gioco, Date date, Date date_, String visibilità);

	public boolean insertpartecipante(String emailutente,String nometorneo,int punteggio);
	
	public boolean deleteTorneo(String nometorneo);

	public boolean deletepartecipante(String emailutente);
	
	public ArrayList<String> selectbytorneo(String nometorneo);
	
	public ArrayList<String> selecttuplebytorneo(String nometorneo);
	
	public ArrayList<String> elencatorneo();

	public void modificapunteggiobyuser();

	public ArrayList<String> selectbyuser();

	boolean selectbyuser(String id, String emailUtente);

}

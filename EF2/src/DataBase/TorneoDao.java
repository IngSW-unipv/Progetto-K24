package DataBase;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import Torneo.Torneo;
import Utente.UtenteAutenticato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;

public class TorneoDao implements ITorneoDao {

	private Connection conn;
	private String schema;
	private int count;

	public TorneoDao() {

		super();
		this.schema = "prova";

	}

	public boolean insertpartecipante(String emailutente, String nometorneo, int punteggio) {
		// TODO Auto-generated method stub

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		boolean esito = true;

		try {
			String query = "INSERT INTO partecipazioni (emailUtente,nometorneo,punteggio ) VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			st1.setString(1, emailutente);
			st1.setString(2, nometorneo);
			st1.setInt(3, punteggio);

			st1.executeUpdate();
			System.out.println("insert succesful");

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	@Override
	public boolean insertTorneo(String nometorneo, String nome, String gioco, Date date, Date date_) {
		// TODO Auto-generated method stub

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		java.sql.Date sqlDate_ = new java.sql.Date(date_.getTime());
		boolean esito = true;

		try {
			String query = "INSERT INTO tornei (nometorneo,creatore ,datainizio ,datafine ,gioco ) VALUES(?,?,?,?,?)";
			st1 = conn.prepareStatement(query);
			st1.setString(1, nometorneo);
			st1.setString(2, nome);
			st1.setDate(3, sqlDate);
			st1.setDate(4, sqlDate_);
			st1.setString(5, gioco);

			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	@Override
	public boolean deleteTorneo(String nometorneo) {
		// TODO Auto-generated method stub
		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		boolean esito = true;

		try {
			String query = "Delete from tornei where nometorneo =? ";
			st1 = conn.prepareStatement(query);
			st1.setString(1, nometorneo);
			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	@Override
	public boolean ricercaCreatore(String nomeutente) {
		// TODO Auto-generated method stub
		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		ResultSet rs1;

		boolean esito = false;

		try {
			String query = "Select COUNT(creatore) from tornei where creatore =? ";
			st1 = conn.prepareStatement(query);
			st1.setString(1, nomeutente);
			rs1 = st1.executeQuery();

			while (rs1.next()) {
				count = rs1.getInt(1);

				if (count == 1) {

					esito = false;

				} else {
					esito = true;
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			esito = true;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	
	//modifica nome
	
	@Override
	public boolean ricercaTorneo(String nometorneo) {
		// TODO Auto-generated method stub
		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		ResultSet rs1;

		boolean esito = false;

		try {
			String query = "Select COUNT(nometorneo) from tornei where nometorneo =? ";
			st1 = conn.prepareStatement(query);
			st1.setString(1, nometorneo);
			rs1 = st1.executeQuery();

			while (rs1.next()) {
				count = rs1.getInt(1);

				if (count == 1) {

					esito = false;

				} else {
					esito = true;
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			esito = true;
		}

		DBconnection.closeConnection(conn);
		return esito;
	}

	
	@Override
	public boolean ricercaIscritto(String nometorneo,String emailUtente) {
		// TODO Auto-generated method stub
		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		ResultSet rs1;

		boolean esito = true;

		try {
			String query = "Select COUNT(nometorneo and emailUtente) from partecipazioni where nometorneo =? and emailUtente= ?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, nometorneo);
			st1.setString(2, emailUtente);
			rs1 = st1.executeQuery();

			while (rs1.next()) {
				count = rs1.getInt(1);

				if (count == 1) {

					esito = true;

				} else {
					esito = false;
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;
	}

	
	
	@Override
	public void modificapunteggiobyuser() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean selectbyuser(String id, String emailUtente) {
		// TODO Auto-generated method stub

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		boolean result = true;

		try {
			// st1 = conn.createStatement();
			String query = "select * from partecipazioni where emailUtente=? and id=?  ";
			st1 = conn.prepareStatement(query);
			st1.setString(1, id);
			st1.setString(2, emailUtente);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		DBconnection.closeConnection(conn);
		return result;

	}

	@Override
	public ArrayList<String> selectbyuser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePartecipante(String emailutente) {
		// TODO Auto-generated method stub
		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		boolean esito = true;

		try {
			String query = "Delete from partecipazioni where emailutente = ?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, emailutente);
			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	@Override
	public boolean selezionaUtenteTorneo(String emailUtente) {
		// TODO Auto-generated method stub
		boolean esito =true;

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;

		try {

			String query = "select COUNT(creatore) from tornei where creatore=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, emailUtente);
			rs1 = st1.executeQuery();

			while (rs1.next()) {
				count = rs1.getInt(1);

				if (count == 1) {

					esito = true;

				} else {
					esito = false;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			esito=false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	@Override
	public ArrayList<String> selectAllByTorneo(String nometorneo) {

		ArrayList<String> result = new ArrayList<>();

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;

		try {

			String query = "select * from tornei where nometorneo=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, nometorneo);
			// st1.executeUpdate();

			rs1 = st1.executeQuery(query);

			while (rs1.next()) {

				result.add(rs1.getString(query));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		DBconnection.closeConnection(conn);
		return result;
	}
}

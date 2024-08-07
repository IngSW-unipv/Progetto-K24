package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Index.GiochiEnum;
import Messaggi.Messaggio;

import Utente.UtenteAutenticato;

public class UtenteDao implements IUtenteDao {

	private static UtenteDao instance;
	private String schema;
	private Connection conn;
	private ArrayList<UtenteAutenticato> utentelist;
	public int count;

	private UtenteDao() {
		super();
		this.schema = "java";

	}

	public static UtenteDao getInstance() {

		if (instance == null) {

			instance = new UtenteDao();

		}
		return instance;
	}

	@Override
	public ArrayList<String> selectAll() {
		ArrayList<String> result = new ArrayList<>();

		conn = DBconnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;

		try {
			st1 = conn.createStatement();
			String query = "select * from utenti ";
			rs1 = st1.executeQuery(query);

			while (rs1.next()) {
				// UtenteAutenticato f=new UtenteAutenticato(rs1.getInt(1),
				// rs1.getString(2),rs1.getString(3),rs1.getString(4));

				result.add(rs1.getString(1));
				result.add(rs1.getString(2));
				result.add(rs1.getString(3));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		DBconnection.closeConnection(conn);
		return result;
	}

	public ArrayList<UtenteAutenticato> selectByUsername(UtenteAutenticato fornInput) {
		ArrayList<UtenteAutenticato> result = new ArrayList<>();

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;

		try {
			String query = "SELECT COUNT(username and pswrd) FROM utenti WHERE username = ? AND pswrd = ?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, fornInput.getUsername());
			st1.setString(2, fornInput.getHashedPassword());
			rs1 = st1.executeQuery();

			while (rs1.next()) {
				// SchemaUtente f=new SchemaUtente(rs1.getInt(1),
				// rs1.getString(2),rs1.getString(3),rs1.getString(4));

				// result.add(f);

				count = rs1.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		DBconnection.closeConnection(conn);
		return result;
	}

	// selecttorneo by user

	public boolean selectByEmailUser(UtenteAutenticato Input) {

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		boolean esito = true;
		try {
			String query = "SELECT COUNT(email and pswrd ) FROM utenti WHERE email = ? AND pswrd = ?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, Input.getEmail());
			st1.setString(2, Input.getHashedPassword());
			rs1 = st1.executeQuery();

			while (rs1.next()) {
				// UtenteAutenticato f=new UtenteAutenticato(rs1.getInt(1),
				// rs1.getString(2),rs1.getString(3),rs1.getString(4));

				// result.add(f);

				count = rs1.getInt(1);
				// System.out.println(Input.getPassword().toString());
				// System.out.println(f.getPassword().toString());
				if (count == 1) {
					esito = true;

				} else {

					esito = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);

		return esito;

	}

	public boolean selectByEmail(String email) {

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		boolean esito = true;
		try {
			String query = "SELECT COUNT(email) FROM utenti WHERE email = ?";

			st1 = conn.prepareStatement(query);
			st1.setString(1, email);

			rs1 = st1.executeQuery();

			while (rs1.next()) {
				// UtenteAutenticato f=new UtenteAutenticato(rs1.getInt(1),
				// rs1.getString(2),rs1.getString(3),rs1.getString(4));

				// result.add(f);

				count = rs1.getInt(1);
				// System.out.println(Input.getPassword().toString());
				// System.out.println(f.getPassword().toString());
				if (count == 1) {

					esito = true;
				} else {

					esito = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);

		return esito;

	}

	public boolean insertSchemaUtente(UtenteAutenticato f) throws SQLException {

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		boolean esito = true;

		try {
			String query = "INSERT INTO utenti(email,username,pswrd) VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			System.out.println(f.getEmail());
			st1.setString(1, f.getEmail());
			st1.setString(2, f.getUsername());
			st1.setString(3, f.getHashedPassword());

			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	public boolean eliminaSchemaUtente(UtenteAutenticato f) {

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		boolean esito = true;

		try {
			String query = "Delete from utenti where email = ?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getEmail());
			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	public void Arraylist(UtenteAutenticato utente) {

		utentelist = new ArrayList<UtenteAutenticato>();
		utentelist.add(utente);

	}

	public boolean updateSchemaUtente(UtenteAutenticato f) {

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;

		boolean esito = true;

		try {
			String query = "update utenti set username=? where email=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getUsername());
			st1.setString(2, f.getEmail());
			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;

	}

	public boolean insertPreferiti(UtenteAutenticato f, GiochiEnum gioco) { 
		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;

		try {
			String query = "INSERT INTO preferenze(emailUtente, gioco) VALUES(?,?)";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getEmail());
			st1.setString(2, gioco.toString()); 
			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;
	}

	public boolean deletePreferiti(UtenteAutenticato f, GiochiEnum gioco) { 
		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;

		try {
			String query = "DELETE FROM preferenze WHERE emailUtente=? AND gioco=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getEmail());
			st1.setString(2, gioco.toString()); 
			st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBconnection.closeConnection(conn);
		return esito;
	}

	@Override
	public ArrayList<GiochiEnum> selectPreferiti(UtenteAutenticato f) {
		ArrayList<GiochiEnum> result = new ArrayList<GiochiEnum>();

		conn = DBconnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;

		try {
			String query = "SELECT gioco FROM preferenze WHERE emailUtente=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getEmail());
			rs1 = st1.executeQuery(); // Non è necessario passare la query qui

			while (rs1.next()) {
				result.add(GiochiEnum.valueOf(rs1.getString("gioco")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		DBconnection.closeConnection(conn);
		return result;
	}

	@Override
	public boolean insertMessaggio(UtenteAutenticato f, Messaggio m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Messaggio> selectMessaggio(UtenteAutenticato f) {
		// TODO Auto-generated method stub
		return null;
	}

}

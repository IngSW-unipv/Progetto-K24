package DataBase;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Utente.UtenteAutenticato;

public class UtenteDao implements IUtenteDao {

	
	private String schema;
	private Connection conn;
	private ArrayList<UtenteAutenticato> utentelist;
    public int count;
	
	public UtenteDao() {
		super();
		this.schema = "prova";
       
	}


	@Override
	public ArrayList<UtenteAutenticato> selectAll()
	{
		ArrayList<UtenteAutenticato> result = new ArrayList<>();

		conn=DBconnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="select * from utente1 ";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				UtenteAutenticato f=new UtenteAutenticato(rs1.getInt(1), rs1.getString(2),rs1.getString(3),rs1.getString(4));

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBconnection.closeConnection(conn);
		return result;
	}

	public ArrayList<UtenteAutenticato> selectByUsername (UtenteAutenticato fornInput)
	{
		ArrayList<UtenteAutenticato> result = new ArrayList<>();

		conn=DBconnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT COUNT(username and pswrd) FROM utente1 WHERE username = ? AND pswrd = ?";
			
			

			st1 = conn.prepareStatement(query);
			st1.setString(1, fornInput.getUsername());
			st1.setString(2, fornInput.getHashedPassword());
			rs1=st1.executeQuery();

			while(rs1.next())
			{
				//Schemautente f=new Schemautente(rs1.getInt(1), rs1.getString(2),rs1.getString(3),rs1.getString(4));

				//result.add(f);
				
				count = rs1.getInt(1);
			}
		}catch (Exception e){e.printStackTrace();}

		DBconnection.closeConnection(conn);
		return result;
	}
	
	//selecttorneo by user
	
	
	public boolean selectByEmailUser(UtenteAutenticato Input)
	{
		
		conn=DBconnection.startConnection(conn,schema);
		PreparedStatement st1;
		ResultSet rs1;
       boolean esito =true;
		try
		{
			String query="SELECT COUNT(email and pswrd ) FROM utente1 WHERE email = ? AND pswrd = ?";
			

			st1 = conn.prepareStatement(query);
			st1.setString(1, Input.getEmail());
			st1.setString(2, Input.getHashedPassword());
			rs1=st1.executeQuery();

			while(rs1.next())
			{
				//UtenteAutenticato f=new UtenteAutenticato(rs1.getInt(1), rs1.getString(2),rs1.getString(3),rs1.getString(4));

				//result.add(f);
				
				count = rs1.getInt(1);
				//System.out.println(Input.getPassword().toString());
				//System.out.println(f.getPassword().toString());
				if(	count== 1 ) {
				esito=true;
			}else {
				
				esito= false;
			}
			}
			
			
			
		}catch (Exception e)
		{
			e.printStackTrace();
			esito= false;
		}
           
		DBconnection.closeConnection(conn);
		
		return esito;
		
	}

	public boolean insertSchemautente(UtenteAutenticato f)throws SQLException {

		conn=DBconnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			String query="INSERT INTO utente1(ut_id,email,username,pswrd) VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, f.getId());
			st1.setString(2,f.getEmail() );
			st1.setString(3,f.getUsername());
			st1.setString(4,f.getHashedPassword());
			
			st1.executeUpdate();

			
			
		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		
		DBconnection.closeConnection(conn);
		return esito;

	}
	
	public boolean eliminaSchemautente(UtenteAutenticato f) {

		conn=DBconnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			String query="Delete from utente1 where email = ?";
			st1 = conn.prepareStatement(query);
			st1.setString(1,f.getEmail());	
			st1.executeUpdate();

			
			
		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		
		DBconnection.closeConnection(conn);
		return esito;

	}
	public void Arraylist(UtenteAutenticato utente) {
		
		utentelist = new ArrayList<UtenteAutenticato>();
		utentelist.add(utente);
		
	}
    
	public boolean UpdateSchemautente(UtenteAutenticato f) {
	
		conn=DBconnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			
			String query="update utente1 set username=?,pswrd=? where email=?";//"+f.getId()+","+f.getemail()+","+f.getUsername()+","+f.getpassword()+");";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getUsername());	
			st1.setString(1, f.getEmail());
			st1.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBconnection.closeConnection(conn);
		return esito;
		
	}
	
	
	@Override
	public boolean insertSchemaUtente(UtenteAutenticato f) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

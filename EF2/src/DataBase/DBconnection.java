package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {

/*	private static final String PROPERTYDBDRIVER = "DBDRIVER";
	private static final String PROPERTYDBURL = "DBURL";
	private static final String PROPERTYNAME = "db_usn";
	private static final String PROPERTYPSW = "db_psw";*/
	private static String username;
	private static String password;
	private static String dbDriver;
	private static String dbURL;
	// private static DBconnection conn;

	private static void init() {
		// Properties p = new Properties(System.getProperties());
		try {
			// p.load(new FileInputStream("properties/properties"));
			username = "root";
			password = "Viadoro7.";
			dbDriver = "com.mysql.lib.jdbc.Driver";
			dbURL = "jdbc:mysql://127.0.0.1:3306/";

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection startConnection(Connection conn, String schema) {

		System.out.println("jdbc:mysql://127.0.0.1:3306/" + schema);

		if (isOpen(conn))
			closeConnection(conn);

		try {

			// dbURL="jdbc:mysql://127.0.0.1:3307/"+schema;
			// System.out.println(dbURL);
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + schema
					+ "?user=root?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "Viadoro7.");// Apertura connessione

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static boolean isOpen(Connection conn) {
		if (conn == null)
			return false;
		else
			return true;
	}

	public static Connection closeConnection(Connection conn) {
		if (!isOpen(conn))
			return null;
		try {

			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}

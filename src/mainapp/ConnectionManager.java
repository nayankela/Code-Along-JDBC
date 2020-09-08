package mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Register the drive class
		Class.forName("oracle.jdbc.OracleDriver");
		// Create the connection Object
		Connection con = null;
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "system");

		if (con != null) {
			System.out.println("Established");
		}
		return con;
	}
}

package mainapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

	public void addUser(RegisterPojo registerPojo) throws ClassNotFoundException, SQLException {
		String firstName = registerPojo.getFirstName();
		String lastName = registerPojo.getLastName();
		String userName = registerPojo.getUserName();
		String password = registerPojo.getUserName();
		String email = registerPojo.getEmail();

		ConnectionManager cm = new ConnectionManager();
		// insert all the details into database
		String sql = "insert into USER_DETAILS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL) VALUES(?,?,?,?,?)";
		// CREATING STMT OBJEcT
		PreparedStatement statement = cm.getConnection().prepareStatement(sql);
		statement.setString(1, firstName);
		statement.setString(2, lastName);
		statement.setString(3, userName);
		statement.setString(4, password);
		statement.setString(5, email);
		statement.executeUpdate();
		cm.getConnection().close();
	}
}
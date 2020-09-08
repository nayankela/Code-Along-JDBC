package mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

	public boolean validate(LoginPojo loginPojo) throws ClassNotFoundException, SQLException {

		String userName = loginPojo.getUserName();
		String password = loginPojo.getPassword();

		ConnectionManager con = new ConnectionManager();
		Statement statement = con.getConnection().createStatement();

		ResultSet rs = statement.executeQuery("SELECT * FROM USER_DETAILS");
		boolean result = true;
		while (rs.next()) {
			if (userName.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD"))) {
				con.getConnection().close();
				result = true;
			} else {
				con.getConnection().close();
				result = false;
			}
		}
		return result;

	}

}

package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("1.Register here");
		System.out.println("2.Login");
		int x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());

		// objects
		RegisterPojo registerPojo = new RegisterPojo();
		RegisterDAO registerDAO = new RegisterDAO();
		
		LoginPojo loginPojo = new LoginPojo();
		LoginDao loginDao = new LoginDao();
		switch (x) {
		case 1:
			System.out.println("Enter the firstName");
			String firstName = br.readLine();

			System.out.println("Enter the Last Name");
			String lastName = br.readLine();

			System.out.println("Enter the User Name");
			String userName = br.readLine();

			System.out.println("Enter the Password Name");
			String password = br.readLine();
			System.out.println("Enter the Email Name");
			String email = br.readLine();

			registerPojo.setFirstName(firstName);
			registerPojo.setLastName(lastName);
			registerPojo.setUserName(userName);
			registerPojo.setPassword(password);
			registerPojo.setEmail(email);
			
			registerDAO.addUser(registerPojo);
			break;
		case 2: 
			System.out.println("Enter the User Name");
			String name = br.readLine();

			System.out.println("Enter the Password Name");
			String pass = br.readLine();
			loginPojo.setUserName(name);
			loginPojo.setPassword(pass);
			
			if(loginDao.validate(loginPojo) == true) {
				Luck luck = new Luck();
				luck.display();
			}else {
				System.out.println("Incorrect username and Password");
			}
			break;
		}
	}
}

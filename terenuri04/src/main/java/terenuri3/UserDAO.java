package terenuri3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import terenuri3.Database;

public class UserDAO {
	private User user;

	public UserDAO(User user) {
		super();
		this.user = user;
	}
	 
	
	/**
	 * Cauta in baza de date locala daca gaseste userul dupa email (username)
	 * in caz de succes intoarce ID, insucces intoarce null
	 * @throws ClassNotFoundException */
	public static User getUserByUsername(User userCautat) throws SQLException, IOException, ClassNotFoundException{
		
		Connection theDbConnection = terenuri3.Database.getTheDbConnection();
		User tmpUser;
		
		String sqlCaut = "SELECT * FROM user WHERE userName= '" + userCautat.getUsername() + "'";
		System.out.println(sqlCaut);
		PreparedStatement stmt = theDbConnection.prepareStatement(sqlCaut);
		ResultSet rs = stmt.executeQuery(sqlCaut);
		
		if (rs.next()) {
			/**
			 * Daca nu e null se recordsetul se plaseaza pe primul record
			 */
			tmpUser = new User(rs.getString("userName"), rs.getString("userPwd"));
			rs.close();
			stmt.close();		
			return tmpUser;
			
		}
		else {
			return null;
		}
	}
}

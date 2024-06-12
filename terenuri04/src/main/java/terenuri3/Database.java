package terenuri3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import terenuri3.Constante;
import java.util.Properties;

public class Database {
	private static Connection theDbConnection = null; // conexiune la baza de date

	public static Connection getTheDbConnection() throws SQLException, ClassNotFoundException, IOException {
		/**
		 * Trebuie sa furnizeze o conexiune deschisa spre db
		 */
		if (theDbConnection == null || theDbConnection.isClosed()) {
			doConnect();
		}
		return theDbConnection;
	}/*----------------------------------*/

	public static void setTheDbConnection(Connection theDbConnection) {
		Database.theDbConnection = theDbConnection;
	}/*----------------------------------*/

	public static void doConnect() throws SQLException, ClassNotFoundException,IOException {
		/** deschide conexiune pe locala theDbConnection */
		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		
		String url = properties.getProperty("jdbc.databaseName");
		String driver = properties.getProperty("jdbc.databaseDriver");
		String username = properties.getProperty("jdbc.databaseUserName");
		String password = properties.getProperty("jdbc.databaseUserPwd");
		String timeZone = properties.getProperty("jdbc.databaseTimeZone");
		
		Class.forName(driver);
		theDbConnection = DriverManager.getConnection(url + timeZone, username,	password);
		System.out.println("Trec prin doConnect");
	}/*----------------------------------*/

	public static void doClose() throws SQLException {
		theDbConnection.close();

	}/*----------------------------------*/

}/*----------------------------------*/

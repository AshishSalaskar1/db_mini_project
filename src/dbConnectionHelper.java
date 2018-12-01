import java.sql.*;
import javax.swing.*;


public class dbConnectionHelper {
	
	static Connection con=null;
	public static Connection Connect() throws
		 ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ashish","ashish98");
			return con;
			
		} catch (SQLException e) {
			System.out.println("Error in db connection establishment");
			e.printStackTrace();
			return con;
		}
	
		
	}
	
	

}

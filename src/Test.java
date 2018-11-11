import java.sql.*;
public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");  
		System.out.println("Registered");
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
			System.out.println("Connection Succesfull");
		
			
		} catch (SQLException e) {
			System.out.println("Error in db connection establishment");
			e.printStackTrace();
		
		}
	}

}

package jdbc;
import java.sql.*;

public class DBConnection {
	
	public Connection getDBConnection() throws Exception {
	         	// 1. loading the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2.connection establishment
				String url = "jdbc:mysql://localhost:3306/empd";
				String user = "root";
				String pwd = "root";
				Connection con = DriverManager.getConnection(url, user, pwd);
				
		        return con;
	}

}

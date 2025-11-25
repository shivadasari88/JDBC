package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
        // Do in eclipse project with add the database library(driver) in current project by adding external library
		// step 1 register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/person", 
			    "root", "password"
			);
		System.out.println("connection created");
	}
}

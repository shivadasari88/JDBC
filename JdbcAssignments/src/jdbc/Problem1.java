package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Problem1 {
public static void main(String[] args) throws Exception {
		
		// 1. loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2.connection establishment
	
		
		Connection con = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/practice_db", 
			    "root", "Shiva@123"
			);
		
		if (con != null)
			System.out.println("Connection Successful!");
		else
			System.out.println("Failed");
		
		// 3. create statement
		Statement st = con.createStatement();
		String query = "select * from employees where department = 'IT' AND salary < 60000";		//4. Execute and Processing results
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getString(2)+" "+rs.getString(4));
		}
		
		con.close();
		
	}
}

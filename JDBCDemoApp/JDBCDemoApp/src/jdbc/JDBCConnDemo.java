package jdbc;
import java.sql.*;

public class JDBCConnDemo {

	public static void main(String[] args) throws Exception {
		
		// 1. loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2.connection establishment
		String url = "jdbc:mysql://localhost:3306/empd";
		String user = "root";
		String pwd = "root";
		Connection con = DriverManager.getConnection(url, user, pwd);
		
		if (con != null)
			System.out.println("Connection Successful!");
		else
			System.out.println("Failed");
		
		// 3. create statement
		Statement st = con.createStatement();
		String query = "select * from employee";
		//4. Execute and Processing results
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(4));
		}
		
	}

}

package jdbc;
import java.sql.*;
public class AggregateDemo {

	public static void main(String[] args) throws Exception {
		
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
		
		if(con != null)
			System.out.println("Connection established");
		
		//Statement st = con.createStatement();
		// By default, JDBC result sets are forward-only, meaning these methods would throw an exception.
		Statement st = con.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY);
		        
		ResultSet rs = st.executeQuery("select count(*) from employee");
		
		while(rs.next()) {			
		System.out.println("No of employees: "+ rs.getInt(1));
		
		}
		
		if(rs.first())
			System.out.println(rs.getInt(1));
		
		if(rs.absolute(-1))
			System.out.println(rs.getInt(1));
		
		con.close();
		
	}

}

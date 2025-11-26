package jdbc;

import java.sql.*;
import java.util.Scanner;
public class PSTDemo {

	public static void main(String[] args) throws Exception{
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
		if(con != null)
			System.out.println("Connection established");
		
		Scanner scanner = new Scanner(System.in);
		
		String query = "insert into student (first_name, last_name) values (?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		
		System.out.println("Enter First Name");
		String fname = scanner.next();
		System.out.println("Enter Last Name");
		String lname = scanner.next();
		
		// setting PST
		pst.setString(1, fname);
		pst.setString(2, lname);
		
		pst.executeUpdate(); // 
		
		ResultSet rs = pst.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		con.close();
	}

}

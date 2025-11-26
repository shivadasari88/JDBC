package jdbc;

import java.sql.*;

public class JDBCCRUDDemo {

 public static void main(String[] args) throws Exception{
	
	 DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
		
		if(con != null)
			System.out.println("Connection established");
		
		Statement st = con.createStatement();
//		String iq = "insert into student values (6,'KL', 'Rahul'), (7,'Ravi','jadeja')";
//		int x = st.executeUpdate(iq);
//		System.out.println(x+" record(s) inserted");
		
		String uq = "update student set first_name ='mahi' where sid = 5";
		int y = st.executeUpdate(uq);
		System.out.println(y+" record(s) updated");
		
		String dq = "delete from student where first_name like '%t' ";
		int z = st.executeUpdate(dq);
		System.out.println(z+" record(s) deleted");
		
		ResultSet rs = st.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		
		con.close();
}
	
}

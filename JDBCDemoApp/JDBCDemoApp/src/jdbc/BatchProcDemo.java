package jdbc;
import java.sql.*;

public class BatchProcDemo {
	
	public static void main(String[] args) throws Exception{
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
		if(con != null)
			System.out.println("Connection established");
		Statement st = con.createStatement();
		String iq = "insert into student values (10,'Virat', 'Kohli'), (11,'Rohit','Sharma')";
		st.addBatch(iq);
		
		String uq = "update student set first_name ='mahendra' where sid = 5";
		st.addBatch(uq);
		
		String dq = "delete from student where first_name like 'a%' ";
		st.addBatch(dq);
		
	   int[] x = st.executeBatch(); //  
	   for(int i:x)
		   System.out.print(i+" ");
	   
	   System.out.println();
	   ResultSet rs = st.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
	}

}

 // 'or '1'='1

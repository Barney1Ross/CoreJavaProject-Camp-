package come.jdc.connect.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeletionOfTables {

	public static void main(String[] args) {
		Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	                 .getConnection("jdbc:postgresql://localhost:5432/test",
	                         "postgres", "1234");

	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully!!");

	         stmt = c.createStatement();
	         String sql = "delete from feereport_student where roll_no = 290;";
	         stmt.executeUpdate(sql);
	         c.commit();

	         ResultSet rs = stmt.executeQuery( "select * from feereport_student;" );
	         while ( rs.next() ) {
	        	 int roll = rs.getInt("roll_no");
					String name = rs.getString("name");
					String branch = rs.getString("brach");
					int fee_paid = rs.getInt("fee_paid");
					int dues = rs.getInt("dues");
					String email = rs.getString("email_id");
					String addr = rs.getString("address");
					
					System.out.println("Roll number ::	"+ roll);
					System.out.println("Name        :: 	"+name);
					System.out.println("Branch		::  "+branch);
					System.out.println("Fee_paid	::  "+fee_paid);
					System.out.println("Dues		::  "+dues);
					System.out.println("email		::  "+email);
					System.out.println("Address		::  "+addr);
					System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("The record has been deleted as requested.");
	}

}

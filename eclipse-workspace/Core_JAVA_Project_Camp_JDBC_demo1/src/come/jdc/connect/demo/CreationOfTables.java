package come.jdc.connect.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreationOfTables {

	public static void main(String[] args) {
		Connection c = null;
		Statement stm = null;
		try {
			//Step 1 - loading the driver class
			Class.forName("org.postgresql.Driver");
			//Step 2 - getting the connection
			c= DriverManager
			   .getConnection("jdbc:postgresql://localhost:5432/sample",
				"postgres","1234");
			System.out.println("Database fetched successfully!!");
			
			//Step 3 - creating the statement object
			stm = c.createStatement();
			//Step 4 - Creating query string
			String sql = "create table feereport_student"+
			"(Roll_No int primary key 	not null,"+
			" Name 			     text	not null,"+
			"Brach    			 text 	not null,"+
			"Fee_paid   		 int,"+
			"Dues    			 int,"+
			"Email_ID            text	not null,"+
			"Address  			 char(50))";
			
			
			//Step 5 - execute the statement
			stm.executeUpdate(sql);
			//step 6 - closing the stm and closing driver class
			stm.close();
			c.close();
		}catch(Exception e) {
			System.err.println(e.getClass().getName()+":: "+e.getMessage());
			System.exit(0);
		}
		System.out.println("Tables created Successfully!!!");
	}

}

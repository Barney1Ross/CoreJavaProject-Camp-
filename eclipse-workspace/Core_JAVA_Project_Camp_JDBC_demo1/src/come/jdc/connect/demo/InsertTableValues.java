package come.jdc.connect.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTableValues {

	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		try {

			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "1234");
			c.setAutoCommit(false);
			System.out.println("Databases fetched successfully");

			stmt = c.createStatement();
			String sql = "insert into feereport_student (Roll_No, Name, Brach, Fee_paid, Dues, Email_ID, Address )"+
						  "values (265, 'Ralph', 'CSE', 219000, 0, 'ralph@mail.com', 'Churchill Gate, Sector 5, RJS')";
			stmt.executeUpdate(sql);
			
			sql = "insert into feereport_student (Roll_No, Name, Brach, Fee_paid, Dues, Email_ID, Address )"+
					"values (290, 'Don', 'CSE', 210000, 9000, 'don@mail.com', 'Rose Park, Sector 45, KJS')";
			stmt.executeUpdate(sql);
			
			sql = "insert into feereport_student (Roll_No, Name, Brach, Fee_paid, Dues, Email_ID, Address )"+
					"values (305, 'Leo', 'EEE', 200000, 0, 'leo@mail.com', 'Watson colony RJS')";
			stmt.executeUpdate(sql);		
			
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + " :: " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully!!");
	}

}

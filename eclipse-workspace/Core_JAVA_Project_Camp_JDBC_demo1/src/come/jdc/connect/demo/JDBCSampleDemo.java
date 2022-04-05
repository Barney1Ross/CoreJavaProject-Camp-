package come.jdc.connect.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCSampleDemo {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Connection c = null;
		try {
			//step 1 load the driver class
			Class.forName("org.postgresql.Driver");
			//driver name for mysql
			//Class.forName("com.mysql.jdbc.Driver");
			
			// step 2 - getting connection
			c= DriverManager
			   .getConnection("jdbc:postgresql://localhost:5432/test",
				"postgres","1234");
			System.out.println("Connection Status :: Successful");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getClass().getName()+" :: "+e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

}

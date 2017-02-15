package testJlitle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainLitle {

	public static void main(String[] args) {
		Connection c = null;

	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      
	      String sql = "CREATE TABLE COMPANY " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " NAME           TEXT    NOT NULL, " + 
	                   " AGE            INT     NOT NULL, " + 
	                   " ADDRESS        CHAR(50), " + 
	                   " SALARY         REAL)"; 
	      
	      sendRqt(c, sql);
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	}
	
	public static void sendRqt(Connection c,String rqt)
	{
	    Statement stmt = null;
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(rqt);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void sendRqtSelect(Connection c, String rqt)
	{
		Statement stmt=null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM table;" );
			
			while ( rs.next() ) {
				int id = rs.getInt("id");
			}
			
			rs.close();
		    stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}

package assign_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting up...");
		GUI frame = null;

		//Connect to database
        try {
        	
        	// load the sqlite-JDBC driver using the current class loader
        	Class.forName("org.sqlite.JDBC");
        	
        	//HARD CODED DATABASE NAME:
			Connection database = DriverManager.getConnection("jdbc:sqlite:ironNorth");
			//create a statement object
			Statement stat = database.createStatement();
			
			String sqlQueryString = "select * from clients;";
            System.out.println(sqlQueryString);
            
            sqlQueryString = "select * from classes;";
            System.out.println(sqlQueryString);
			
            
            
            //frame =  new GUI("Iron North", database, stat);
            
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

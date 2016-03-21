package assign_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting up...");
		GUI frame = null;

		//Connect to database
        try {
        	
        	// load the sqlite-JDBC driver using the current class loader
        	Class.forName("org.sqlite.JDBC");
        	
        	//HARD CODED DATABASE NAME:
			Connection database = DriverManager.getConnection("jdbc:sqlite:ironNorth.db");
			//create a statement object
			Statement stat = database.createStatement();
			
			// get the clients
			String sqlQueryString = "select * from clients;";
            System.out.println(sqlQueryString);
            
            ArrayList<Users> clients = new ArrayList<Users>();
            
            ResultSet rs = stat.executeQuery(sqlQueryString);
	        while (rs.next()) {
	        	// (String name, String phone, String email, String address, String gender, String referralSource)
	        	Users user = new Users(rs.getString("name"), rs.getString("phone"), rs.getString("cEmail"), rs.getString("address"), rs.getString("gender"), rs.getString("referralSource")); 
	        	clients.add(user);
	        }
	        rs.close(); //close the query result table
            
            // get the staff
            sqlQueryString = "select * from staff;";
            System.out.println(sqlQueryString);
            
            ArrayList<Users> staff = new ArrayList<Users>();
            
            rs = stat.executeQuery(sqlQueryString);
	        while (rs.next()) {
	        	// (String name, String phone, String email, String address, String instructorType)
	        	Users user = new Users(rs.getString("name"), rs.getString("phone"), rs.getString("sEmail"), rs.getString("address"), rs.getString("instructorType")); 
	        	staff.add(user);
	        }
	        rs.close(); //close the query result table
            
            // get the classes
            sqlQueryString = "select * from classes;";
            System.out.println(sqlQueryString);
            
            ArrayList<Classes> classes = new ArrayList<Classes>();
            
            rs = stat.executeQuery(sqlQueryString);
	        while (rs.next()) {
	        	// (String staffEmail, String className, int currentSize, int maxSize, String classType, String dateTime)
	        	Classes cls = new Classes(rs.getInt("classID"), rs.getString("sEmail"), rs.getString("className"), rs.getInt("currentSize"), rs.getInt("maxSize"), rs.getString("classType"), rs.getString("dt"));
	        	classes.add(cls);
	        }
	        rs.close(); //close the query result table
            
            frame =  new GUI("Iron North Fitness", database, stat, clients, staff, classes);
            
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        //make GUI visible
		frame.setVisible(true);
	}
}

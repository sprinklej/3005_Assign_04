package assign_04;

//import java.sql.SQLException;
//import java_sqlite_3005.GUI;

public class Main {

	public static void main(String[] args) {
		//GUI frame = null;

		//Connect to database
        try {
        	// load the sqlite-JDBC driver using the current class loader
        	Class.forName("org.sqlite.JDBC");
        	
        	
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		//} catch (SQLException e) {
		//	e.printStackTrace();
		}
	}

}

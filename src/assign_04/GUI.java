package assign_04;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;

public class GUI extends JFrame implements DialogClient {
	
	Connection databaseConnection;
	Statement stat;
	
	ArrayList<Users> clientList = new ArrayList<Users>();
	ArrayList<Users> staffList = new ArrayList<Users>();
	ArrayList<Classes> classList = new ArrayList<Classes>();
	
	private Users selectedUser;    // User currently selected in the GUI list
	private Classes selectedClass; // class currently selected in the GUI list
	
	// Store the view that contains the components
	ListPanel view; //panel of GUI components for the main window
	GUI thisFrame;
	
	// Here are the component listeners
	//TODO
	
	//default constructor
	public GUI(String title, Connection aDB, Statement aStatement, ArrayList<Users> clients, ArrayList<Users> staff, ArrayList<Classes> classes) {
		super(title);
		databaseConnection = aDB;
		stat = aStatement;
		clientList = clients;
		staffList = staff;
		classList = classes;
		selectedUser = null;
		selectedClass = null;
		thisFrame = thisFrame;
				
		// window listener
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						try {
							System.out.println("Closing Database Connection");
							databaseConnection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						System.exit(0);
					}
				}
				);
		
		
		// Make the main window view panel
		add(view = new ListPanel());
		
		// listeners
		//TODO
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,600);
		
		// Start off with everything updated properly to reflect the model state
		update();
	}
	
	// Enable all listeners
	private void enableListeners() {
		//TODO
	}
	
	// Disable all listeners
	private void disableListeners() {
		//TODO
	}
	
	// Update the list
	private void updateLists() {
		//clients
		Users clientArray[] = new Users[1];
		view.getClientList().setListData(clientList.toArray(clientArray));
	}
	
	// Update the components
	private void update() {
		updateLists();
		//TODO
	}
	
	//@Override
	//public void dialogFinished(DialogClient.operation requestedOperation) {
		//TODO
	//}
	
	//@Override
	//public void dialogCancelled() {
		//TODO
		//update();
	//}
}

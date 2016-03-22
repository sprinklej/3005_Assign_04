package assign_04;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	ListSelectionListener classListSelectionListener;
	ActionListener addClientListener;
	ActionListener addStaffListener;
	ActionListener addClassListener;
	ActionListener joinClassListener;
	ActionListener addRefreshListener;
	MouseListener  doubleClickClientsListener;
	MouseListener  doubleClickStaffListener;
	MouseListener  doubleClickClassesListener;
	
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
		thisFrame = this;
				
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
		// Add a listener to allow selection of buddies from the list
		classListSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) { 
					selectClass();
				}
			}
		};
					
		// add a client button listener
		addClientListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addClient();
			}
		};
		
		// add a client button listener
		addStaffListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addStaff();
			}
		};
			
		// add a class button listener
		addClassListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addClass();
			}
		};
		
		joinClassListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				joinClass();
			}
		};
		
		// add a client button listener
		addRefreshListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Clicked on: refresh");
				update();
			}
		};
			
		// add a double click listener to the user list
		doubleClickClientsListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					JList<Users> theList = (JList<Users>) event.getSource();
					int index = theList.locationToIndex(event.getPoint());
					selectedUser = (Users) theList.getModel().getElementAt(index);
					System.out.println("Double Clicked on: " + selectedUser);
					
					UserDetailsDialog dialog = new UserDetailsDialog(thisFrame, thisFrame, "Client Details Dialog", true, selectedUser, false);
					dialog.setVisible(true);
				}
			}
		};
		
		// add a double click listener to the staff list
		doubleClickStaffListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					JList<Users> theList = (JList<Users>) event.getSource();
					int index = theList.locationToIndex(event.getPoint());
					selectedUser = (Users) theList.getModel().getElementAt(index);
					System.out.println("Double Clicked on: " + selectedUser);
					
					UserDetailsDialog dialog = new UserDetailsDialog(thisFrame, thisFrame, "Staff Details Dialog", true, selectedUser, true);
					dialog.setVisible(true);
				}
			}
		};
		
		// add a double click listener to the class list
		doubleClickClassesListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					JList<Classes> theList = (JList<Classes>) event.getSource();
					int index = theList.locationToIndex(event.getPoint());
					selectedClass = (Classes) theList.getModel().getElementAt(index);
					System.out.println("Double Clicked on: " + selectedClass);
					
					ClassDetailsDialog dialog = new ClassDetailsDialog(thisFrame, thisFrame, "Class Details Dialog", true, selectedClass);
					dialog.setVisible(true);
				}
			}
		};
		
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(825,600);
		
		// Start off with everything updated properly to reflect the model state
		update();
	}
	
	// Enable all listeners
	private void enableListeners() {
		view.getClassList().addListSelectionListener(classListSelectionListener);
		view.getAddClientButton().addActionListener(addClientListener);
		view.getAddStaffButton().addActionListener(addStaffListener);
		view.getAddClassButton().addActionListener(addClassListener);
		view.getAddJoinClassButton().addActionListener(joinClassListener);
		view.getAddRefreshButton().addActionListener(addRefreshListener);
		view.getClientList().addMouseListener(doubleClickClientsListener);
		view.getStaffList().addMouseListener(doubleClickStaffListener);
		view.getClassList().addMouseListener(doubleClickClassesListener);
	}
	
	// Disable all listeners
	private void disableListeners() {
		view.getClassList().removeListSelectionListener(classListSelectionListener);
		view.getAddClientButton().removeActionListener(addClientListener);
		view.getAddStaffButton().removeActionListener(addStaffListener);
		view.getAddClassButton().removeActionListener(addClassListener);
		view.getAddJoinClassButton().removeActionListener(joinClassListener);
		view.getAddRefreshButton().removeActionListener(addRefreshListener);
		view.getClientList().removeMouseListener(doubleClickClientsListener);
		view.getStaffList().removeMouseListener(doubleClickStaffListener);
		view.getClassList().removeMouseListener(doubleClickClassesListener);
	}
	
	private void selectClass() {
		selectedClass = (Classes)(view.getClassList().getSelectedValue());
		System.out.println("Class Selected: " + selectedClass);
	}
	
	// add a new client
	private void addClient() {
		System.out.println("Clicked on: add client");
		selectedUser = new Users(-1, "", "", "", "", "", "");
		UserDetailsDialog dialog = new UserDetailsDialog(thisFrame, thisFrame, "Client Details Dialog", true, selectedUser, false);
		dialog.setVisible(true);
		update();
	}
	
	// add a new Staff
	private void addStaff() {
		System.out.println("Clicked on: add staff");
		selectedUser = new Users(-1, "", "", "", "", "");
		UserDetailsDialog dialog = new UserDetailsDialog(thisFrame, thisFrame, "Client Details Dialog", true, selectedUser, true);
		dialog.setVisible(true);
		update();
	}
	
	// add a new class
	private void addClass() {
		System.out.println("Clicked on: add class");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		selectedClass = new Classes(-1, "", "", 0, 0, "", dateFormat.format(date));
		ClassDetailsDialog dialog = new ClassDetailsDialog(thisFrame, thisFrame, "Class Details Dialog", true, selectedClass);
		dialog.setVisible(true);
		update();
	}
	
	// have a client join a class
	private void joinClass() {
		System.out.println("Clicked on: join class");
		System.out.println("Current class Selected: " + selectedClass);
		
		if(selectedClass == null) {
			System.out.println("no class selected");
			return;
		}
		
		selectedUser = new Users(-1, "", "", "", "", "", "");
		JoinClassDetailsDialog dialog = new JoinClassDetailsDialog(thisFrame, thisFrame, "Joina a class", true, selectedUser);
		dialog.setVisible(true);
		updateLists();
	}
	
	// Update the visible lists
	private void updateLists() {
		// clients
		Users clientArray[] = new Users[1];
		view.getClientList().setListData(clientList.toArray(clientArray));
		
		// classes
		Classes classesArray[] = new Classes[1];
		view.getClassList().setListData(classList.toArray(classesArray));
		
		// staff
		Users staffArray[] = new Users[1];
		view.getStaffList().setListData(staffList.toArray(staffArray));
		
		
	}
	
	// re-generate the lists -done after adding to/updating/deleting from the lists
	private void generateLists() {
		// client list
		String sqlString = "SELECT * FROM clients ORDER BY name ASC;";
		try {
			clientList.clear();
			ResultSet rs = stat.executeQuery(sqlString);
	        while (rs.next()) {
	        	Users user = new Users(rs.getInt("clientID"), rs.getString("name"), rs.getString("phone"), rs.getString("cEmail"), rs.getString("address"), rs.getString("gender"), rs.getString("referralSource")); 
	        	clientList.add(user);
	        }
	        rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// staff list
		sqlString = "SELECT * FROM staff ORDER BY name ASC;";
		try {
			staffList.clear();
			ResultSet rs = stat.executeQuery(sqlString);
	        while (rs.next()) {
	        	Users user = new Users(rs.getInt("staffID"), rs.getString("name"), rs.getString("phone"), rs.getString("sEmail"), rs.getString("address"), rs.getString("instructorType")); 
	        	staffList.add(user);
	        }
	        rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// class list
		sqlString = "SELECT * FROM classes ORDER BY dt ASC;";
		try {
			classList.clear();
			ResultSet rs = stat.executeQuery(sqlString);
			while (rs.next()) {
				Classes cls = new Classes(rs.getInt("classID"), rs.getString("sEmail"), rs.getString("className"), rs.getInt("currentSize"), rs.getInt("maxSize"), rs.getString("classType"), rs.getString("dt"));
				classList.add(cls);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	// Update the components
	private void update() {
		disableListeners();
		generateLists();
		updateLists();
		enableListeners();
	}

	@Override //USER DIALOG
	public void dialogFinished(DialogClient.operation requestedOperation) {
		String sqlString;
		
		if(requestedOperation == DialogClient.operation.UPDATE) { // update a user
			System.out.println("UPDATE: " + selectedUser);
			
			if (selectedUser.getStaffTF() == true) { // update/add a new staff member
				if ((selectedUser.getName().equals("")) || (selectedUser.getPhone().equals("")) || (selectedUser.getEmail().equals(""))
						|| (selectedUser.getAddress().equals("")) || (selectedUser.getInstructorType().equals(""))) {
					System.out.println("Empty field: user not updated");
					update();
					return;
				}
				 // new staffer
				if(selectedUser.getID() == -1) {
					sqlString = "INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('"
							+ selectedUser.getName().replaceAll("'", "''") + "', '"
							+ selectedUser.getPhone().replaceAll("'", "''") + "', '"
							+ selectedUser.getEmail().replaceAll("'", "''") + "', '"
							+ selectedUser.getAddress().replaceAll("'", "''") + "', '"
							+ selectedUser.getInstructorType().replaceAll("'", "''") + "');";
				} else { // update staffer
					sqlString = "UPDATE staff SET name = '" + selectedUser.getName().replaceAll("'", "''") 
						+ "', phone = '" + selectedUser.getPhone().replaceAll("'", "''")
						+ "', sEmail = '" + selectedUser.getEmail().replaceAll("'", "''")
						+ "', address = '" + selectedUser.getAddress().replaceAll("'", "''")
						+ "', instructorType = '" + selectedUser.getInstructorType().replaceAll("'", "''") 
						+ "' WHERE staffID = " + selectedUser.getID() + ";";
				}
				try {
					stat.executeUpdate(sqlString);
				} catch (SQLException e) {
					System.out.println("Failed to update/add: " + selectedUser);
				}
				
			} else { // update/add a new client
				if ((selectedUser.getName().equals("")) || (selectedUser.getPhone().equals("")) || (selectedUser.getEmail().equals(""))
						|| (selectedUser.getAddress().equals("")) || (selectedUser.getGender().equals(""))) {
					System.out.println("Empty field: user not updated");
					update();
					return;
				}
				// new client
				if(selectedUser.getID() == -1) {
					sqlString = "INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('"
							+ selectedUser.getName().replaceAll("'", "''") + "', '"
							+ selectedUser.getPhone().replaceAll("'", "''") + "', '"
							+ selectedUser.getEmail().replaceAll("'", "''") + "', '"
							+ selectedUser.getAddress().replaceAll("'", "''") + "', '"
							+ selectedUser.getGender().replaceAll("'", "''") + "', '"
							+ selectedUser.getReferralSource().replaceAll("'", "''") + "');";
				} else { // update client
					sqlString = "UPDATE clients SET name = '" + selectedUser.getName().replaceAll("'", "''") 
							+ "', phone = '" + selectedUser.getPhone().replaceAll("'", "''")
							+ "', cEmail = '" + selectedUser.getEmail().replaceAll("'", "''")
							+ "', address = '" + selectedUser.getAddress().replaceAll("'", "''")
							+ "', gender = '" + selectedUser.getGender().replaceAll("'", "''") 
							+ "', referralSource = '" + selectedUser.getReferralSource().replaceAll("'", "''") 
							+ "' WHERE clientID = " + selectedUser.getID() + ";";
				}
				try {
					stat.executeUpdate(sqlString);
				} catch (SQLException e) {
					System.out.println("Failed to update/add: " + selectedUser);
				}
			}
			
			selectedUser = null; 
		} else if(requestedOperation == DialogClient.operation.DELETE) { // delete a user
			System.out.println("DELETE: " + selectedUser);
			
			if (selectedUser.getStaffTF() == true) { // delete a staff
				sqlString = "DELETE FROM staff WHERE staffID = " + selectedUser.getID() + ";";
			} else { // delete a client
				sqlString = "DELETE FROM clients WHERE clientID = " + selectedUser.getID() + ";";
			}
			try {
				stat.executeUpdate(sqlString);
			} catch (SQLException e) {
				System.out.println("Failed to delete: " + selectedUser);
			}

// TODO - delete from classes_clients
// TODO - decrement the class count
// TODO - if instructor - remove all the classes that they teach
			
			selectedUser = null; 
		} 
		update();
	}

	@Override //CLASS DIALOG
	public void classDialogFinished(DialogClient.operation requestedOperation) {
		String sqlString;
		
		if(requestedOperation == DialogClient.operation.UPDATE) { // update a class
			System.out.println("UPDATE");

			if ((selectedClass.getStaffEmail().equals("")) || (selectedClass.getClassName().equals("")) || (selectedClass.getCurrentSize() == -1)
					|| (selectedClass.getMaxSize() == -1) || (selectedClass.getClassType().equals("")) || (selectedClass.getDateTime().equals(""))) {
				System.out.println("Empty field: user not updated");
				update();
				return;
			}
		
			// new class
			if(selectedClass.getID() == -1) {
				sqlString = "INSERT INTO classes(sEmail, className, currentSize, maxSize, classType, dt) VALUES ('"
						+ selectedClass.getStaffEmail().replaceAll("'", "''") + "', '"
						+ selectedClass.getClassName().replaceAll("'", "''") + "', "
						+ selectedClass.getCurrentSize() + ", "
						+ selectedClass.getMaxSize() + ", '"
						+ selectedClass.getClassType().replaceAll("'", "''") + "', '"
						+ selectedClass.getDateTime().replaceAll("'", "''") + "');";
			} else { // update class
				sqlString = "UPDATE classes SET sEmail = '" + selectedClass.getStaffEmail().replaceAll("'", "''")
						+ "', className = '" + selectedClass.getClassName().replaceAll("'", "''")
						+ "', currentSize = " + selectedClass.getCurrentSize()
						+ ", maxSize = " + selectedClass.getMaxSize()
						+ ", classType = '" + selectedClass.getClassType().replaceAll("'", "''")
						+ "', dt = '" + selectedClass.getDateTime().replaceAll("'", "''")
						+ "' WHERE classID = " + selectedClass.getID() + ";";
			}
			try {
				stat.executeUpdate(sqlString);
			} catch (SQLException e) {
				System.out.println("Failed to update/add: " + selectedClass);
			}
			
			selectedClass = null;
		} else if(requestedOperation == DialogClient.operation.DELETE) { // delete a class
			System.out.println("DELETE: " + selectedClass);
			
			// delete the class
			sqlString = "DELETE FROM classes WHERE classID = " + selectedClass.getID() + ";";
			try {
				stat.executeUpdate(sqlString);
			} catch (SQLException e) {
				System.out.println("Failed to delete: " + selectedClass);
			}	
			
			// remove everyone enrolled in the class
			sqlString = "DELETE FROM classes_clients WHERE classID = " + selectedClass.getID() + ";";
			try {
				stat.executeUpdate(sqlString);
			} catch (SQLException e) {
				System.out.println("Failed to delete: " + selectedClass);
			}	
			
			selectedClass = null;
		}
		update();
	}
	
	@Override
	public void joinDialogFinished() {
		String sqlString;
		
		sqlString = "SELECT clientID FROM clients WHERE cEmail = '" + selectedUser.getEmail() + "';";
		System.out.println(sqlString);
		update();
	}
	
	
	@Override
	public void dialogCancelled() {
		selectedUser = null;    // User currently selected in the GUI list
		selectedClass = null;
		update();
	}
}

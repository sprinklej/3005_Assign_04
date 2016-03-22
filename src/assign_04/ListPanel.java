package assign_04;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ListPanel extends JPanel {
	
	// Components
	private JButton	addClientButton;
	private JButton	addStaffButton;
	private JButton	addClassButton;
	private JButton addJoinClassButton;
	private JButton	addRefreshButton;
	
	private JLabel lblClientList;
	private JLabel lblStaffList;
	private JLabel lblClasses;
	
	private JList<Users> clientList;
	private JList<Users> staffList;
	private JList<Classes> classList;
	
	private Font UIFont = new Font("Courier New", Font.BOLD, 16);
	private GridBagConstraints gbc_scrollPane_1_1_1;
	private GridBagConstraints gbc_scrollPane_1_1_1_2;

	
	
	// These are the get methods that are used to access the components
	public JButton getAddClientButton() {
		return addClientButton;
	}
	
	public JButton getAddStaffButton() {
		return addStaffButton;
	}
	
	public JButton getAddClassButton() {
		return addClassButton;
	}
	
	public JButton getAddJoinClassButton() {
		return addJoinClassButton;
	}
	
	public JButton getAddRefreshButton() {
		return addRefreshButton;
	}
	
	public JList<Users> getClientList() {
		return clientList;
	}
	
	public JList<Users> getStaffList() {
		return staffList;
	}
	
	public JList<Classes> getClassList() {
		return classList;
	}

	// Default constructor
	public ListPanel() {
		super();
		
		// Use a GridBagLayout (lots'a fun)
		GridBagLayout layout = new GridBagLayout();
		layout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		layout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		setLayout(layout);
								
										
										// Add the classList
										classList = new JList<Classes>();
										classList.setFont(UIFont);
										//15, 0, 0, 12, 16
										classList.setPrototypeCellValue(new Classes("***************", 0, 0, "************", "****************"));
										
										// Add the clientList
										clientList = new JList<Users>();
										clientList.setFont(UIFont);
										// 20 30
										clientList.setPrototypeCellValue(new Users("********************", 
												"******************************"));
										
										// client label
										lblClientList = new JLabel("Clients");
										GridBagConstraints gbc_lblClientList = new GridBagConstraints();
										gbc_lblClientList.anchor = GridBagConstraints.WEST;
										gbc_lblClientList.insets = new Insets(0, 10, 5, 5);
										gbc_lblClientList.gridx = 0;
										gbc_lblClientList.gridy = 0;
										add(lblClientList, gbc_lblClientList);
										
										// class label
										lblClasses = new JLabel("Classes");
										GridBagConstraints gbc_lblClasses = new GridBagConstraints();
										gbc_lblClasses.anchor = GridBagConstraints.WEST;
										gbc_lblClasses.insets = new Insets(0, 10, 5, 5);
										gbc_lblClasses.gridx = 2;
										gbc_lblClasses.gridy = 0;
										add(lblClasses, gbc_lblClasses);
										
										// client list
										JScrollPane scrollPane = new JScrollPane(clientList,
												ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
												ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
										GridBagConstraints gbc_scrollPane_1_1_1_1 = new GridBagConstraints();
										gbc_scrollPane_1_1_1_1.gridwidth = 2;
										gbc_scrollPane_1_1_1_1.fill = GridBagConstraints.BOTH; //VERTICAL
										gbc_scrollPane_1_1_1_1.anchor = GridBagConstraints.WEST;
										gbc_scrollPane_1_1_1_1.weighty = 1.0;
										gbc_scrollPane_1_1_1_1.weightx = 1.5;
										gbc_scrollPane_1_1_1_1.gridheight = 3;
										gbc_scrollPane_1_1_1_1.insets = new Insets(0, 10, 10, 10);
										gbc_scrollPane_1_1_1_1.gridx = 0;
										gbc_scrollPane_1_1_1_1.gridy = 1;
										add(scrollPane, gbc_scrollPane_1_1_1_1);
										
										// class list
										scrollPane = new JScrollPane(classList,
												ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
												ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
										gbc_scrollPane_1_1_1_2 = new GridBagConstraints();
										gbc_scrollPane_1_1_1_2.fill = GridBagConstraints.BOTH; //vertical
										gbc_scrollPane_1_1_1_2.insets = new Insets(0, 10, 10, 10);
										gbc_scrollPane_1_1_1_2.gridwidth = 5;
										gbc_scrollPane_1_1_1_2.anchor = GridBagConstraints.WEST;
										gbc_scrollPane_1_1_1_2.weighty = 1.0;
										gbc_scrollPane_1_1_1_2.weightx = 1.0;
										gbc_scrollPane_1_1_1_2.gridheight = 6;
										gbc_scrollPane_1_1_1_2.gridx = 2;
										gbc_scrollPane_1_1_1_2.gridy = 1;
										add(scrollPane, gbc_scrollPane_1_1_1_2);
										
										// Add the staffList
										staffList = new JList<Users>();
										staffList.setFont(UIFont);
										// 20 30
										staffList.setPrototypeCellValue(new Users("********************", 
												"******************************"));
										
										// staff label
										lblStaffList = new JLabel("Staff");
										GridBagConstraints gbc_lblStaffList = new GridBagConstraints();
										gbc_lblStaffList.anchor = GridBagConstraints.WEST;
										gbc_lblStaffList.insets = new Insets(0, 10, 5, 5);
										gbc_lblStaffList.gridx = 0;
										gbc_lblStaffList.gridy = 4;
										add(lblStaffList, gbc_lblStaffList);
										
										// staff list
										scrollPane = new JScrollPane(staffList,
												ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
												ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
										gbc_scrollPane_1_1_1 = new GridBagConstraints();
										gbc_scrollPane_1_1_1.gridwidth = 2;
										gbc_scrollPane_1_1_1.fill = GridBagConstraints.BOTH; //vertical
										gbc_scrollPane_1_1_1.anchor = GridBagConstraints.WEST;
										gbc_scrollPane_1_1_1.weighty = 1.0;
										gbc_scrollPane_1_1_1.weightx = 1.5;
										gbc_scrollPane_1_1_1.gridheight = 2;
										gbc_scrollPane_1_1_1.insets = new Insets(0, 10, 10, 10);
										gbc_scrollPane_1_1_1.gridx = 0;
										gbc_scrollPane_1_1_1.gridy = 5;
										add(scrollPane, gbc_scrollPane_1_1_1);
										
												
												// Add the addClient button
												addClientButton = new JButton("Add client");
												GridBagConstraints gbc_addClientButton = new GridBagConstraints();
												gbc_addClientButton.anchor = GridBagConstraints.NORTHWEST;
												gbc_addClientButton.insets = new Insets(0, 0, 0, 5);
												gbc_addClientButton.gridx = 2;
												gbc_addClientButton.gridy = 7;
												add(addClientButton, gbc_addClientButton);
										
										// Add the addStaff button
										addStaffButton = new JButton("Add Staff");
										GridBagConstraints gbc_addStaffButton = new GridBagConstraints();
										gbc_addStaffButton.anchor = GridBagConstraints.NORTHWEST;
										gbc_addStaffButton.insets = new Insets(0, 0, 0, 5);
										gbc_addStaffButton.gridx = 3;
										gbc_addStaffButton.gridy = 7;
										add(addStaffButton, gbc_addStaffButton);
										
										// Add the class button
										addClassButton = new JButton("Add Class");
										GridBagConstraints gbc_addClassButton = new GridBagConstraints();
										gbc_addClassButton.anchor = GridBagConstraints.NORTHWEST;
										gbc_addClassButton.insets = new Insets(0, 0, 0, 5);
										gbc_addClassButton.gridx = 4;
										gbc_addClassButton.gridy = 7;
										add(addClassButton, gbc_addClassButton);
										
										// add the join class button
										addJoinClassButton = new JButton("Join Class");
										GridBagConstraints gbc_btnJoinClass = new GridBagConstraints();
										gbc_btnJoinClass.insets = new Insets(0, 0, 0, 5);
										gbc_btnJoinClass.gridx = 5;
										gbc_btnJoinClass.gridy = 7;
										add(addJoinClassButton, gbc_btnJoinClass);
										
										// Add the refresh button
										addRefreshButton = new JButton("Refresh");
										GridBagConstraints gbc_addRefreshButton = new GridBagConstraints();
										gbc_addRefreshButton.anchor = GridBagConstraints.NORTHWEST;
										gbc_addRefreshButton.gridx = 6;
										gbc_addRefreshButton.gridy = 7;
										add(addRefreshButton, gbc_addRefreshButton);
		
	}
	
	/*
	 // Default constructor
	public ListPanel() {
		super();
		
		// Use a GridBagLayout (lots'a fun)
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		setLayout(layout);
					
		// Add the clientList
		clientList = new JList<Users>();
		clientList.setFont(UIFont);
		// 20 30
		clientList.setPrototypeCellValue(new Users("********************", 
				"******************************"));
		JScrollPane scrollPane = new JScrollPane(clientList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		layoutConstraints.gridx = 0; //1
		layoutConstraints.gridy = 0; //1
		layoutConstraints.gridwidth = 1; //2
		layoutConstraints.gridheight = 4; //4
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 0.9; //2.0
		layoutConstraints.weighty = 0.5;
		layout.setConstraints(scrollPane, layoutConstraints);
		add(scrollPane);

		//JLabel label1 = new JLabel("Image and Text");
		
		// Add the classList
		classList = new JList<Classes>();
		classList.setFont(UIFont);
		//15, 0, 0, 12, 16
		classList.setPrototypeCellValue(new Classes("***************", 0, 0, "************", "****************"));
		scrollPane = new JScrollPane(classList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 8;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 0.0;
		layout.setConstraints(scrollPane, layoutConstraints);
		add(scrollPane);
		
		// Add the staffList
		staffList = new JList<Users>();
		staffList.setFont(UIFont);
		// 20 30
		staffList.setPrototypeCellValue(new Users("********************", 
				"******************************"));
		scrollPane = new JScrollPane(staffList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		layoutConstraints.gridx = 0; //1
		layoutConstraints.gridy = 4; //1
		layoutConstraints.gridwidth = 1; //2
		layoutConstraints.gridheight = 4; //4
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.SOUTHWEST;
		layoutConstraints.weightx = 0.9; //2.0
		layoutConstraints.weighty = 0.5;
		layout.setConstraints(scrollPane, layoutConstraints); 
		add(scrollPane);

		
		// Add the addClient button
		addClientButton = new JButton("Add client");
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layoutConstraints.weightx = 0.0;
		layoutConstraints.weighty = 0.0;
		layout.setConstraints(addClientButton, layoutConstraints); 
		add(addClientButton);
		
		// Add the addStaff button
		addStaffButton = new JButton("Add Staff");
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 1;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layoutConstraints.weightx = 0.0;
		layoutConstraints.weighty = 0.0;
		layout.setConstraints(addStaffButton, layoutConstraints); 
		add(addStaffButton);
		
		// Add the class button
		addClassButton = new JButton("Add Class");
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 2;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layoutConstraints.weightx = 0.0;
		layoutConstraints.weighty = 0.0;
		layout.setConstraints(addClassButton, layoutConstraints); 
		add(addClassButton);
		
		// Add the refresh button
		addRefreshButton = new JButton("Refresh");
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 3;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layoutConstraints.weightx = 0.0;
		layoutConstraints.weighty = 0.0;
		layout.setConstraints(addRefreshButton, layoutConstraints);
		add(addRefreshButton);
		
	}
	 
	 */
}

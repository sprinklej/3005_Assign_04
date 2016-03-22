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

public class ListPanel extends JPanel {
	
	// Components
	private JButton	addClientButton;
	private JButton	addStaffButton;
	private JButton	addClassButton;
	private JButton	addRefreshButton;
	private JList<Users> clientList;
	private JList<Users> staffList;
	private JList<Classes> classList;
	
	private Font UIFont = new Font("Courier New", Font.BOLD, 16);
	
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
}

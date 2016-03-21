package assign_04;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ListPanel extends JPanel {
	
	// Components
	private JButton	addClientButton;
	private JButton	addClassButton;
	private JList<Users> clientList;
	private JList<Users> staffList;
	private JList<Classes> classList;
	
	private Font UIFont = new Font("Courier New", Font.BOLD, 16);
	
	// These are the get methods that are used to access the components
	public JButton getAddClientButton() {
		return addClientButton;
	}
	
	public JButton getAddClassButton() {
		return addClassButton;
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
		clientList.setPrototypeCellValue(new Users("********************", "**************",
				"***********************************", "*******************", "******", "******"));
		JScrollPane scrollPane = new JScrollPane(clientList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 1;
		layoutConstraints.gridwidth = 2;
		layoutConstraints.gridheight = 4;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 2.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(scrollPane, layoutConstraints);
		add(scrollPane);

	}
}

package assign_04;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserDetailsDialog extends JDialog {
	
	int ID = -1;
	boolean staffTF = false;
	private Users theUser; //user being edited
	DialogClient theDialogClient; // the parent

	// These are the components of the dialog box
	private JLabel		aLabel; //reusable label variable
	private JTextField	name;
	private JTextField	phone;
	private JTextField	email;
	private JTextField	address;
	private JTextField	gender;
	private JTextField	referralSource;
	private JTextField	instructorType;
	
	// Buttons 
	private JButton		updateButton;
	private JButton		deleteButton;
	private JButton		cancelButton;
	
	Font UIFont = new Font("Courier New", Font.BOLD, 16);
	
	// constructor
	public UserDetailsDialog(Frame owner, DialogClient aClient, String title, boolean modal, Users aUser, boolean staffTF) {
		super(owner,title,modal);
		
		theDialogClient = aClient;
		theUser = aUser;
		this.staffTF = staffTF;
		ID = aUser.getID();
		
		buildDialogWindow(theUser);
		
		// Add listeners for the Update and Cancel buttons as well as window closing
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				updateButtonClicked();
			}});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				deleteButtonClicked();
			}});


		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				cancelButtonClicked();
			}});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				cancelButtonClicked();
			}});

		setSize(400, 300);
	}
	
	// add the necessary components to the interface
	private void buildDialogWindow(Users aUser) {
		
   		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints lc = new GridBagConstraints();
        getContentPane().setLayout(layout);

        lc.anchor = GridBagConstraints.EAST;
        lc.insets = new Insets(5, 5, 5, 5);
        
        aLabel = new JLabel("Name");
        lc.gridx = 0; lc.gridy = 0;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);
        
        aLabel = new JLabel("Phone");
        lc.gridx = 0; lc.gridy = 1;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("Email");
        lc.gridx = 0; lc.gridy = 2;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("Address");
        lc.gridx = 0; lc.gridy = 3;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);
        
        if (staffTF == true) {
        	aLabel = new JLabel("Insructor Type");
        	lc.gridx = 0; lc.gridy = 4;
        	lc.gridwidth = 1; lc.gridheight = 1;
        	lc.weightx = 0.0; lc.weighty = 0.0;
        	layout.setConstraints(aLabel, lc);
        	getContentPane().add(aLabel);
        } else {
        	aLabel = new JLabel("Gender");
        	lc.gridx = 0; lc.gridy = 4;
        	lc.gridwidth = 1; lc.gridheight = 1;
        	lc.weightx = 0.0; lc.weighty = 0.0;
        	layout.setConstraints(aLabel, lc);
        	getContentPane().add(aLabel);
		
        	aLabel = new JLabel("Ref Source");
        	lc.gridx = 0; lc.gridy = 5;
        	lc.gridwidth = 1; lc.gridheight = 1;
        	lc.weightx = 0.0; lc.weighty = 0.0;
        	layout.setConstraints(aLabel, lc);
        	getContentPane().add(aLabel);
        }
        
   		// Add the name field
        name = new JTextField(aUser.getName());
        name.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 0;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(name, lc);
   		getContentPane().add(name);
   		
   		// Add the phone field
        phone = new JTextField(aUser.getPhone());
        phone.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 1;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(phone, lc);
   		getContentPane().add(phone);
   		
   		// Add the email field
        email = new JTextField(aUser.getEmail());
        email.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 2;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(email, lc);
   		getContentPane().add(email);
   		
   		// Add the address field
        address = new JTextField(aUser.getAddress());
        address.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 3;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(address, lc);
   		getContentPane().add(address);
   		
        if (staffTF == true) {
           	// Add the instructor type
        	instructorType = new JTextField(aUser.getInstructorType());
        	instructorType.setFont(UIFont);
        	lc.gridx = 1; lc.gridy = 4;
        	lc.gridwidth = 3; lc.gridheight = 1;
        	lc.fill = GridBagConstraints.BOTH;
        	lc.weightx = 1.0; lc.weighty = 0.0;
        	layout.setConstraints(instructorType, lc);
   			getContentPane().add(instructorType);
        } else {
        	// Add the gender field
        	gender = new JTextField(aUser.getGender());
        	gender.setFont(UIFont);
        	lc.gridx = 1; lc.gridy = 4;
        	lc.gridwidth = 3; lc.gridheight = 1;
        	lc.fill = GridBagConstraints.BOTH;
        	lc.weightx = 1.0; lc.weighty = 0.0;
        	layout.setConstraints(gender, lc);
   			getContentPane().add(gender);
   		
   			// Add the ref Source field
   			referralSource = new JTextField(aUser.getReferralSource());
        	referralSource.setFont(UIFont);
        	lc.gridx = 1; lc.gridy = 5;
        	lc.gridwidth = 3; lc.gridheight = 1;
        	lc.fill = GridBagConstraints.BOTH;
        	lc.weightx = 1.0; lc.weighty = 0.0;
        	layout.setConstraints(referralSource, lc);
   			getContentPane().add(referralSource);
        }
   		
   		// Add the Update button
   		updateButton = new JButton("UPDATE");
        lc.gridx = 1; lc.gridy = 6;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(updateButton, lc);
   		getContentPane().add(updateButton);
   		
		// Add the Delete button
		deleteButton = new JButton("DELETE");
        lc.gridx = 2; lc.gridy = 6;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(deleteButton, lc);
   		getContentPane().add(deleteButton);

   		// Add the Cancel button
		cancelButton = new JButton("CANCEL");
        lc.gridx = 3; lc.gridy = 6;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(cancelButton, lc);
   		getContentPane().add(cancelButton); 
	}
	
	/*
	private JTextField	name;
	private JTextField	phone;
	private JTextField	email;
	private JTextField	address;
	private JTextField	gender;
	private JTextField	referralSource;
	private JTextField	instructorType;
	
	 */
	private void updateButtonClicked() {

		theUser.setName(name.getText());
		theUser.setPhone(phone.getText());
		theUser.setEmail(email.getText());
		theUser.setAddress(address.getText());
		if (staffTF == true) { 
			theUser.setInstructorType(instructorType.getText());
			theUser.setStaffTF(true);
		} else {
			theUser.setGender(gender.getText());
			theUser.setReferralSource(referralSource.getText());
			theUser.setStaffTF(false);
		}
		
		//Inform the dialog client that the dialog finished
		if (theDialogClient != null) {
			theDialogClient.dialogFinished(DialogClient.operation.UPDATE);
		}
		//Make the dialog go away
		dispose();
	}
	
	private void deleteButtonClicked() {

		//Inform the dialog client that the dialog finished
		if (theDialogClient != null) {
			theDialogClient.dialogFinished(DialogClient.operation.DELETE);
		} 
		//Make the dialog go away
		dispose();
	}
	
	private void cancelButtonClicked() {
		//Inform the dialog client that the dialog finished
		if (theDialogClient != null) {
			theDialogClient.dialogCancelled();
		}

		//Make the dialog go away
		dispose();
	}
}

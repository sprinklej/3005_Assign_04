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

public class ClassDetailsDialog extends JDialog {

	int ID = -1;
	private Classes theClass; //class being edited
	DialogClient theDialogClient; // the parent

	// These are the components of the dialog box
	private JLabel		aLabel; //reusable label variable
	private JTextField	instructorEmail;
	private JTextField	className;
	private JTextField	currentSize;
	private JTextField	maxSize;
	private JTextField	classType;
	private JTextField	dateTime;
	
	// Buttons 
	private JButton		updateButton;
	private JButton		deleteButton;
	private JButton		cancelButton;
	
	Font UIFont = new Font("Courier New", Font.BOLD, 16);
	
	//(Frame owner, DialogClient aClient, String title, boolean modal, FakeBookSong aSong){
	//(thisFrame, thisFrame, "Client Details Dialog", true, selectedUser);
	public ClassDetailsDialog(Frame owner, DialogClient aClient, String title, boolean modal, Classes aClass) {
		super(owner,title,modal);
		
		theDialogClient = aClient;
		theClass = aClass;
		ID = aClass.getID();
		
		buildDialogWindow(theClass);
		
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

		setSize(500, 300);
	}
	
	
	private void buildDialogWindow(Classes aClass) {
		
   		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints lc = new GridBagConstraints();
        getContentPane().setLayout(layout);
		
        lc.anchor = GridBagConstraints.EAST;
        lc.insets = new Insets(5, 5, 5, 5);
        
        aLabel = new JLabel("Instructor Email");
        lc.gridx = 0; lc.gridy = 0;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);
        
        aLabel = new JLabel("Class Name");
        lc.gridx = 0; lc.gridy = 1;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("Current Size");
        lc.gridx = 0; lc.gridy = 2;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("Max Size");
        lc.gridx = 0; lc.gridy = 3;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);
        
        aLabel = new JLabel("CLass Type");
        lc.gridx = 0; lc.gridy = 4;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);

        aLabel = new JLabel("Date & Time");
        lc.gridx = 0; lc.gridy = 5;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        layout.setConstraints(aLabel, lc);
        getContentPane().add(aLabel);
        
        
        // Add the instructor email field
        instructorEmail = new JTextField(aClass.getStaffEmail());
        instructorEmail.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 0;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(instructorEmail, lc);
   		getContentPane().add(instructorEmail);
        
   		// Add the class name field
   		className = new JTextField(aClass.getClassName());
   		className.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 1;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(className, lc);
   		getContentPane().add(className);
        
   		// Add the current size field
   		currentSize = new JTextField(Integer.toString(aClass.getCurrentSize()));
   		currentSize.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 2;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(currentSize, lc);
   		getContentPane().add(currentSize);
               
   		// Add the max size field
   		maxSize = new JTextField(Integer.toString(aClass.getMaxSize()));
   		maxSize.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 3;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(maxSize, lc);
   		getContentPane().add(maxSize);
        
   		// Add the class type field
   		classType = new JTextField(aClass.getClassType());
   		classType.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 4;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(classType, lc);
   		getContentPane().add(classType);
   		
   		// Add the date & time field
   		dateTime = new JTextField(aClass.getDateTime());
   		dateTime.setFont(UIFont);
        lc.gridx = 1; lc.gridy = 5;
        lc.gridwidth = 3; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        layout.setConstraints(dateTime, lc);
   		getContentPane().add(dateTime);
		
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
	
	private void updateButtonClicked() {

		//Inform the dialog client that the dialog finished
		if (theDialogClient != null) {
			theDialogClient.classDialogFinished(DialogClient.operation.UPDATE);
		}
		//Make the dialog go away
		dispose();
	}
	
	private void deleteButtonClicked() {

		//Inform the dialog client that the dialog finished
		if (theDialogClient != null) {
			theDialogClient.classDialogFinished(DialogClient.operation.DELETE);
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


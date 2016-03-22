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

public class JoinClassDetailsDialog extends JDialog {
	// These are the components of the dialog box
	private JLabel		aLabel;
	private JTextField	email;
	
	private Users theUser;
	DialogClient theDialogClient; // the parent
	
	// Buttons 
	private JButton		joinButton;
	private JButton		cancelButton;

	Font UIFont = new Font("Courier New", Font.BOLD, 16);
	
	public JoinClassDetailsDialog(Frame owner, DialogClient aClient, String title, boolean modal, Users aUser) {
		super(owner,title,modal);
		
		theDialogClient = aClient;
		theUser = aUser;
		
		buildDialogWindow();
		
		// Add listeners for the Update and Cancel buttons as well as window closing
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				joinButtonClicked();
			}});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				cancelButtonClicked();
			}});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				cancelButtonClicked();
			}});

		setSize(400, 200);
	}
	
	private void buildDialogWindow() {
		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints lc = new GridBagConstraints();
        getContentPane().setLayout(layout);

        lc.anchor = GridBagConstraints.WEST;
        lc.insets = new Insets(5, 5, 5, 5);
        lc.gridx = 0; lc.gridy = 0;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        lc.gridx = 0; lc.gridy = 1;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.fill = GridBagConstraints.BOTH;
        lc.weightx = 1.0; lc.weighty = 0.0;
        lc.gridx = 0; lc.gridy = 3;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
        lc.gridx = 1; lc.gridy = 3;
        lc.gridwidth = 1; lc.gridheight = 1;
        lc.weightx = 0.0; lc.weighty = 0.0;
   		
   		aLabel = new JLabel("Enter the email address of the client joining the class:");
   		layout.setConstraints(aLabel, lc);
   		GridBagConstraints gbc_aLabel = new GridBagConstraints();
   		gbc_aLabel.gridwidth = 2;
   		gbc_aLabel.insets = new Insets(0, 0, 5, 5);
   		gbc_aLabel.gridx = 1;
   		gbc_aLabel.gridy = 0;
   		getContentPane().add(aLabel, gbc_aLabel);
   						
   		// Add the name field
   		email = new JTextField("");
   		email.setFont(UIFont);
   		layout.setConstraints(email, lc);
   		GridBagConstraints gbc_email = new GridBagConstraints();
   		gbc_email.fill = GridBagConstraints.HORIZONTAL;
   		gbc_email.gridwidth = 2;
   		gbc_email.insets = new Insets(0, 0, 5, 5);
   		gbc_email.gridx = 1;
   		gbc_email.gridy = 1;
   		getContentPane().add(email, gbc_email);
   		
   		// Add the join button
   		joinButton = new JButton("JOIN");
   		layout.setConstraints(joinButton, lc);
   		GridBagConstraints gbc_joinButton = new GridBagConstraints();
   		gbc_joinButton.insets = new Insets(0, 0, 0, 5);
   		gbc_joinButton.gridx = 1;
   		gbc_joinButton.gridy = 2;
   		getContentPane().add(joinButton, gbc_joinButton);
   		
   		// Add the Cancel button
   		cancelButton = new JButton("CANCEL");
   		layout.setConstraints(cancelButton, lc);
   		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
   		gbc_cancelButton.anchor = GridBagConstraints.WEST;
   		gbc_cancelButton.gridx = 2;
   		gbc_cancelButton.gridy = 2;
   		getContentPane().add(cancelButton, gbc_cancelButton); 
	}
	
	private void joinButtonClicked() {
		theUser.setEmail(email.getText());
		
		//Inform the dialog client that the dialog finished
		if (theDialogClient != null) {
			theDialogClient.joinDialogFinished();
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

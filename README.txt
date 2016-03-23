Joel Sprinkle
100960023
COMP 3005
Assignment 04
Question 02

----About----
-This is a Java Swing project, that is connected to a database.
-The project manages clients, staff, and classes at a gym.



----Setup/Install----
-Import the project into eclipse
-Run the main class as a Java Application



----Usage----
--Add a client:
Click the "Add client" button.
Fill in the information.
Click the "update" button.

--Update a client:
Double click on a client in the clients list. 
Update the information.
Click the "update" button.

--Delete a client:
Double click on a client in the clients list.
Click the "delete" button

NOTES:
-When adding/updating a client, all the fields must be filled in (with the exception of the referral source field which can be empty), 
otherwise the information will not be written to the DB.
-When deleting a client they will also be removed from any classes that are signed up for.


--Add a staff member:
Click the "Add staff" button.
Fill in the information.
Click the "update" button.

--Update a staff member:
Double click on a staff member in the staff list. 
Update the information.
Click the "update" button.

--Delete a staff member:
Double click on a staff member in the staff list. 
Click the "delete" button.

NOTE:
-When adding/updating a staff member, all the fields must be filled in, 
otherwise the information will not be written to the DB.
-When deleting a staff member, any classes that the staff member is teaching will also be removed.

--Add a class:
Click the "Add class" button.
Fill in the information.
Click the "update" button.

-Here is a list of valid staff email addresses that are already in the DB
to use for the staff email field:
Megane_Nicolas@sharon.co.uk
Deshawn@trent.ca
Keyshawn.Bartoletti@ida.ca
Lucious@eldora.ca
Electa.Bailey@elisa.io

--Update a class:
Double click on a class in the class list. 
Update the information.
Click the "update" button.

--Delete a class
Double click on a class in the class list. 
Click the "delete" button.

NOTE:
-When adding/updating a class, all the fields must be filled in, 
otherwise the information will not be written to the DB.


--Have a client sign up for a class:
Single click on a class to select it.
Click on the "join class" button.
Enter the email address of the client that you would like to add to the class.
If the class is full the client will not be added to the class.


--View the classes that a client is currently signed up for:
Single click on a client, and only the classes that they are signed up for will appear in the classes list.


--View the classes that a staff member is teaching:
Single click on a staff member, and only the classes that they are instructing will appear in the classes list.


--Get back to the full list of classes:
Click the "Refresh" button.



----The Database----
The database can be reset back to its original configuration by opening the ironNorth.db from the command line.
i.e. $sqlite3 ironNorth.db
Then reading in the ironNorth-ResetDB.sql script.
i.e. >.read ironNorth-ResetDB.sql

The script drops all the tables then re-adds them with some default values.


----Problems/Issues----
There are no known issues at this time.



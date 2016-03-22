Joel Sprinkle
100960023
COMP 3005
Assignment 04


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

NOTE: When adding/updating a client, all the fields must be filled in (with the exception of the referral source field which can be empty), 
otherwise the information will not be written to the DB.


--Add a staff member:
Click the "Add staff" button.
Fill in the information.
Click the "update" button.

--Update a staff member:
Double click on a staff member in the staff list. 
Update the information.
Click the "update" button.

NOTE: When adding/updating a staff member, all the fields must be filled in, 
otherwise the information will not be written to the DB.


--Add a class:
Click the "Add class" button.
Fill in the information.
Click the "update" button.

--Update a class:
Double click on a class in the class list. 
Update the information.
Click the "update" button.

-Here is a list of 'valid' staff email addresses that are already in the DB
to use for the staff email field:
Megane_Nicolas@sharon.co.uk
Deshawn@trent.ca
Keyshawn.Bartoletti@ida.ca
Lucious@eldora.ca
Electa.Bailey@elisa.io

NOTE: When adding/updating a class, all the fields must be filled in, 
otherwise the information will not be written to the DB.


--Have a client sign up for a class:
TODO


--View the classes that a client is currently signed up for:
TODO


--View the classes that a staff member is teaching:
TODO


--Get back to the full list of classes:
Click the "Refresh" button.
TODO??????????????????????????????????????????????????????????????????????????????


----About The GUI----
The top-left list is the list of clients.
The bottom-left list is the list of staff.
The list on the right side is the list of classes.


----The Database----
The database can be reset back to its original configuration by opening the ironNorth.db from the command line.
i.e. $sqlite3 ironNorth.db
Then reading in the ironNorth-ResetDB.sql script.
i.e. >.read ironNorth-ResetDB.sql

The script drops all the tables then re-adds them with some default values.


----Problems/Issues----
The layout is not as nice as I wanted it to be, I have never used Java Swing before... It is not my friend.
Setting things into the grid using the x and y coordinates does not always seem to work as expected.



--DROP THE DATABASE TABLES
--=======================
DROP TABLE IF EXISTS staff;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS classes_clients;


--CREATE DATABASE TABLES
--=======================

create table if not exists staff(
	staffID integer NOT NULL primary key,
	name text NOT NULL,
	phone text NOT NULL,
	sEmail text NOT NULL,
	address text NOT NULL,
	instructorType text NOT NULL
	);
	
create table if not exists clients(
	clientID integer NOT NULL primary key,
	name text NOT NULL,
	phone text NOT NULL,
	cEmail text NOT NULL,
	address text NOT NULL,
	gender text NOT NULL,
	referralSource text
	);	

create table if not exists classes(
	classID integer NOT NULL primary key,
	sEmail text NOT NULL,
	className text NOT NULL,
	currentSize integer NOT NULL,
	maxSize integer NOT NULL,
	classType text NOT NULL,
	dt datetime NOT NULL
	);
	
create table if not exists classes_clients(
	classID integer NOT NULL references classes(classID),
	clientID text NOT NULL references clients(clientID),
	primary key(classID, clientID)
	);


--INSERT DATA
--=======================
BEGIN TRANSACTION; 

--staff: name, phone, sEmail, address, instructorType
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Shany Bosco', '1-989-666-4007', 'Megane_Nicolas@sharon.co.uk', '811 Hammes Isle', 'Yoga');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Joaquin Waelchi', '(846)652-5079', 'Deshawn@trent.ca', '45004 Bernice Creek', 'Strength');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Tiana Kerluke', '162-044-8282', 'Keyshawn.Bartoletti@ida.ca', '22252 Sawayn Valley', 'Spin');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Zack Gleichner', '743-586-0246', 'Lucious@eldora.ca', '6686 Saul Loaf', 'Strength');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Lea Beer', '1-715-482-9750', 'Electa.Bailey@elisa.io', '1776 Carli Grove', 'Yoga');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Arden Parker PhD', '574-248-2771', 'Elwin_Bednar@myrtis.biz', '48337 Schuppe', 'Yoga');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Adela Kessler', '178-364-0943', 'Jude@allie.biz', '07338 Ankunding Forks', 'Spin');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Rachael Kihn', '(756)779-5982', 'Sabina_Kessler@rickie.info', '66471 Runolfsdottir Haven', 'Strength');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Kasey Beatty', '106-516-7242', 'Clifton.Grimes@deontae.co.uk', '7273 Mireille Garden', 'Spin');
INSERT INTO staff(name, phone, sEmail, address, instructorType) VALUES ('Carmen Haag', '619-560-0695', 'Casimir@wilfredo.me', '87673 Maria Spurs', 'Strength');
	
--clients: name, phone, cEmail, address, gender, referralSource
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Hermina Schaden', '(293)991-4170', 'Dusty.Waters@yolanda.me', '33693 Floyd Trail', 'female', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Johnnie Stracke', '1-375-499-7442', 'Terry.Rohan@brian.org', '0295 Lindgren Views', 'male', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Chyna Schinner', '1-278-601-2853', 'Krista.Hyatt@kasey.us', '00084 Larson Springs', 'female', 'friend');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Ole Reynolds', '960-057-4443', 'Alec_Block@lemuel.org', '269 Erdman Island', 'male', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Antonio Rutherford', '743-706-3108', 'Ottilie@reba.net', '61907 Fisher Drive', 'male', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Caitlyn Lehner', '(702)341-7018', 'Bernhard@nestor.me', '624 Rogelio Crossing', 'female', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Berta Olson', '978-707-3735', 'Floy@jamal.biz', '29513 Garnet Ramp', 'female', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Harry McGlynn', '617-491-7171', 'Arlo.Orn@darion.ca', '109 Boyle Alley', 'male', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Watson Grimes', '658-835-4467', 'Eudora@russel.ca', '2587 Odessa Canyon', 'male', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Faustino Zieme', '1-137-707-0996', 'Nils@alycia.info', '24545 Rath Shore', 'female', NULL);		

INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Brielle Adams', '1-658-517-4756', 'Travon@jesse.info', '681 Elenora Parkways', 'female', 'radio');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Hettie Zemlak', '(711)320-7686', 'Emery.Kertzmann@lavonne.name', '300 Gust Crescent', 'female', 'radio');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Kelley Bauch', '(003)276-2618', 'Harmony@chelsea.name', '78861 Carolina Squares', 'female', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Kavon Greenfelder', '(233)180-5353', 'Roxane_Kassulke@syble.me', '201 Junius Brook', 'male', 'friend');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Della Heidenreich', '(793)895-1870', 'Rosella@zetta.info', '24372 VonRueden Ranch', 'female', 'friend');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Luz White', '214-813-4244', 'Elissa@margarett.name', '95639 Krajcik Fall', 'female', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Remington Bradtke', '1-769-075-5326', 'Abdullah@felipa.org', '63997 Zane Turnpike', 'male', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Karlee Hills', '281-299-5597', 'Verlie.Abbott@aubree.biz', '6592 Haley Islands', 'female', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Eugene Boehm', '1-979-614-9993', 'Marcos_Huels@merle.io', '8337 Deckow Burg', 'male', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Austyn Feeney', '(657)412-3773', 'Betsy@roger.com', '054 Rosella Shores', 'male', 'online');	

INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Nelson Williamson', '838-572-2436', 'Armando_Grant@seamus.org', '0129 Name Garden', 'male', 'friend');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Diana Fritsch', '(497)907-7386', 'Mattie.Hansen@laron.info', '639 Schroeder Highway', 'female', 'friend');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Abbigail Braun', '490-712-2620', 'Tanner_McKenzie@samson.name', '19845 Hodkiewicz Well', 'female', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Geovanni Hilpert', '374-405-9357', 'Eusebio_Stracke@remington.org', '1303 Melvin Forks', 'male', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Nolan Bahringer', '(460)664-5981', 'Loren_Crooks@nellie.name', '614 Becker Island', 'male', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Deondre Sauer', '864-856-6371', 'Rahsaan_Bogan@julio.biz', '1210 Lehner Well', 'male', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Alia Beier', '925-655-6432', 'Litzy.Bechtelar@israel.biz','662 Roselyn Square', 'female', NULL);
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Joseph Quigley', '002-868-6817', 'Yadira.Morissette@maxwell.name', '9100 Danika Islands', 'male', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Art Kertzmann', '079-278-7003', 'Ima_Douglas@bill.info', '0388 Bogisich Ridge', 'male', 'online');
INSERT INTO clients(name, phone, cEmail, address, gender, referralSource) VALUES ('Garnet Schowalter', '(934)325-3221', 'Shayna@janie.us', '1798 Mante Loaf', 'male', 'friend');	

--classes: classID, sEmail, className, currentSize, maxSize, classType, dt
INSERT INTO classes(sEmail, className, currentSize, maxSize, classType, dt) VALUES ('Megane_Nicolas@sharon.co.uk', 'Flow yoga', 5, 10, 'moderate', '2016-03-14 06:00');
INSERT INTO classes(sEmail, className, currentSize, maxSize, classType, dt) VALUES ('Deshawn@trent.ca', 'Group Strength', 6, 8, 'moderate', '2016-03-14 12:00');
INSERT INTO classes(sEmail, className, currentSize, maxSize, classType, dt) VALUES ('Keyshawn.Bartoletti@ida.ca', 'The Brick', 6, 8, 'moderate', '2016-03-14 16:30');
INSERT INTO classes(sEmail, className, currentSize, maxSize, classType, dt) VALUES ('Megane_Nicolas@sharon.co.uk', 'Group Strength', 3, 8, 'moderate', '2016-03-14 17:30');
INSERT INTO classes(sEmail, className, currentSize, maxSize, classType, dt) VALUES ('Keyshawn.Bartoletti@ida.ca', 'Spin', 0, 10, 'moderate', '2016-03-14 18:30');
INSERT INTO classes(sEmail, className, currentSize, maxSize, classType, dt) VALUES ('Deshawn@trent.ca', 'GET H.I.I.T.', 0, 8, 'challenging', '2016-03-14 18:30');
		
--classes_clients: classID, clientID		
INSERT INTO classes_clients(classID, clientID) VALUES (1, 1);		
INSERT INTO classes_clients(classID, clientID) VALUES (1, 3);	
INSERT INTO classes_clients(classID, clientID) VALUES (1, 5);	
INSERT INTO classes_clients(classID, clientID) VALUES (1, 7);	
INSERT INTO classes_clients(classID, clientID) VALUES (1, 9);	

INSERT INTO classes_clients(classID, clientID) VALUES (2, 1);
INSERT INTO classes_clients(classID, clientID) VALUES (2, 2);
INSERT INTO classes_clients(classID, clientID) VALUES (2, 3);
INSERT INTO classes_clients(classID, clientID) VALUES (2, 4);
INSERT INTO classes_clients(classID, clientID) VALUES (2, 5);
INSERT INTO classes_clients(classID, clientID) VALUES (2, 6);

INSERT INTO classes_clients(classID, clientID) VALUES (3, 6);
INSERT INTO classes_clients(classID, clientID) VALUES (3, 8);
INSERT INTO classes_clients(classID, clientID) VALUES (3, 10);
INSERT INTO classes_clients(classID, clientID) VALUES (3, 12);
INSERT INTO classes_clients(classID, clientID) VALUES (3, 14);
INSERT INTO classes_clients(classID, clientID) VALUES (3, 16);

INSERT INTO classes_clients(classID, clientID) VALUES (4, 2);
INSERT INTO classes_clients(classID, clientID) VALUES (4, 12);
INSERT INTO classes_clients(classID, clientID) VALUES (4, 20);
		
END TRANSACTION;

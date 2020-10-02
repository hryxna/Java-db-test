CREATE DATABASE contactsdb;
USE contactsdb;
 
CREATE TABLE `contacts`(
contact_num numeric(10) NOT NULL PRIMARY KEY,
fname varchar(32) NOT NULL,
mname varchar(32),
lname varchar(32)
);

describe contacts;

INSERT INTO contacts
values(1234567890,'hk','m','p');

INSERT INTO contacts
values(0246810120,'darshit','d','pandya');

INSERT INTO contacts
values(1357911131,'vishnu','d','ohja');

INSERT INTO contacts
values(0987654321,'ayushi','d','prajapati');

SELECT * FROM contacts;
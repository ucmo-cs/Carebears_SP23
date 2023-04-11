CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE owners (
  UUID char(36) NOT NULL,
  fname varchar(99) NOT NULL,
  lname varchar(99) NOT NULL,
  address1 varchar(99) NOT NULL,
  address2 varchar(99),
  city varchar(99) NOT NULL,
  state varchar(2) NOT NULL,
  zipCode varchar(10) NOT NULL,
  email varchar(99),
  username varchar(50) NOT NULL,
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`UUID`)
);

INSERT INTO `owners` (`UUID`,`fname`,`lname`,`address1`,`city`,`state`,`zipCode`,`email`,`username`) VALUES ('f1e18004-dc0b-443f-89e7-dc0c16734518','Mark','Twain','234 W 10th St','Kansas City','MO','64105 ','Sam.L.Clemens@gmail.com','Sawyer');
INSERT INTO `owners` (`UUID`,`fname`,`lname`,`address1`,`city`,`state`,`zipCode`,`email`,`username`,`password`) VALUES ('f1e18004-dc0b-443f-89e7-dc0c16734518','Mark','Twain','234 W 10th St','Kansas City','MO','64105 ','Sam.L.Clemens@gmail.com');
INSERT INTO `owners` (`UUID`,`fname`,`lname`,`address1`,`city`,`state`,`zipCode`,`email`,`username`,`password`) VALUES ('5886228a-d668-11ed-afa1-0242ac120002','Becky','Bron','416 Jackson Street','Warrensburg','MO','64093','bronrebecca@gmail.com');
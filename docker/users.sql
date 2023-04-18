CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE users (
  UUID char(36) NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  role varchar(10) NOT NULL,
  status char(5) DEFAULT 'false',
  ownerId char(36) NOT NULL,
  PRIMARY KEY (`UUID`)
);

INSERT INTO `users` (`UUID`,`username`,`password`, `role`, `status`, `ownerId`) VALUES ('f1e18004-dc0b-443f-89e7-dc0c16734518','Sawyer', 'password', 'USER', 'true', 'f1e18004-dc0b-443f-89e7-dc0c16734518');
INSERT INTO `users` (`UUID`,`username`,`password`, `role`, `status`, `ownerId`) VALUES ('c49181d0-dd46-11ed-8971-0242ac180002','Becky', 'password', 'USER', 'true', '5886228a-d668-11ed-afa1-0242ac120002');
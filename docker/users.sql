CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE users (
  UUID char(36) NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  role varchar(10) NOT NULL,
  enabled tinyint(1),
  ownerId char(36) NOT NULL,
  PRIMARY KEY (`UUID`)
);

INSERT INTO `users` (`UUID`,`username`,`password`, `role`, `enabled`, `ownerId`) VALUES ('f1e18004-dc0b-443f-89e7-dc0c16734518','Sawyer', 'password', 'user', 1, 'f1e18004-dc0b-443f-89e7-dc0c16734518');
INSERT INTO `users` (`UUID`,`username`,`password`, `role`, `enabled`, `ownerId`) VALUES (UUID(), 'user', 'password', 'user', 1);


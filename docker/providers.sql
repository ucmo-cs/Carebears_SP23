CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE providers (
  uuid char(36) NOT NULL,
  name varchar(99) NOT NULL,
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `providers` (`uuid`,`Name`) VALUES ('5b8a4d17-4095-48d2-9ed0-4ed89e1ed9fe','Lee\'s Summit Hospital North');
INSERT INTO `providers` (`uuid`,`Name`) VALUES ('e35ec3bd-02c0-4c19-a30d-e79891bab65f','Blue Springs Pet Clinic');
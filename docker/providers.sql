CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE providers (
  uuid char(36) NOT NULL,
  name varchar(99) NOT NULL,
  address1 varchar(99) NOT NULL,
  address2 varchar(99),
  city varchar(99) NOT NULL,
  state varchar(2) NOT NULL,
  zipCode varchar(10) NOT NULL,
  email varchar(99),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `providers` (`uuid`,`Name`,`address1`,`city`,`state`,`zipCode`,`email`) VALUES ('5b8a4d17-4095-48d2-9ed0-4ed89e1ed9fe','Lee\'s Summit Hospital North','250 NW McNary Ct','Lee\'s Summit','MO','64086','vet@lsahnorth.com');
INSERT INTO `providers` (`uuid`,`Name`,`address1`,`city`,`state`,`zipCode`,`email`) VALUES ('e35ec3bd-02c0-4c19-a30d-e79891bab65f','Blue Springs Pet Clinic','1201 US-40','Blue Springs','MO','64015','vet@bspetclinic.com');
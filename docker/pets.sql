CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE species (
  ID int NOT NULL AUTO_INCREMENT,
  name varchar(99) NOT NULL,
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
);

INSERT INTO `species` (`Name`) VALUES ('Canine');

CREATE TABLE breeds (
  ID int NOT NULL AUTO_INCREMENT,
  name varchar(99) NOT NULL,
  speciesId varchar(50),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
);

INSERT INTO `breeds` (`Name`, `speciesId`) VALUES ('Labrador Retriever', '1');

CREATE TABLE pets (
  ID int NOT NULL AUTO_INCREMENT,
  UUID char(36) NOT NULL,
  name varchar(99) NOT NULL,
  speciesId varchar(99) NOT NULL,
  breedId varchar(99) NOT NULL,
  age int(3) NOT NULL,
  ownerId varchar(99),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
);

INSERT INTO `pets` (`UUID`, `Name`, `SpeciesId`, `BreedId`, `Age`) VALUES ('a90a655e-b25b-11ed-8531-0242ac120002', 'Huck', '1', '1', '17');

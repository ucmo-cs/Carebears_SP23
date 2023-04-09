CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE species (
  uuid char(36) NOT NULL,
  speciesName varchar(99) NOT NULL,
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `species` (`uuid`,`speciesName`) VALUES ('46e45c98-758f-4ff9-9811-389e5b206e0c','Canine');

CREATE TABLE breeds (
  uuid char(36) NOT NULL,
  name varchar(99) NOT NULL,
  speciesId varchar(50),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `breeds` (`uuid`,`Name`, `speciesId`) VALUES ('c523cc7e-a5ed-4279-bda1-065c224abae4','Labrador Retriever', '46e45c98-758f-4ff9-9811-389e5b206e0c');

CREATE TABLE pets (
  uuid char(36) NOT NULL,
  name varchar(99) NOT NULL,
  speciesId varchar(99) NOT NULL,
  breedId varchar(99) NOT NULL,
  age int(3) NOT NULL,
  ownerId varchar(99),
  active tinyint(1),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `pets` (`UUID`, `Name`, `SpeciesId`, `BreedId`, `OwnerId`, `Age`, `Active`) VALUES ('a90a655e-b25b-11ed-8531-0242ac120002', 'Huck', '46e45c98-758f-4ff9-9811-389e5b206e0c', 'c523cc7e-a5ed-4279-bda1-065c224abae4', 'f1e18004-dc0b-443f-89e7-dc0c16734518', '17', 1);
INSERT INTO `pets` (`UUID`, `Name`, `SpeciesId`, `BreedId`, `OwnerId`, `Age`, `Active`) VALUES ('a949eb2e-d66e-11ed-afa1-0242ac120002', 'Arto', '46e45c98-758f-4ff9-9811-389e5b206e0c', 'c523cc7e-a5ed-4279-bda1-065c224abae4', '5886228a-d668-11ed-afa1-0242ac120002', '2', 1);
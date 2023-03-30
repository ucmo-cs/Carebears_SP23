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
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `pets` (`UUID`, `Name`, `SpeciesId`, `BreedId`, `OwnerId`, `Age`) VALUES ('a90a655e-b25b-11ed-8531-0242ac120002', 'Huck', '46e45c98-758f-4ff9-9811-389e5b206e0c', 'c523cc7e-a5ed-4279-bda1-065c224abae4', 'e3c45ad6-ce86-11ed-afa1-0242ac120002', '17');
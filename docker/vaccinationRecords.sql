CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE vaccinationRecords (
  uuid char(36) NOT NULL,
  petId char(99) NOT NULL,
  vaccinationId char(36) NOT NULL,
  vaccinationDate datetime NOT NULL,
  active tinyint(1),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updatedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92203f8-b25b-11ed-8531-0242ac120002', '2021-05-27 13:10:00', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a91ccd21-b25b-11ed-8531-0242ac120002', '2021-09-17 14:30:53', 0);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a91ccd21-b25b-11ed-8531-0242ac120002', '2022-09-19 09:30:21', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a91dfba7-b25b-11ed-8531-0242ac120002', '2021-09-17 14:30:53', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92017c0-b25b-11ed-8531-0242ac120002', '2021-01-21 11:32:51', 0);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92017c0-b25b-11ed-8531-0242ac120002', '2021-03-04 16:22:31', 0);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92017c0-b25b-11ed-8531-0242ac120002', '2021-04-15 16:22:31', 1);
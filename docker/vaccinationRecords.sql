CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE vaccinationRecords (
  uuid char(36) NOT NULL,
  petId char(99) NOT NULL,
  vaccinationId char(36) NOT NULL,
  vaccinationDate datetime NOT NULL,
  providerId char(99) NOT NULL,
  active tinyint(1),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updatedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92203f8-b25b-11ed-8531-0242ac120002', '2021-05-27 13:10:00', 'e35ec3bd-02c0-4c19-a30d-e79891bab65f', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a91ccd21-b25b-11ed-8531-0242ac120002', '2021-09-17 14:30:53', '5b8a4d17-4095-48d2-9ed0-4ed89e1ed9fe', 0);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a91ccd21-b25b-11ed-8531-0242ac120002', '2022-09-19 09:30:21', '5b8a4d17-4095-48d2-9ed0-4ed89e1ed9fe', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a91dfba7-b25b-11ed-8531-0242ac120002', '2021-09-17 14:30:53', '5b8a4d17-4095-48d2-9ed0-4ed89e1ed9fe', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92017c0-b25b-11ed-8531-0242ac120002', '2021-01-21 11:32:51', 'e35ec3bd-02c0-4c19-a30d-e79891bab65f', 0);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92017c0-b25b-11ed-8531-0242ac120002', '2021-03-04 16:22:31', '5b8a4d17-4095-48d2-9ed0-4ed89e1ed9fe', 0);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92017c0-b25b-11ed-8531-0242ac120002', '2021-04-15 16:22:31', 'e35ec3bd-02c0-4c19-a30d-e79891bab65f', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), '918b1b3a-d672-11ed-afa1-0242ac120002', 'a92c58aa-b25b-11ed-8531-0242ac120002', '2017-09-19 12:45:29', 'e35ec3bd-02c0-4c19-a30d-e79891bab65f', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), '918b1b3a-d672-11ed-afa1-0242ac120002', 'a9262535-b25b-11ed-8531-0242ac120002', '2017-09-19 12:50:45', 'e35ec3bd-02c0-4c19-a30d-e79891bab65f', 1);
INSERT INTO `vaccinationRecords` (`UUID`, `petId`, `vaccinationId`, vaccinationDate, providerId, active) VALUES (UUID(), 'a949eb2e-d66e-11ed-afa1-0242ac120002', 'a91dfba7-b25b-11ed-8531-0242ac120002', '2017-09-19 01:15:17', 'e35ec3bd-02c0-4c19-a30d-e79891bab65f', 0);
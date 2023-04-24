CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE wallets (
  walletId char(99) NOT NULL,
  petId char(99) NOT NULL,
  name char(99) NOT NULL,
  purpose char(99) NOT NULL,
  active tinyint(1),
  PRIMARY KEY (`walletId`)
);

INSERT INTO `wallets` (`walletId`, `petId`, `name`, `purpose`, `active`) VALUES ('969997a6-d414-11ed-afa1-0242ac120002', 'a90a655e-b25b-11ed-8531-0242ac120002', 'Huck', 'Vaccinations', 1);

CREATE TABLE walletVaccinationRecords (
  uuid char(36) NOT NULL,
  walletId char(99) NOT NULL,
  petId char(99) NOT NULL,
  vaccinationId char(36) NOT NULL,
  vaccinationDate datetime NOT NULL,
  active tinyint(1),
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updatedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
);

INSERT INTO `walletVaccinationRecords` (`UUID`, `walletId`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), '969997a6-d414-11ed-afa1-0242ac120002', 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92203f8-b25b-11ed-8531-0242ac120002', '2021-05-27 13:10:00', 1);
INSERT INTO `walletVaccinationRecords` (`UUID`, `walletId`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), '969997a6-d414-11ed-afa1-0242ac120002', 'a90a655e-b25b-11ed-8531-0242ac120002', 'a91dfba7-b25b-11ed-8531-0242ac120002', '2021-09-17 14:30:53', 1);
INSERT INTO `walletVaccinationRecords` (`UUID`, `walletId`, `petId`, `vaccinationId`, vaccinationDate, active) VALUES (UUID(), '969997a6-d414-11ed-afa1-0242ac120002', 'a90a655e-b25b-11ed-8531-0242ac120002', 'a92017c0-b25b-11ed-8531-0242ac120002', '2021-04-15 16:22:31', 1);

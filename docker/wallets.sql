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
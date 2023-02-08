CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE `vaccinations` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(99) NOT NULL,
  `type` varchar(99) NOT NULL,
  `createdDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
);

INSERT INTO `vaccinations` (`ID`, `Name`, `Type`, `CreatedDate`) VALUES
(1, 'Bordetella', 'NonCore', '2023-02-07 02:11:04');

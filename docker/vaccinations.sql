CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE vaccinations (
  ID int NOT NULL AUTO_INCREMENT,
  UUID char(36) NOT NULL,
  name varchar(99) NOT NULL,
  type varchar(99) NOT NULL,
  age varchar(99) NOT NULL,
  frequency varchar(99) NOT NULL,
  species varchar (50) NOT NULL,
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
);

INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Bordetella', 'NonCore', '12 Months', '6-12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Rabies (Canine)', 'Core', '12 Months', '12-36 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'DHPP (Infant)', 'Core', '6 weeks', '2-4 weeks', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'DHPP (Booster)', 'Core', '18 Months', '36 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Canine Influenza', 'NonCore', '12 Months', '12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Leptospirosis', 'NonCore', '12 Months', '12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Lyme', 'NonCore', '12 Months', '12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Coronavirus', 'NonCore', '12 Months', 'Once', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline distemper (FVRCP)', 'Core', '12 Months', 'Every 36 Months', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline calicivirus (Infant)', 'Core', '6 weeks', '3-4 weeks', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline calicivirus (One Year)', 'Core', '12 Months', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline calicivirus (Adult)', 'Core', '36 Months', 'Every 36 Months', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline leukemia (FeLV) (Infant)', 'Core', '8 weeks', '3-4 weeks', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline herpes virus type 1 (9 weeks)', 'NonCore', '9 weeks', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline herpes virus type 1 (12 weeks)', 'NonCore', '12 weeks', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Feline herpes virus type 1 (Booster)', 'NonCore', '12 Months', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES (UUID(), 'Rabies (Feline)', 'Core', '12 Months', '12-36 Months', 'Feline');
CREATE DATABASE IF NOT EXISTS PETVAX;

USE PETVAX;

CREATE TABLE vaccinations (
  UUID char(36) NOT NULL,
  name varchar(99) NOT NULL,
  type varchar(99) NOT NULL,
  age varchar(99) NOT NULL,
  frequency varchar(99) NOT NULL,
  species varchar (50) NOT NULL,
  createdDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`UUID`)
);

INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a91ccd21-b25b-11ed-8531-0242ac120002', 'Bordetella', 'NonCore', '12 Months', '6-12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a91dfba7-b25b-11ed-8531-0242ac120002', 'Rabies (Canine)', 'Core', '12 Months', '12-36 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92017c0-b25b-11ed-8531-0242ac120002', 'DHPP (Infant)', 'Core', '6 weeks', '2-4 weeks', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92203f8-b25b-11ed-8531-0242ac120002', 'DHPP (Booster)', 'Core', '18 Months', '36 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a922e99c-b25b-11ed-8531-0242ac120002', 'Canine Influenza', 'NonCore', '12 Months', '12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92372cd-b25b-11ed-8531-0242ac120002', 'Leptospirosis', 'NonCore', '12 Months', '12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a9244558-b25b-11ed-8531-0242ac120002', 'Lyme', 'NonCore', '12 Months', '12 Months', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a924ef4b-b25b-11ed-8531-0242ac120002', 'Coronavirus', 'NonCore', '12 Months', 'Once', 'Canine');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a9259db0-b25b-11ed-8531-0242ac120002', 'Feline distemper (FVRCP)', 'Core', '12 Months', 'Every 36 Months', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a9262535-b25b-11ed-8531-0242ac120002', 'Feline calicivirus (Infant)', 'Core', '6 weeks', '3-4 weeks', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a926fc51-b25b-11ed-8531-0242ac120002', 'Feline calicivirus (One Year)', 'Core', '12 Months', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92785c5-b25b-11ed-8531-0242ac120002', 'Feline calicivirus (Adult)', 'Core', '36 Months', 'Every 36 Months', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92851f9-b25b-11ed-8531-0242ac120002', 'Feline leukemia (FeLV) (Infant)', 'Core', '8 weeks', '3-4 weeks', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a928fc2e-b25b-11ed-8531-0242ac120002', 'Feline herpes virus type 1 (9 weeks)', 'NonCore', '9 weeks', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92980e5-b25b-11ed-8531-0242ac120002', 'Feline herpes virus type 1 (12 weeks)', 'NonCore', '12 weeks', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92ac8a4-b25b-11ed-8531-0242ac120002', 'Feline herpes virus type 1 (Booster)', 'NonCore', '12 Months', 'Once', 'Feline');
INSERT INTO `vaccinations` (`UUID`, `Name`, `Type`, `Age`, `Frequency`, `Species`) VALUES ('a92c58aa-b25b-11ed-8531-0242ac120002', 'Rabies (Feline)', 'Core', '12 Months', '12-36 Months', 'Feline');
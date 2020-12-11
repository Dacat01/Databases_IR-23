-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Hamal_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Hamal_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Hamal_db` DEFAULT CHARACTER SET utf8 ;
USE `Hamal_db` ;

-- -----------------------------------------------------
-- Tables `Hamal_db` drop
-- -----------------------------------------------------
DROP TABLE IF EXISTS State;
DROP TABLE IF EXISTS airline;
DROP TABLE IF EXISTS Current_location;
DROP TABLE IF EXISTS Plane_info;
DROP TABLE IF EXISTS Flight;
DROP TABLE IF EXISTS Plane;

-- -----------------------------------------------------
-- Table `Hamal_db`.`airline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hamal_db`.`airline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hamal_db`.`Current_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hamal_db`.`Current_location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(30) NOT NULL,
  `city` VARCHAR(30) NOT NULL,
  `airport` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hamal_db`.`Plane`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hamal_db`.`Plane` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `airline_id` INT NOT NULL,
  `Current_location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Plane_airline1_idx` (`airline_id` ASC),
  INDEX `fk_Plane_Current_location1_idx` (`Current_location_id` ASC),
  CONSTRAINT `fk_Plane_airline1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `Hamal_db`.`airline` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Plane_Current_location1`
    FOREIGN KEY (`Current_location_id`)
    REFERENCES `Hamal_db`.`Current_location` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hamal_db`.`Plane_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hamal_db`.`Plane_info` (
  `Plane_id` INT NOT NULL,
  `plane_identifier` VARCHAR(30) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `total_hrs` INT NOT NULL,
  `max_speed` INT NOT NULL,
  PRIMARY KEY (`Plane_id`),
  INDEX `fk_Plane_info_Plane1_idx` (`Plane_id` ASC) VISIBLE,
  UNIQUE INDEX `plane_identifier_UNIQUE` (`plane_identifier` ASC),
  CONSTRAINT `fk_Plane_info_Plane1`
    FOREIGN KEY (`Plane_id`)
    REFERENCES `Hamal_db`.`Plane` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hamal_db`.`State`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hamal_db`.`State` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `State` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hamal_db`.`Flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hamal_db`.`Flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Plane_id` INT NOT NULL,
  `flight_number` VARCHAR(30) NOT NULL,
  `direction` VARCHAR(30) NOT NULL,
  `departure_time` DATETIME NOT NULL,
  `arrival_time` DATETIME NOT NULL,
  `State_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Previous_flight_Plane2_idx` (`Plane_id` ASC),
  INDEX `fk_Previous_flight_State1_idx` (`State_id` ASC),
  CONSTRAINT `fk_Previous_flight_Plane2`
    FOREIGN KEY (`Plane_id`)
    REFERENCES `Hamal_db`.`Plane` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Previous_flight_State1`
    FOREIGN KEY (`State_id`)
    REFERENCES `Hamal_db`.`State` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Hamal_db` INSERT
-- -----------------------------------------------------

INSERT INTO State (id, State) VALUES
(1, 'Scheduled'),
(2, 'En route'),
(3, 'Compleated');


INSERT INTO airline (id, name) VALUES
(1, 'Ukraine International Airlines'),
(2, 'Turkish Аirlines'),
(3, 'Belavia'),
(4, 'Air France'),
(5, 'KLM'),
(6, 'Delta'),
(7, 'United Airlines'),
(8, 'Motor Sich'),
(9, 'Air Arabia'),
(10, 'Wizz Air UK');

INSERT INTO Current_location (id, country, city, airport) VALUES
(1, 'Ukraine','Lviv','Lviv'),
(2, 'Ukraine','Boryspil','Boryspil'),
(3, 'Ukraine','Kyiv','Kyiv'),
(4, 'Ukraine','Odesa','Odesa '),
(5, 'Ukraine','Vinnytsia','Vinnytsia'),
(6, 'Poland','Warsaw','Warsaw Chopin'),
(7, 'Poland','Katowice','Katowice'),
(8, 'Germany','Hamburg','Hamburg'),
(9, 'Germany','Berlin','Berlin Brandenburg'),
(10, 'United States','Buffalo','Buffalo Niagara');

INSERT INTO Plane (id,airline_id, Current_location_id) VALUES
(1,1,1),
(2,3,2),
(3,2,4),
(4,4,5),
(5,5,3),
(6,2,3),
(7,6,9),
(8,7,10),
(9,9,1),
(10,10,7);


INSERT INTO Plane_info (Plane_id,plane_identifier,type,total_hrs,max_speed) VALUES
(1,'UR-10420','Airbus A320',2000,900),
(2,'VN-A787','Boeing 787',1995,920),
(3,'OE-VAA','Airbus A330',1480,850),
(4,'PP-QZA','Boeing 777',3500,870),
(5,'CF-AHB','Boeing 767',2550,850),
(6,'D-BKLO','Boeing 767',2900,850),
(7,'OD-JIB','Boeing 737 NG',950,750),
(8,'ER-35689','Boeing 747',2980,750),
(9,'HZ-AG1','Saab 340',900,820),
(10,'UK-67982','Bombardier Q400',2200,730);

INSERT INTO Flight (id,Plane_id,flight_number,direction,departure_time,arrival_time,State_id) VALUES
(1,1,'RYR1643','Lviv-Amsterdam','2020-09-28 10:29:00','2020-09-28 15:45:00',1),
(2,2,'WZZ6700','Boryspil-Istanbul','2020-08-20 14:10:00','2020-08-20 18:30:00',2),
(3,2,'WZZ6702','Istanbul-Paris','2020-08-20 20:00:00','2020-08-20 23:55:00',1),
(4,3,'UTN3315','Kyiv-New York','2020-05-01 10:10:00','2020-05-01 19:00:00',3),
(5,4,'AUA381','Rome-Milan','2020-05-04 20:00:00','2020-05-04 00:30:00',3),
(6,7,'LOT765', 'Katowice-London','2020-08-20 15:25:00','2020-08-20 18:40:00',2),
(7,8,'PGT420', 'Hamburg-Tbilisi','2020-09-04 20:00:00','2020-09-05 00:30:00',1),
(8,4,'AUA401', 'Odesa-London','2020-06-12 23:00:00','2020-6-13 03:20:00',3),
(9,5,'PGT431', 'Vinnytsia-London','2020-07-03 14:10:00','2020-07-03 17:50:00',1),
(10,10,'AUA392', 'Buffalo-Amsterdam','2020-07-12 10:30:00','2020-07-12 13:00:00',1);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

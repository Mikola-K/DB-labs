-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kurets
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kurets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kurets` DEFAULT CHARACTER SET utf8 ;
USE `kurets` ;

-- -----------------------------------------------------
-- Table `kurets`.`energy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kurets`.`energy`;
CREATE TABLE `kurets`.`energy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price_per_hour` INT NOT NULL,
  `energy_transfer` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kurets`.`panel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kurets`.`panel`;
CREATE TABLE `kurets`.`panel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `power_in_hour` INT NOT NULL,
  `panel_life` INT NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `angle_of_inclination` INT NOT NULL,
  `energy_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_panel_energy1_idx` (`energy_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_panel_energy1`
    FOREIGN KEY (`energy_id`)
    REFERENCES `kurets`.`energy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kurets`.`battery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kurets`.`battery`;
CREATE TABLE `kurets`.`battery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `charge_level_per_hour` INT NOT NULL,
  `capacity` INT NOT NULL,
  `occupancy` INT NOT NULL,
  `duration_of_use_months` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kurets`.`adress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kurets`.`adress`;
CREATE TABLE `kurets`.`adress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(25) NOT NULL,
  `city` VARCHAR(25) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kurets`.`solar_system`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kurets`.`solar_system`;
CREATE TABLE `kurets`.`solar_system` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `power` INT NOT NULL,
  `panel_id` INT NOT NULL,
  `battery_id` INT NOT NULL,
  `adress_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_solar_system_panel1_idx` (`panel_id` ASC) VISIBLE,
  INDEX `fk_solar_system_battery1_idx` (`battery_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_solar_system_adress1_idx` (`adress_id` ASC) VISIBLE,
  CONSTRAINT `fk_solar_system_panel1`
    FOREIGN KEY (`panel_id`)
    REFERENCES `kurets`.`panel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solar_system_battery1`
    FOREIGN KEY (`battery_id`)
    REFERENCES `kurets`.`battery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solar_system_adress1`
    FOREIGN KEY (`adress_id`)
    REFERENCES `kurets`.`adress` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kurets`.`owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kurets`.`owner`;
CREATE TABLE `kurets`.`owner` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kurets`.`solar_system_has_owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kurets`.`solar_system_has_owner`;
CREATE TABLE `kurets`.`solar_system_has_owner` (
  `solar_system_id` INT NOT NULL,
  `owner_id` INT NOT NULL,
  PRIMARY KEY (`solar_system_id`, `owner_id`),
  INDEX `fk_solar_system_has_owner_owner1_idx` (`owner_id` ASC) VISIBLE,
  INDEX `fk_solar_system_has_owner_solar_system1_idx` (`solar_system_id` ASC) VISIBLE,
  CONSTRAINT `fk_solar_system_has_owner_solar_system1`
    FOREIGN KEY (`solar_system_id`)
    REFERENCES `kurets`.`solar_system` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solar_system_has_owner_owner1`
    FOREIGN KEY (`owner_id`)
    REFERENCES `kurets`.`owner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `kurets`;

INSERT INTO kurets.energy (price_per_hour, energy_transfer)
VALUES (10, 100),
(20, 10),
(30, 50),
(5, 107),
(55, 41),
(43, 39),
(100, 55),
(3, 23),
(7, 11),
(26, 9);

INSERT INTO kurets.panel (power_in_hour,panel_life,type,angle_of_inclination, energy_id)
VALUES (20, 10, 'New', 30, 10),
(35, 1, 'Two', 22, 8),
(10, 5, 'ThreeInOne', 77, 6),
(200, 7, 'Old', 100, 4),
(100, 15, 'B/y',90, 1),
(77, 22, 'Electro', 10, 2),
(5, 33, 'Nevest', 31, 3),
(2, 17, 'New', 22, 5),
(22, 32, 'New', 33, 7),
(17, 8, 'New', 3, 9);

INSERT INTO kurets.battery (charge_level_per_hour,capacity,occupancy,duration_of_use_months)
VALUES (30, 10000, 65, 24),
(20, 10000, 20, 20),
(10, 7100, 30, 16),
(25, 89000, 25, 30),
(80, 100000, 15, 19),
(35, 100, 5, 74),
(5, 30000, 1, 99),
(7, 13000, 10, 5),
(21, 20000, 22, 20),
(33, 1000, 55, 12);

INSERT INTO kurets.adress (street, city, country)
VALUES ('Shevhenko34', 'Lviv', 'Urkaine'),
('Shevhenko34', 'Lviv', 'Urkaine'),
('Lykasha', 'Lviv', 'Urkaine'),
('Petryshevicha', 'Bolekhiv', 'Urkaine'),
('1 St S', 'Lucky Lake', 'Kanada'),
('Brooklyn', 'New Yourk', 'USA'),
('Mason St', 'New Yourk', 'USA'),
('Karla Marksa', 'Kyiv', 'Urkaine'),
('Miry', 'Ternopily', 'Urkaine'),
('Ivana Franka', 'Lviv', 'Urkaine');

INSERT INTO kurets.solar_system (power, panel_id, battery_id, adress_id) 
VALUES (35,1,1,1),
(30,2,2,2),
(35,3,3,3),
(35,5,5,5),
(35,9,9,6),
(35,8,4,10),
(35,7,10,5),
(35,10,8,7),
(35,4,6,9),
(35,6,7,4);

INSERT INTO kurets.owner (name, age)
VALUES ('Stiven', 33),
('Kevin', 23),
('Nick', 55),
('Mark', 30),
('Kely', 63),
('Sara', 80),
('Morty', 61),
('Kelly', 28),
('Mort', 20),
('Amy', 18);

INSERT INTO kurets.solar_system_has_owner (solar_system_id, owner_id)
VALUES (6,1),
(4,2),
(8,9),
(9,5),
(3,8),
(5,4),
(7,7),
(1,3),
(2,6),
(10,10);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

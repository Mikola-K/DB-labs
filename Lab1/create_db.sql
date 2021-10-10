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
CREATE TABLE IF NOT EXISTS `kurets`.`energy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price_per_hour` INT NOT NULL,
  `energy_transfer` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kurets`.`panel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kurets`.`panel` (
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
CREATE TABLE IF NOT EXISTS `kurets`.`battery` (
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
CREATE TABLE IF NOT EXISTS `kurets`.`adress` (
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
CREATE TABLE IF NOT EXISTS `kurets`.`solar_system` (
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
CREATE TABLE IF NOT EXISTS `kurets`.`owner` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kurets`.`solar_system_has_owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kurets`.`solar_system_has_owner` (
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

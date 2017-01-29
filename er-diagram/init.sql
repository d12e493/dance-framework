-- MySQL Script generated by MySQL Workbench
-- Fri Jan 27 14:11:06 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dance
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dance` ;

-- -----------------------------------------------------
-- Schema dance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dance` DEFAULT CHARACTER SET utf8 ;
USE `dance` ;

-- -----------------------------------------------------
-- Table `dance`.`user_`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dance`.`user_` ;

CREATE TABLE IF NOT EXISTS `dance`.`user_` (
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `permission` VARCHAR(200) NULL,
  `status` INT NULL,
  `version` INT NULL,
  `creator_id` INT NULL,
  `create_time` DATETIME NULL,
  `updator_id` INT NULL,
  `update_time` DATETIME NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `email_UNIQUE` ON `dance`.`user_` (`email` ASC);

CREATE INDEX `user_status` ON `dance`.`user_` (`status` ASC);


-- -----------------------------------------------------
-- Table `dance`.`role_`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dance`.`role_` ;

CREATE TABLE IF NOT EXISTS `dance`.`role_` (
  `role_id` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dance`.`permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dance`.`permission` ;

CREATE TABLE IF NOT EXISTS `dance`.`permission` (
  `permission_id` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `role_id` INT NULL,
  PRIMARY KEY (`permission_id`))
ENGINE = InnoDB;

CREATE INDEX `permission_role` ON `dance`.`permission` (`role_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema oliviaFlowers
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema oliviaFlowers
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `oliviaFlowers` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------

USE `oliviaFlowers` ;

-- -----------------------------------------------------
-- Table `oliviaFlowers`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oliviaFlowers`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `password` INT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phoneNumber` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `dateOfBirth` DATE NULL,
  `isAdministrator` TINYINT NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) VISIBLE,
  UNIQUE INDEX `phoneNumber_UNIQUE` (`phoneNumber` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oliviaFlowers`.`Bouquet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oliviaFlowers`.`Bouquet` (
  `idBouquet` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `photo` BLOB NOT NULL,
  `price` INT NOT NULL,
  `composition` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idBouquet`),
  UNIQUE INDEX `idBouquet_UNIQUE` (`idBouquet` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oliviaFlowers`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oliviaFlowers`.`Order` (
  `idOrder` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `typePostcard` INT NULL,
  `textPostcard` VARCHAR(500) NULL,
  `delivery` TINYINT NOT NULL,
  `addressDelivery` VARCHAR(500) NULL,
  `dateTimeDelivery` DATETIME NOT NULL,
  `sumOrder` INT NOT NULL,
  `datePayment` DATETIME NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_User_idx` (`idUser` ASC) VISIBLE,
  UNIQUE INDEX `idOrder_UNIQUE` (`idOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Order_User`
    FOREIGN KEY (`idUser`)
    REFERENCES `oliviaFlowers`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oliviaFlowers`.`Order_has_Bouquet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oliviaFlowers`.`Order_has_Bouquet` (
  `idOrder` INT NOT NULL,
  `idBouquet` INT NOT NULL,
  `count` INT NOT NULL,
  PRIMARY KEY (`idOrder`, `idBouquet`),
  INDEX `fk_Order_has_Bouquet_Bouquet1_idx` (`idBouquet` ASC) VISIBLE,
  INDEX `fk_Order_has_Bouquet_Order1_idx` (`idOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Order_has_Bouquet_Order1`
    FOREIGN KEY (`idOrder`)
    REFERENCES `oliviaFlowers`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_has_Bouquet_Bouquet1`
    FOREIGN KEY (`idBouquet`)
    REFERENCES `oliviaFlowers`.`Bouquet` (`idBouquet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oliviaFlowers`.`Audit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oliviaFlowers`.`Audit` (
  `idAudit` INT NOT NULL AUTO_INCREMENT,
  `table` VARCHAR(50) NOT NULL,
  `idTuple` INT NOT NULL,
  `action` VARCHAR(10) NOT NULL,
  `actionTime` TIMESTAMP NOT NULL,
  `changedColumn` VARCHAR(50) NULL,
  `oldValue` VARCHAR(500) NULL,
  `newValue` VARCHAR(500) NULL,
  PRIMARY KEY (`idAudit`),
  UNIQUE INDEX `idAudit_UNIQUE` (`idAudit` ASC) VISIBLE)
ENGINE = InnoDB;
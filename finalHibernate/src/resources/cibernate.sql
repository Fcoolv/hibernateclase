-- MySQL Script generated by MySQL Workbench
-- Tue Dec 12 14:49:59 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ciberhibernate
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ciberhibernate
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ciberhibernate` DEFAULT CHARACTER SET utf8 ;
USE `ciberhibernate` ;

-- -----------------------------------------------------
-- Table `ciberhibernate`.`salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciberhibernate`.`salas` (
  `idSala` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSala`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ciberhibernate`.`ordenadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciberhibernate`.`ordenadores` (
  `idOrdenador` INT(11) NOT NULL AUTO_INCREMENT,
  `ipNum` VARCHAR(45) NOT NULL,
  `sisOperativo` VARCHAR(45) NULL DEFAULT NULL,
  `idSala` INT(11) NOT NULL,
  `isActivo` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idOrdenador`),
  INDEX `fk_ordenador_sala_idx` (`idSala` ASC),
  CONSTRAINT `fk_ordenador_sala`
    FOREIGN KEY (`idSala`)
    REFERENCES `ciberhibernate`.`salas` (`idSala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ciberhibernate`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciberhibernate`.`usuarios` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fechaRegistro` DATE NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ciberhibernate`.`accesos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciberhibernate`.`accesos` (
  `idAcceso` INT(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` INT(11) NOT NULL,
  `idOrdenador` INT(11) NOT NULL,
  `fechaInicio` DATETIME NOT NULL,
  `fechaFin` DATETIME NOT NULL,
  PRIMARY KEY (`idAcceso`),
  INDEX `fk_accesos_ordenadores_idx` (`idOrdenador` ASC),
  INDEX `fk_acceso_usuario_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_acceso_ordenador`
    FOREIGN KEY (`idOrdenador`)
    REFERENCES `ciberhibernate`.`ordenadores` (`idOrdenador`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_acceso_usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `ciberhibernate`.`usuarios` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

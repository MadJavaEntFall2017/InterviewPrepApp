
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema interviewdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema interviewdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `interviewdb` ;
USE `interviewdb` ;

-- -----------------------------------------------------
-- Table `interviewdb`.`jobs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interviewdb`.`jobs` (
  `jobId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`jobId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `interviewdb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interviewdb`.`category` (
  `categoryId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`categoryId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `interviewdb`.`flashcard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interviewdb`.`flashcard` (
  `flashcardId` INT NOT NULL,
  `question` VARCHAR(500) NOT NULL,
  `answer` VARCHAR(500) NOT NULL,
  `categoryId` INT NOT NULL,
  PRIMARY KEY (`flashcardId`),
  INDEX `fk_flashcard_category_idx` (`categoryId` ASC),
  CONSTRAINT `fk_flashcard_category`
    FOREIGN KEY (`categoryId`)
    REFERENCES `interviewdb`.`category` (`categoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `interviewdb`.`jobs_category_lnk`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interviewdb`.`jobs_category_lnk` (
  `jobsId` INT NOT NULL,
  `categoryId` INT NOT NULL,
  PRIMARY KEY (`jobsId`, `categoryId`),
  INDEX `fk_jobs_has_category_category1_idx` (`categoryId` ASC),
  INDEX `fk_jobs_has_category_jobs1_idx` (`jobsId` ASC),
  CONSTRAINT `fk_jobs_has_category_jobs1`
    FOREIGN KEY (`jobsId`)
    REFERENCES `interviewdb`.`jobs` (`jobId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jobs_has_category_category1`
    FOREIGN KEY (`categoryId`)
    REFERENCES `interviewdb`.`category` (`categoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

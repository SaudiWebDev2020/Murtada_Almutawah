-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema event_planner
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema event_planner
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `event_planner` DEFAULT CHARACTER SET utf8 ;
USE `event_planner` ;

-- -----------------------------------------------------
-- Table `event_planner`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_planner`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `address` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_planner`.`events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_planner`.`events` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `description` TEXT NULL,
  `location` VARCHAR(255) NULL,
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW(),
  `planner_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_events_users_idx` (`planner_id` ASC) VISIBLE,
  CONSTRAINT `fk_events_users`
    FOREIGN KEY (`planner_id`)
    REFERENCES `event_planner`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_planner`.`rsvps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_planner`.`rsvps` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  INDEX `fk_rsvp_events1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_rsvp_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_rsvp_events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event_planner`.`events` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rsvp_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `event_planner`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
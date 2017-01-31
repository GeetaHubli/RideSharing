CREATE TABLE `RideSharing_dev`.`cars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `year` YEAR NOT NULL,
  `cartype` ENUM('BASIC', 'LUX') NOT NULL,
  PRIMARY KEY (`id`));

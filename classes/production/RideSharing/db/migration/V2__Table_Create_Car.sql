CREATE TABLE `cars` (
  `id`      INT                  NOT NULL AUTO_INCREMENT,
  `make`    VARCHAR(45)          NOT NULL,
  `model`   VARCHAR(45)          NOT NULL,
  `year`    INT                  NOT NULL,
  `cartype` ENUM('BASIC', 'LUX') NOT NULL DEFAULT 'BASIC' ,
  PRIMARY KEY (`id`));

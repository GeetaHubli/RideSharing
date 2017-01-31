CREATE TABLE `cars` (
  `id`        INT                   NOT NULL          AUTO_INCREMENT,
  `version`   INT                   NULL              DEFAULT 0,
  `make`      VARCHAR(45)           NOT NULL,
  `model`     VARCHAR(45)           NOT NULL,
  `year`      YEAR                  NOT NULL,
  `cartype`   ENUM('BASIC', 'LUX')  NOT NULL          DEFAULT 'BASIC' ,
  `created`   TIMESTAMP             NULL              DEFAULT NOW(),
  `modified`  TIMESTAMP             NULL              DEFAULT NOW(),
  PRIMARY KEY (`id`));

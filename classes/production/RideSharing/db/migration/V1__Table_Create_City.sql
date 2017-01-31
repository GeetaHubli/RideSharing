CREATE TABLE `cities` (
  `id`        INT         NOT NULL    AUTO_INCREMENT,
  `name`      VARCHAR(50) NOT NULL,
  `state`     VARCHAR(50) NOT NULL,
  `dayrate`   DOUBLE      NULL        DEFAULT 50,
  `nightrate` DOUBLE      NULL        DEFAULT 75,
  PRIMARY KEY (`id`));

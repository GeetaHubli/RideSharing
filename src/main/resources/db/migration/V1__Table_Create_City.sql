CREATE TABLE `cities` (
  `id`        INT             NOT NULL    AUTO_INCREMENT,
  `version`   INT             NULL        DEFAULT 0,
  `name`      VARCHAR(50)     NOT NULL,
  `state`     VARCHAR(50)     NOT NULL,
  `dayrate`   DOUBLE          NULL        DEFAULT 50,
  `nightrate` DOUBLE          NULL        DEFAULT 75,
  `created`   TIMESTAMP       NULL        DEFAULT NOW(),
  `modified`  TIMESTAMP       NULL        DEFAULT NOW(),
  PRIMARY KEY (`id`));

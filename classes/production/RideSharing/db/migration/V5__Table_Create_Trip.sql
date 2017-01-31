CREATE TABLE `trips` (
  `id`                    INT                           NOT NULL          AUTO_INCREMENT,
  `version`               INT                           NULL              DEFAULT 0,
  `duration`              DOUBLE                        NOT NULL,
  `start_time`            TIMESTAMP                     NOT NULL          DEFAULT NOW(),
  `stop_time`             TIMESTAMP                     NOT NULL          DEFAULT NOW(),
  `car_id`                INT                           NOT NULL,
  `passenger_id`          INT                           NOT NULL,
  `driver_id`             INT                           NOT NULL,
  `city_id`               INT                           NOT NULL,
  `distance`              INT                           NOT NULL,
  `tip`                   INT                           NULL              DEFAULT 0,
  `cost`                  DOUBLE                        NOT NULL          DEFAULT 0,
  `total_cost`            DOUBLE                        NOT NULL          DEFAULT 0,
  `driver_review`         ENUM('1', '2', '3', '4', '5') NULL              DEFAULT '5',
  `driver_review_text`    VARCHAR(100)                  NULL,
  `passenger_review`      ENUM('1', '2', '3', '4', '5') NULL              DEFAULT '5',
  `passenger_review_text` VARCHAR(100)                  NULL,
  `created`               TIMESTAMP                     NULL              DEFAULT NOW(),
  `modified`              TIMESTAMP                     NULL              DEFAULT NOW(),

  PRIMARY KEY (`id`),

  CONSTRAINT `fk_car_id`
  FOREIGN KEY (`car_id`)
  REFERENCES `cars` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_passenger_id`
  FOREIGN KEY (`passenger_id`)
  REFERENCES `passengers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_driver_id`
  FOREIGN KEY (`driver_id`)
  REFERENCES `drivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_city_id`
  FOREIGN KEY (`city_id`)
  REFERENCES `cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
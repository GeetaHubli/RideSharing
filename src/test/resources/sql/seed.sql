USE RideSharing_test;

set FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE cities;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;
TRUNCATE TABLE drivers;
TRUNCATE TABLE trips;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO `cities` (`name`,`state`)
VALUES
  ('Bangalore', 'Karnataka'),
  ('Mumbai','Maharashtra'),
  ('Mysore', 'Karnataka'),
  ('Chennai','Tamilnadu');

INSERT INTO `cars` (`make`,`model`,`year`,`cartype`)
VALUES
  ('BMW', 'X5', 2012, 'LUX'),
  ('MARUTI', '800', 2010, 'BASIC'),
  ('Nissan', 'Pathfinder', 2016, 'LUX');

INSERT INTO `passengers` (`name`, `age`, `gender`,`balance`)
VALUES
  ('Swapnil', 22, 'M', 10000.00 ),
  ('test1', 30, 'M', 4000.00 ),
  ('test2', 27, 'F', 6000.00 );

INSERT INTO `drivers` (`name`, `age`, `gender`)
VALUES
  ('Geeta', 35, 'F'),
  ('test1', 30, 'M'),
  ('test2', 27, 'F');

INSERT INTO `trips` (`duration`,`start_time`,`stop_time`,`car_id`,`passenger_id`,`driver_id`,`city_id`,`distance`,`cost`,`total_cost`)
VALUES
  (30.00, NOW(), NOW(), 1, 1, 1, 1, 10, 200.00, 200.00 ),
  (45.00, NOW(), NOW(), 1, 2, 2, 2, 15, 450.00, 450.00 );


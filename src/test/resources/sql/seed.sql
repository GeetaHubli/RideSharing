USE RideSharing_test;

TRUNCATE TABLE cities;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;
TRUNCATE TABLE drivers;

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


USE RideSharing_test;

TRUNCATE TABLE cities;
TRUNCATE TABLE cars;

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
  ('AUDI', 'A5', 2015, 'LUX');

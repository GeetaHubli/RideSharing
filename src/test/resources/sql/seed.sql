USE RideSharing_test;

TRUNCATE TABLE cities;

INSERT INTO `cities` (`name`,`state`)
VALUES
  ('Bangalore', 'Karnataka'),
  ('Mumbai','Maharashtra'),
  ('Mysore', 'Karnataka'),
  ('Chennai','Tamilnadu');
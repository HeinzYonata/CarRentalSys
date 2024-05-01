DROP DATABASE IF EXISTS `carsDB`;
CREATE DATABASE `carsDB`;
USE `carsDB`;

CREATE TABLE car_tbl (
  id INT NOT NULL AUTO_INCREMENT,
  model VARCHAR(30) NOT NULL,
  year_manufactured INT NOT NULL,
  availability BOOLEAN NOT NULL,
  fee DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO car_tbl (model, year_manufactured, availability, fee)
VALUES
  ('Toyota Corolla' , 2024, true, 32.99),  
  ('Honda Civic' , 2023, true, 31.50),  
  ('Ford F-150' , 2024, true, 62.75),  
  ('Tesla Model 3' , 2023, true, 89.99),  
  ('Toyota Camry' , 2022, true, 35.25),  
  ('Honda CR-V' , 2021, true, 43.00),  
  ('Jeep Wrangler' , 2024, true, 72.50),  
  ('Hyundai Sonata' , 2023, true, 33.99),  
  ('Kia Telluride' , 2022, true, 55.00),  
  ('Volkswagen Jetta' , 2021, true, 29.75),  
  ('Nissan Altima' , 2024, true, 34.50),  
  ('Ford Mustang' , 2023, true, 52.25),  
  ('Toyota RAV4' , 2022, true, 45.75),  
  ('Subaru Outback' , 2021, true, 40.99),  
  ('Chevrolet Silverado' , 2024, true, 65.00),  
  ('BMW X3' , 2023, true, 78.50),  
  ('Honda Accord' , 2022, true, 37.99),  
  ('Mercedes-Benz C-Class' , 2021, true, 82.75),  
  ('Mazda CX-5' , 2020, true, 42.25),
  ('Panzer IV', 1943, true, 150.00),
  ('Tiger I', 1942, true, 200.00),
  ('Panther', 1943, true, 180.00),
  ('M4 Sherman', 1941, true, 120.00),
  ('M26 Pershing', 1944, true, 250.00),
  ('Churchill', 1941, true, 160.00),
  ('Cromwell', 1943, true, 170.00),
  ('T-34', 1940, true, 140.00),
  ('KV-1', 1939, true, 160.00),
  ('IS-2', 1943, true, 200.00),
  ('StuG III', 1940, true, 130.00),
  ('SU-85', 1943, true, 150.00),
  ('Sherman Firefly', 1944, true, 180.00),
  ('Tiger II', 1944, true, 250.00),
  ('KV-2', 1940, true, 170.00),
  ('Matilda II', 1939, true, 140.00),
  ('M3 Lee', 1941, true, 130.00),
  ('Jagdpanther', 1944, true, 200.00),
  ('KV-85', 1943, true, 180.00),
  ('ISU-152', 1943, true, 220.00),
  ('Hetzer', 1944, true, 190.00),
  ('M10 Wolverine', 1943, true, 180.00),
  ('Churchill Crocodile', 1943, true, 200.00),
  ('SU-100', 1944, true, 210.00);
















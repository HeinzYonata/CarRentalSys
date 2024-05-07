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
	('Toyota Corolla' , 2024, true, 1888.55),  -- 32.99 USD * 57.25 PHP/USD
	('Honda Civic' , 2023, true, 1803.75),  -- 31.50 USD * 57.25 PHP/USD
	('Ford F-150' , 2024, true, 3593.75),  -- 62.75 USD * 57.25 PHP/USD
	('Tesla Model 3' , 2023, true, 5156.25),  -- 89.99 USD * 57.25 PHP/USD
	('Toyota Camry' , 2022, true, 2028.75),  -- 35.25 USD * 57.25 PHP/USD
	('Honda CR-V' , 2021, true, 2478.75),  -- 43.00 USD * 57.25 PHP/USD
	('Jeep Wrangler' , 2024, true, 4156.25),  -- 72.50 USD * 57.25 PHP/USD
	('Hyundai Sonata' , 2023, true, 1953.75),  -- 33.99 USD * 57.25 PHP/USD
	('Kia Telluride' , 2022, true, 3162.50),  -- 55.00 USD * 57.25 PHP/USD
	('Volkswagen Jetta' , 2021, true, 1706.25),  -- 29.75 USD * 57.25 PHP/USD
	('Nissan Altima' , 2024, true, 1983.75),  -- 34.50 USD * 57.25 PHP/USD
	('Ford Mustang' , 2023, true, 3003.75),  -- 52.25 USD * 57.25 PHP/USD
	('Toyota RAV4' , 2022, true, 2643.75),  -- 45.75 USD * 57.25 PHP/USD
	('Subaru Outback' , 2021, true, 2353.13), -- 40.99 USD * 57.25 PHP/USD (rounded to 2 decimal places)
	('Chevrolet Silverado' , 2024, true, 3725.00),  -- 65.00 USD * 57.25 PHP/USD
	('BMW X3' , 2023, true, 4511.25),  -- 78.50 USD * 57.25 PHP/USD
	('Honda Accord' , 2022, true, 2183.75),  -- 37.99 USD * 57.25 PHP/USD
	('Mercedes-Benz C-Class' , 2021, true, 4746.88),  -- 82.75 USD * 57.25 PHP/USD (rounded to 2 decimal places)
	('Mazda CX-5' , 2020, true, 2423.75),  -- 42.25 USD * 57.25 PHP/USD
	('Dodge Challenger', 2023, true, 2831.25),
	('Audi A4', 2022, true, 4943.75),
	('Kia Sportage', 2023, true, 2218.75),
	('Chevrolet Camaro', 2022, true, 2937.50),
	('Nissan Frontier', 2021, true, 2312.50),
	('Toyota Tacoma', 2022, true, 2575.00),
	('Chrysler Pacifica', 2021, true, 3293.75),
	('Hyundai Tucson', 2023, true, 2078.75),
	('Subaru WRX', 2022, true, 2718.75),
	('Land Rover Discovery Sport', 2022, true, 5812.50),
	('Volvo XC60', 2021, true, 5237.50),
	('MINI Cooper', 2023, true, 2137.50),
	('Fiat 500', 2022, true, 1531.25),
	('Ram 1500', 2022, true, 3468.75),
	('Tesla Model Y', 2023, true, 6237.50),
	('Volkswagen Golf', 2022, true, 1881.25),
	('Ford Edge', 2021, true, 2787.50),
	('Buick Envision', 2022, true, 2456.25),
	('Acura RDX', 2022, true, 4218.75),
	('Lexus ES', 2021, true, 4875.00),
	('Panzer IV', 1943, true, 150.00 * 57.17),
	('Tiger I', 1942, true, 200.00 * 57.17),
	('Panther', 1943, true, 180.00 * 57.17),
	('M4 Sherman', 1941, true, 120.00 * 57.17),
	('M26 Pershing', 1944, true, 250.00 * 57.17),
	('Churchill', 1941, true, 160.00 * 57.17),
	('Cromwell', 1943, true, 170.00 * 57.17),
	('T-34', 1940, true, 140.00 * 57.17),
	('KV-1', 1939, true, 160.00 * 57.17),
	('IS-2', 1943, true, 200.00 * 57.17),
	('StuG III', 1940, true, 130.00 * 57.17),
	('SU-85', 1943, true, 150.00 * 57.17),
	('Sherman Firefly', 1944, true, 180.00 * 57.17),
	('Tiger II', 1944, true, 250.00 * 57.17),
	('KV-2', 1940, true, 170.00 * 57.17),
	('Matilda II', 1939, true, 140.00 * 57.17),
	('M3 Lee', 1941, true, 130.00 * 57.17),
	('Jagdpanther', 1944, true, 200.00 * 57.17),
	('KV-85', 1943, true, 180.00 * 57.17),
	('ISU-152', 1943, true, 220.00 * 57.17),
	('Hetzer', 1944, true, 190.00 * 57.17),
	('M10 Wolverine', 1943, true, 180.00 * 57.17),
	('Churchill Crocodile', 1943, true, 200.00 * 57.17),
	('SU-100', 1944, true, 210.00 * 57.17),
	('Flakpanzer IV Ostwind', 1944, true, 260.00 * 57.17),
	('Panzerwerfer', 1943, true, 250.00 * 57.17),
	('M5 Half-track', 1942, true, 190.00 * 57.17),
	('SdKfz 234', 1944, true, 200.00 * 57.17),
	('SdKfz 234 Puma', 1943, true, 220.00 * 57.17);
















DELETE FROM kurets.energy;
DELETE FROM kurets.panel;
DELETE FROM kurets.battery;
DELETE FROM kurets.adress;
DELETE FROM kurets.solar_system;
DELETE FROM kurets.owner;
DELETE FROM kurets.solar_system_has_owner;

ALTER TABLE kurets.energy AUTO_INCREMENT = 1;
ALTER TABLE kurets.panel AUTO_INCREMENT = 1;
ALTER TABLE kurets.battery AUTO_INCREMENT = 1;
ALTER TABLE kurets.adress AUTO_INCREMENT = 1;
ALTER TABLE kurets.solar_system AUTO_INCREMENT = 1;
ALTER TABLE kurets.owner AUTO_INCREMENT = 1;
ALTER TABLE kurets.solar_system_has_owner AUTO_INCREMENT = 1;

INSERT INTO kurets.energy (price_per_hour, energy_transfer)
VALUES (10, 100),
(20, 10),
(30, 50),
(5, 107),
(55, 41),
(43, 39),
(100, 55),
(3, 23),
(7, 11),
(26, 9);

INSERT INTO kurets.panel (power_in_hour,panel_life,type,angle_of_inclination, energy_id)
VALUES (20, 10, 'New', 30, 10),
(35, 1, 'Two', 22, 8),
(10, 5, 'ThreeInOne', 77, 6),
(200, 7, 'Old', 100, 4),
(100, 15, 'B/y',90, 1),
(77, 22, 'Electro', 10, 2),
(5, 33, 'Nevest', 31, 3),
(2, 17, 'New', 22, 5),
(22, 32, 'New', 33, 7),
(17, 8, 'New', 3, 9);

INSERT INTO kurets.battery (charge_level_per_hour,capacity,occupancy,duration_of_use_months)
VALUES (30, 10000, 65, 24),
(20, 10000, 20, 20),
(10, 7100, 30, 16),
(25, 89000, 25, 30),
(80, 100000, 15, 19),
(35, 100, 5, 74),
(5, 30000, 1, 99),
(7, 13000, 10, 5),
(21, 20000, 22, 20),
(33, 1000, 55, 12);

INSERT INTO kurets.adress (street, city, country)
VALUES ('Shevhenko34', 'Lviv', 'Urkaine'),
('Shevhenko34', 'Lviv', 'Urkaine'),
('Lykasha', 'Lviv', 'Urkaine'),
('Petryshevicha', 'Bolekhiv', 'Urkaine'),
('1 St S', 'Lucky Lake', 'Kanada'),
('Brooklyn', 'New Yourk', 'USA'),
('Mason St', 'New Yourk', 'USA'),
('Karla Marksa', 'Kyiv', 'Urkaine'),
('Miry', 'Ternopily', 'Urkaine'),
('Ivana Franka', 'Lviv', 'Urkaine');

INSERT INTO kurets.solar_system (power, panel_id, battery_id, adress_id)
VALUES (35,1,1,1),
(30,2,2,2),
(35,3,3,3),
(35,5,5,5),
(35,9,9,6),
(35,8,4,10),
(35,7,10,5),
(35,10,8,7),
(35,4,6,9),
(35,6,7,4);

INSERT INTO kurets.owner (name, age)
VALUES ('Stiven', 33),
('Kevin', 23),
('Nick', 55),
('Mark', 30),
('Kely', 63),
('Sara', 80),
('Morty', 61),
('Kelly', 28),
('Mort', 20),
('Amy', 18);

INSERT INTO kurets.solar_system_has_owner (solar_system_id, owner_id)
VALUES (6,1),
(4,2),
(8,9),
(9,5),
(3,8),
(5,4),
(7,7),
(1,3),
(2,6),
(10,10);
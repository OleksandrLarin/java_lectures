INSERT INTO car_model
VALUES
(1, 'A', 'Aston Martin Cygnet'),
(2, 'A', 'Fiat 500'),
(3, 'B', 'Hyundai Accent'),
(4, 'B', 'Ford Fiesta'),
(5, 'B', 'Volkswagen Polo'),
(6, 'C', 'Ford Focus'),
(7, 'C', 'Volkswagen Golf'),
(8, 'D', 'Ford Mondeo'),
(9, 'D', 'Volkswagen Passat'),
(10, 'E', 'Nissan Maxima'),
(11, 'E', 'Audi A6');

INSERT INTO car
VALUES
('ABE 2134', 7, '2012-01-01', 12),
('ABC 3256', 10, '2010-01-01', 14),
('ABE 4476', 3, '2018-01-01', 11),
('ACE 6532', 9, '2019-01-01', 20);

INSERT INTO account (id, amount)
VALUES
(1, 100),
(2, 55),
(3, 10),
(4, 9),
(5, 87),
(6, 125),
(7, 65),
(8, 98);

INSERT INTO users
VALUES
('B1856444', 'John White', 1),
('B9864752', 'Bill Morgan', 2),
('B7897555', 'Fillip Morrison', 3),
('C0215743', 'Edward Black', 4),
('B9986314', 'Robert Kings', 5),
('B1200354', 'Melica Brook', 6),
('B4500222', 'Stefani Fisker', 7),
('B1009805', 'Marta Hammer', 8);



INSERT INTO car_rent (car_number, driver_licence_id, rent_status, start_rent_date, end_rent_date)
VALUES
('ABE 2134', 'B7897555', 'COMPLETED', '2021-02-08', '2021-02-09'),
('ACE 6532', 'B7897555', 'COMPLETED', '2021-02-11', '2021-02-15'),
('ABE 2134', 'B7897555', 'IN_PROGRESS', '2021-03-01', '2021-02-05'),
('ABC 3256', 'B1856444', 'COMPLETED', '2021-01-08', '2021-01-11'),
('ABE 4476', 'B9986314', 'COMPLETED', '2021-02-08', '2021-02-09');


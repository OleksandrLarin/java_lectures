CREATE TYPE class_enum AS ENUM ('A', 'B', 'C', 'D', 'E');

CREATE TABLE car_model (
    id SERIAL PRIMARY KEY,
    car_class class_enum NOT NULL,
    model varchar(200)
);

CREATE TABLE car (
    number varchar(200) PRIMARY KEY,
    model_id int NOT NULL,
    manufacture_date Date,
    rent_price_per_day decimal NOT NULL,
    FOREIGN KEY (model_id) REFERENCES car_model(id)
);

CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    amount Decimal
);

CREATE TABLE users (
    driver_licence_id varchar(200) PRIMARY KEY,
    full_name varchar(200),
    account_id int,
    FOREIGN KEY (account_id) REFERENCES account(id)
);

CREATE TYPE status AS ENUM ('IN_PROGRESS', 'COMPLETED');

CREATE TABLE car_rent (
    id SERIAL PRIMARY KEY,
    car_number varchar(200),
    driver_licence_id varchar(200),
    rent_status status,
    start_rent_date Date,
    end_rent_date Date,
    FOREIGN KEY (car_number) REFERENCES car(number),
    FOREIGN KEY (driver_licence_id) REFERENCES users(driver_licence_id)
);

CREATE TABLE rent_price (
    id SERIAL PRIMARY KEY,
    price Decimal,
    FOREIGN KEY (id) REFERENCES car_rent(id)
);


CREATE SCHEMA demo;

CREATE TABLE IF NOT EXISTS demo.random_numbers
(
    id        serial primary key not null ,
    number  integer not null
);

INSERT INTO demo.random_numbers (number)
VALUES (floor(random() * 5 + 1));
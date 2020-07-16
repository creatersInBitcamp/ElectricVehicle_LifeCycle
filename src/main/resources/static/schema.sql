CREATE TABLE electric_vehicle
(
    `car_id`                 INT            NOT NULL    AUTO_INCREMENT,
    `manufacturer`           VARCHAR(45)    NULL,
    `trim`                   VARCHAR(45)    NULL,
    `manufacturing_yyyy_mm`  VARCHAR(45)    NULL,
    `price`                  VARCHAR(45)    NULL,
    `fuel_efficiency`        VARCHAR(45)    NULL,
    `rapid_charging`         VARCHAR(45)    NULL,
    `slow_charging`          VARCHAR(45)    NULL,
    `mileage`                VARCHAR(45)    NULL,
    `battery_capacity`       VARCHAR(45)    NULL,
    `subsidy`                VARCHAR(45)    NULL,
    `production_site`        VARCHAR(45)    NULL,
    `color`                  VARCHAR(45)    NULL,
    `technical_option`       VARCHAR(45)    NULL,
    `design_option`          VARCHAR(45)    NULL,
    PRIMARY KEY (car_id)
);
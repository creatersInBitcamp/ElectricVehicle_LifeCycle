CREATE TABLE electric_car
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
)default character set utf8 collate UTF8_GENERAL_CI;

CREATE TABLE market_price
(
    `id`                     INT            NULL        AUTO_INCREMENT,
    `car_type`               VARCHAR(45)    NULL,
    `depreciation_rate`      VARCHAR(45)    NULL,
    `car_id`                 INT            NULL,
    `manufacturing_yyyy_mm`  VARCHAR(45)    NULL,
    PRIMARY KEY (id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE market_price
    ADD CONSTRAINT FK_market_price_car_id_electric_car_car_id FOREIGN KEY (car_id)
        REFERENCES electric_car (car_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE residual_rate
(
    `car_type`       VARCHAR(45)    NULL,
    `durable_years`  VARCHAR(45)    NULL,
    `one_year`       INT            NULL,
    `two_years`      INT            NULL,
    `three_years`    INT            NULL,
    `four_years`     INT            NULL,
    `five_years`     INT            NULL
)default character set utf8 collate UTF8_GENERAL_CI;





CREATE TABLE insurance
(
    `insurance_product`      INT            NOT NULL    AUTO_INCREMENT,
    `carprice`               VARCHAR(45)    NULL,
    `residential_area`       VARCHAR(45)    NULL,
    `sortation`              VARCHAR(45)    NULL,
    `fuel_efficiency`        VARCHAR(45)    NULL,
    `acquisition_tax`        VARCHAR(45)    NULL,
    `public_bond`            VARCHAR(45)    NULL,
    `purchase_rate`          VARCHAR(45)    NULL,
    `rate_discount`          VARCHAR(45)    NULL,
    `discount_public_bonds`  VARCHAR(45)    NULL,
    `additional_amount`      VARCHAR(45)    NULL,
    `order_id`               VARCHAR(45)    NULL,
    PRIMARY KEY (insurance_product)
);


-- insurance Table Create SQL
CREATE TABLE purchase
(
    `order_id`           INT            NOT NULL    AUTO_INCREMENT,
    `purchasing_method`  VARCHAR(45)    NULL,
    `purchase_time`      VARCHAR(45)    NULL,
    `purchase_amount`    VARCHAR(45)    NULL,
    `car_id`             INT            NULL,
    `user_id`            VARCHAR(45)    NULL,
    PRIMARY KEY (order_id)
);

ALTER TABLE purchase
    ADD CONSTRAINT FK_purchase_order_id_insurance_order_id FOREIGN KEY (order_id)
        REFERENCES insurance (order_id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- insurance Table Create SQL
CREATE TABLE registration
(
    `registration_cost`           INT            NOT NULL    AUTO_INCREMENT,
    `insurance_start_date`        VARCHAR(45)    NULL,
    `insurance_termination_date`  VARCHAR(45)    NULL,
    `manufacturer`                VARCHAR(45)    NULL,
    `car_name`                    VARCHAR(45)    NULL,
    `registration_year`           VARCHAR(45)    NULL,
    `detailed_car_name`           VARCHAR(45)    NULL,
    `detailed_list`               VARCHAR(45)    NULL,
    `expected_insurance`          VARCHAR(45)    NULL,
    `insurance_link`              VARCHAR(45)    NULL,
    PRIMARY KEY (registration_cost)
);


-- insurance Table Create SQL
CREATE TABLE comparison
(
    `car_id`              INT            NOT NULL    AUTO_INCREMENT,
    `manufacturer`        VARCHAR(45)    NULL,
    `manufacturing_year`  VARCHAR(45)    NULL,
    `price`               VARCHAR(45)    NULL,
    `fuel_efficiency`     VARCHAR(45)    NULL,
    `cc`                  VARCHAR(45)    NULL,
    `mile_age`            VARCHAR(45)    NULL,
    `make`                VARCHAR(45)    NULL,
    `picture`             VARCHAR(45)    NULL,
    `order_id`            VARCHAR(45)    NULL,
    PRIMARY KEY (car_id)
);


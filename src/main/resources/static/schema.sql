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

CREATE TABLE user
(
    `id`             INT            NOT NULL    AUTO_INCREMENT,
    `user_id`        VARCHAR(45)    NULL,
    `password`       VARCHAR(45)    NULL,
    `addr`           VARCHAR(70)    NULL,
    `register_date`  DATETIME       NULL,
    `name`           VARCHAR(45)    NULL,
    `ssr`            VARCHAR(45)    NULL,
    `email`          VARCHAR(45)    NULL,
    `phone_number`   VARCHAR(45)    NULL,
    `visit_count`    INT            NULL,
    `nickname`       VARCHAR(45)    NULL,
    `sns_confirm`    VARCHAR(45)    NULL,
    `email_confirm`  VARCHAR(45)    NULL,
    `grade`          VARCHAR(45)    NULL,
    `ban_date`       DATETIME       NULL,
    `profile_image`  VARCHAR(45)    NULL,
    `profile_text`   VARCHAR(45)    NULL,
    `admin_check`    VARCHAR(45)    NULL,
    `payment_info`   VARCHAR(45)    NULL,
    PRIMARY KEY (id, user_id)
);


-- user Table Create SQL
CREATE TABLE user_car
(
    `id`             INT            NOT NULL    AUTO_INCREMENT,
    `car_number`     VARCHAR(45)    NULL,
    `register_date`  VARCHAR(45)    NULL,
    `user_id`        VARCHAR(45)    NULL,
    `car_id`         VARCHAR(45)    NULL,
    PRIMARY KEY (id)
);

ALTER TABLE user_car
    ADD CONSTRAINT FK_user_car_user_id_user_user_id FOREIGN KEY (user_id)
        REFERENCES user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;


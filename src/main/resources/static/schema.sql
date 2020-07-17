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

-- sights Table Create SQL
CREATE TABLE sights
(
    `sights_id`       INT             NOT NULL    AUTO_INCREMENT COMMENT '관광지아이디',
    `name`            VARCHAR(45)     NULL        COMMENT '이름',
    `street_address`  VARCHAR(45)     NULL        COMMENT '소재지도로명주소',
    `branch_address`  VARCHAR(45)     NULL        COMMENT '소재지지번주소',
    `x_value`         VARCHAR(45)     NULL        COMMENT '위도',
    `y_value`         VARCHAR(45)     NULL        COMMENT '경도',
    `capacity`        INT             NULL        COMMENT '수용인원수',
    `parking_lot`     INT             NULL        COMMENT '주차가능수',
    `info`            VARCHAR(300)    NULL        COMMENT '관광지소개',
    PRIMARY KEY (sights_id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE sights COMMENT '관광지';


-- sights Table Create SQL
CREATE TABLE fare
(
    `fare_id`         INT            NOT NULL    AUTO_INCREMENT COMMENT '통행요금아이디',
    `start_name`      VARCHAR(45)    NULL        COMMENT '출발지톨게이트명',
    `arrive_name`     VARCHAR(45)    NULL        COMMENT '도착톨게이트명',
    `type_one`        VARCHAR(45)    NULL        COMMENT '요금1종',
    `type_two`        VARCHAR(45)    NULL        COMMENT '요금2종',
    `type_three`      VARCHAR(45)    NULL        COMMENT '요금3종',
    `type_four`       VARCHAR(45)    NULL        COMMENT '요금4종',
    `type_five`       VARCHAR(45)    NULL        COMMENT '요금5종',
    `type_light_car`  VARCHAR(45)    NULL        COMMENT '요금경차',
    PRIMARY KEY (fare_id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE fare COMMENT '고속도로 통행요금';


-- sights Table Create SQL
CREATE TABLE highway
(
    `highway_id`  INT            NOT NULL    AUTO_INCREMENT COMMENT '고속도로아이디',
    `unit_name`   VARCHAR(45)    NULL        COMMENT '톨게이트이름',
    `route_no`    VARCHAR(45)    NULL        COMMENT '노선번호',
    `route_name`  VARCHAR(45)    NULL        COMMENT '고속도로명',
    `y_value`     VARCHAR(45)    NULL        COMMENT '경도',
    `x_value`     VARCHAR(45)    NULL        COMMENT '위도',
    PRIMARY KEY (highway_id, unit_name)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE highway COMMENT '고속도로';


-- sights Table Create SQL
CREATE TABLE bookmark
(
    `bookmark_id`          INT    NOT NULL    AUTO_INCREMENT COMMENT '즐겨찾기아이디',
    `sights_id`            INT    NULL        COMMENT '관광지아이디',
    `charging_station_id`  INT    NULL        COMMENT '충전소아이디',
    `user_id`              INT    NULL        COMMENT '유저아이디',
    PRIMARY KEY (bookmark_id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE bookmark COMMENT '즐겨찾기';

ALTER TABLE bookmark
    ADD CONSTRAINT FK_bookmark_sights_id_sights_sights_id FOREIGN KEY (sights_id)
        REFERENCES sights (sights_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

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
>>>>>>> newcar


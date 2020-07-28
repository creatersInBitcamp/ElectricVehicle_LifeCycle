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


CREATE TABLE car
(
    `car_id`                    INT            NOT NULL    AUTO_INCREMENT COMMENT '차 아이디',
    `car_name`                  VARCHAR(45)    NULL        COMMENT '이름',
    `brand`                     VARCHAR(45)    NULL        COMMENT '브랜드',
    `price`                     VARCHAR(45)    NULL        COMMENT '가격',
    `engine_type`               VARCHAR(45)    NULL        COMMENT '엔진형식',
    `supercharge_method`        VARCHAR(45)    NULL        COMMENT '과급방식',
    `exhaust_volume`            VARCHAR(45)    NULL        COMMENT '배기량',
    `fuel`                      VARCHAR(45)    NULL        COMMENT '연료',
    `fuel_efficiency`           VARCHAR(45)    NULL        COMMENT '연비(등급)',
    `passengers_number`         VARCHAR(45)    NULL        COMMENT '승차인원',
    `driving_method`            VARCHAR(45)    NULL        COMMENT '구동방식',
    `transmission`              VARCHAR(45)    NULL        COMMENT '변속기',
    `maximum_output`            VARCHAR(45)    NULL        COMMENT '최대출력',
    `maximum_torque`            VARCHAR(45)    NULL        COMMENT '최대토크',
    `top_Speed`                 VARCHAR(45)    NULL        COMMENT '최고속도',
    `acceleration_performance`  VARCHAR(45)    NULL        COMMENT '가속성능(0-100 km/h)',
    `CO2_emissions`             VARCHAR(45)    NULL        COMMENT 'CO²배출량',
    `length`                    VARCHAR(45)    NULL        COMMENT '전장',
    `width`                     VARCHAR(45)    NULL        COMMENT '전폭',
    `height`                    VARCHAR(45)    NULL        COMMENT '전고',
    `wheel_base`                VARCHAR(45)    NULL        COMMENT '축거',
    `front_distance`            VARCHAR(45)    NULL        COMMENT '윤거전',
    `back_distance`             VARCHAR(45)    NULL        COMMENT '윤거후',
    `weight`                    VARCHAR(45)    NULL        COMMENT '공차중량',
    `front_wheel`               VARCHAR(45)    NULL        COMMENT '전륜타이어',
    `rear_wheel`                VARCHAR(45)    NULL        COMMENT '후륜타이어',
    `front_suspension`          VARCHAR(45)    NULL        COMMENT '전륜서스펜션',
    `rear_suspension`           VARCHAR(45)    NULL        COMMENT '후륜서스펜션',
    `front_braking`             VARCHAR(45)    NULL        COMMENT '전륜제동장치',
    `rear_braking`              VARCHAR(45)    NULL        COMMENT '후륜제동장치',
    `steering`                  VARCHAR(45)    NULL        COMMENT '스티어링',
    `img`                       VARCHAR(45)    NULL        COMMENT '사진',
    PRIMARY KEY (car_id)
);

ALTER TABLE car COMMENT '자동차';

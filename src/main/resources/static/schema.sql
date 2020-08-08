/*사용자*/
CREATE TABLE user
(
    `user_seq`             INT            NOT NULL    AUTO_INCREMENT,
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
    PRIMARY KEY (user_seq)
);

ALTER TABLE user COMMENT '사용자';



/*전기차*/
CREATE TABLE eccar
(
    `eccar_id`                  INT            NOT NULL    AUTO_INCREMENT        COMMENT '차 아이디',
    `car_name`                  VARCHAR(45)    NULL        COMMENT '이름',
    `yyyy`                      VARCHAR(45)    NULL        COMMENT '연형',
    `model_name`                VARCHAR(45)    NULL        COMMENT '모델명',
    `trim`                      VARCHAR(45)    NULL        COMMENT '트림',
    `brand`                     VARCHAR(45)    NULL        COMMENT '브랜드',
    `price`                     VARCHAR(45)    NULL        COMMENT '가격',
    `fuel`                      VARCHAR(45)    NULL        COMMENT '연료',
    `fuel_efficiency`           VARCHAR(45)    NULL        COMMENT '연비(등급)',
    `passengers_number`         VARCHAR(45)    NULL        COMMENT '승차인원',
    `driving_method`            VARCHAR(45)    NULL        COMMENT '구동방식',
    `transmission`              VARCHAR(45)    NULL        COMMENT '변속기',
    `distance_driven`           VARCHAR(45)    NULL        COMMENT '1회 충전 주행가능거리',
    `energy`                    VARCHAR(45)    NULL        COMMENT '에너지용량',
    `maximum_output`            VARCHAR(45)    NULL        COMMENT '모터최대출력',
    `maximum_torque`            VARCHAR(45)    NULL        COMMENT '모터최대토크',
    `acceleration_performance`  VARCHAR(45)    NULL        COMMENT '가속성능(0-100 km/h)',
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
    `boosting_charge`           VARCHAR(45)    NULL        COMMENT '급속충전',
    `slow_charging`             VARCHAR(45)    NULL        COMMENT '완속충전',
    `color`                     VARCHAR(45)    NULL        COMMENT '색상',
    `eol`                       boolean        NULL        COMMENT '단종(End of Life)',
    PRIMARY KEY (eccar_id)
);

ALTER TABLE eccar COMMENT '전기차';

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

ALTER TABLE purchase COMMENT '구매';

ALTER TABLE purchase
    ADD CONSTRAINT FK_purchase_order_id_insurance_order_id FOREIGN KEY (order_id)
        REFERENCES insurance (order_id) ON DELETE RESTRICT ON UPDATE RESTRICT;



/*서비스*/
CREATE TABLE charging_station
(
    `unit_name`            VARCHAR(45)     NULL        COMMENT '충전소명',
    `charging_station_id`  INT(11)             NOT NULL AUTO_INCREMENT   COMMENT '충전소아이디',
    `charger_id`           VARCHAR(45)     NULL        COMMENT '충전기ID',
    `charger_type`         INT             NULL        COMMENT '충전기타입',
    `address`              VARCHAR(200)    NULL        COMMENT '주소',
    `x_value`              VARCHAR(45)     NULL        COMMENT '위도',
    `y_value`              VARCHAR(45)     NULL        COMMENT '경도',
    `business_hours`       VARCHAR(45)     NULL        COMMENT '이용가능시간',
    `agency_name`          VARCHAR(45)     NULL        COMMENT '운영기관명',
    `phone`                VARCHAR(45)     NULL        COMMENT '연락처',
    `charger_state`        INT             NULL        COMMENT '충전기상태',
    `update_date`          VARCHAR(45)     NULL        COMMENT '상태갱신일시',
    `boosting_charge`      VARCHAR(45)     NULL        COMMENT '급속충전',
    PRIMARY KEY (charging_station_id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE charging_station COMMENT '충전소';

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


CREATE TABLE bookmark
(
    `bookmark_id`          INT    NOT NULL    AUTO_INCREMENT COMMENT '즐겨찾기아이디',
    `sights_id`            INT    NULL        COMMENT '관광지아이디',
    `charging_station_id`  INT    NULL        COMMENT '충전소아이디',
    `user_seq`              INT    NULL        COMMENT '유저아이디',
    PRIMARY KEY (bookmark_id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE bookmark COMMENT '즐겨찾기';

ALTER TABLE bookmark
    ADD CONSTRAINT FK_bookmark_sights_id_sights_sights_id FOREIGN KEY (sights_id)
        REFERENCES sights (sights_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE bookmark
    ADD CONSTRAINT FK_bookmark_charger_id_charging_station_charging_station_id FOREIGN KEY (charger_id)
        REFERENCES charging_station (charging_station_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE bookmark
    ADD CONSTRAINT FK_bookmark_user_seq_user_seq FOREIGN KEY (user_seq)
        REFERENCES user (user_seq) ON DELETE RESTRICT ON UPDATE RESTRICT;



/*참조테이블*/
CREATE TABLE information
(
    `info_id`           INT            NOT NULL    AUTO_INCREMENT COMMENT '정보아이디',
    `car_name`          VARCHAR(45)    NULL        COMMENT '모델명',
    `boosting_charge`   VARCHAR(45)    NULL        COMMENT '급속충전',
    `slow_charging`     VARCHAR(45)    NULL        COMMENT '완속충전',
    `battery_capacity`  VARCHAR(45)    NULL        COMMENT '배터리용량',
    `brand`             VARCHAR(45)    NULL        COMMENT '브랜드',
    `release_date`      VARCHAR(45)    NULL        COMMENT '출시일',
    PRIMARY KEY (info_id)
);

ALTER TABLE information COMMENT '전기차모델정보';
CREATE TABLE car
(
    `car_id`                    INT(11)        NOT NULL   AUTO_INCREMENT  COMMENT '차 아이디',
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
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE car COMMENT '자동차';

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



/*사용자*/
CREATE TABLE user
(
    `user_seq`             INT            NOT NULL    AUTO_INCREMENT,
    `user_id`        VARCHAR(45)    NULL,
    `password`       VARCHAR(45)    NULL,
    `register_date`  VARCHAR(45)    NULL,
    `addr`           VARCHAR(70)    NULL,
    `name`           VARCHAR(45)    NULL,
    `sex`            VARCHAR(45)    NULL,
    `birth_date`     VARCHAR(45)    NULL,
    `email`          VARCHAR(45)    NULL,
    `phone_number`   VARCHAR(45)    NULL,
    `visit_count`    INT            NULL,
    `sns_confirm`    boolean        NULL,
    `email_confirm`  boolean        NULL,
    `grade`          INT            NULL,
    `ban_date`       DATETIME       NULL,
    `profile_image`  VARCHAR(45)    NULL,
    `profile_text`   VARCHAR(45)    NULL,
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
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE eccar COMMENT '전기차';

CREATE TABLE used_car
(
    `usedcar_id`    INT(11)        NOT NULL    AUTO_INCREMENT COMMENT '중고차 아이디',
    `price`         VARCHAR(45)    NULL        DEFAULT NULL COMMENT '중고가격',
    `age`           VARCHAR(45)    NULL        DEFAULT NULL COMMENT '연식',
    `mileage`       VARCHAR(45)    NULL        DEFAULT NULL COMMENT '주행거리',
    `img_id`        INT            NULL        DEFAULT NULL COMMENT '이미지',
    `user_seq`      INT(11)        NULL        DEFAULT NULL COMMENT '사용자아이디',
    `eccar_id`      INT(11)        NULL        DEFAULT NULL COMMENT '차 아이디',
    PRIMARY KEY (usedcar_id)
);

ALTER TABLE used_car COMMENT '중고차';

ALTER TABLE used_car
    ADD CONSTRAINT FK_used_car_user_seq_user_user_seq FOREIGN KEY (user_seq)
        REFERENCES user (user_seq) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE used_car
    ADD CONSTRAINT FK_used_car_eccar_id_eccar_eccar_id FOREIGN KEY (eccar_id)
        REFERENCES eccar (eccar_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE used_car
    ADD CONSTRAINT FK_used_car_img_id_img_img_id FOREIGN KEY (img_id)
        REFERENCES img (img_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE purchase
(
    `order_id`           INT            NOT NULL    AUTO_INCREMENT COMMENT '주문번호',
    `purchasing_method`  VARCHAR(45)    NULL        COMMENT '구매방식',
    `purchase_time`      VARCHAR(45)    NULL        COMMENT '구매일시',
    `purchase_amount`    VARCHAR(45)    NULL        COMMENT '구매 양',
    `purchase_price`     VARCHAR(45)    NULL        COMMENT '구매 금액',
    `user_seq`           INT            NULL        COMMENT '사용자아이디',
    `eccar_id`           INT            NULL        COMMENT '전기차 아이디',
    PRIMARY KEY (order_id)
);

ALTER TABLE purchase COMMENT '구매';

ALTER TABLE purchase
    ADD CONSTRAINT FK_purchase_eccar_id_eccar_eccar_id FOREIGN KEY (eccar_id)
        REFERENCES eccar (eccar_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE purchase
    ADD CONSTRAINT FK_purchase_user_seq_user_user_seq FOREIGN KEY (user_seq)
        REFERENCES user (user_seq) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE wishlist
(
    `wishlist_id`  INT    NOT NULL    AUTO_INCREMENT COMMENT '찜하기id',
    `user_seq`     INT    NULL        COMMENT '사용자아이디',
    `eccar_id`     INT    NULL        COMMENT '전기차 아이디',
    PRIMARY KEY (wishlist_id)
);

ALTER TABLE wishlist COMMENT '찜하기';

ALTER TABLE wishlist
    ADD CONSTRAINT FK_wishlist_user_seq_user_user_seq FOREIGN KEY (user_seq)
        REFERENCES user (user_seq) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE wishlist
    ADD CONSTRAINT FK_wishlist_eccar_id_eccar_eccar_id FOREIGN KEY (eccar_id)
        REFERENCES eccar (eccar_id) ON DELETE RESTRICT ON UPDATE RESTRICT;



/*서비스*/
CREATE TABLE charging_station
(
    `charging_station_id`  INT             NOT NULL AUTO_INCREMENT   COMMENT '충전소아이디',
    `unit_name`            VARCHAR(45)     NULL        COMMENT '충전소명',
    `charger_id`           VARCHAR(45)     NULL        COMMENT '충전기ID',
    `charger_type`         INT             NULL        COMMENT '충전기타입',
    `charger_state`        VARCHAR(45)     NULL        COMMENT '충전기상태',
    `address`              VARCHAR(200)    NULL        COMMENT '주소',
    `x_value`              double          NULL        COMMENT '위도',
    `y_value`              double          NULL        COMMENT '경도',
    `business_hours`       VARCHAR(45)     NULL        COMMENT '이용가능시간',
    `agency_name`          VARCHAR(45)     NULL        COMMENT '운영기관명',
    `phone`                VARCHAR(45)     NULL        COMMENT '연락처',
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
    `x_value`         double          NULL        COMMENT '위도',
    `y_value`         double          NULL        COMMENT '경도',
    `capacity`        INT             NULL        COMMENT '수용인원수',
    `parking_lot`     INT             NULL        COMMENT '주차가능수',
    `info`            VARCHAR(300)    NULL        COMMENT '관광지소개',
    PRIMARY KEY (sights_id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE sights COMMENT '관광지';

CREATE TABLE bookmarky_value
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
    ADD CONSTRAINT FK_bookmark_charger_id_charging_station_charging_station_id FOREIGN KEY (charging_station_id)
        REFERENCES charging_station (charging_station_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE bookmark
    ADD CONSTRAINT FK_bookmark_user_seq_user_seq FOREIGN KEY (user_seq)
        REFERENCES user (user_seq) ON DELETE RESTRICT ON UPDATE RESTRICT;

/*게시글*/
CREATE TABLE post
(
    `post_id`         INT            NOT NULL    AUTO_INCREMENT COMMENT '포스트 아이디',
    `link`            VARCHAR(45)    NULL        COMMENT '기사링크',
    `title`           VARCHAR(45)    NULL        COMMENT '제목',
    `ban_date`        VARCHAR(45)    NULL        COMMENT '작성일자',
    `img`             VARCHAR(45)    NULL        COMMENT '이미지링크',
    `content`         VARCHAR(45)    NULL        COMMENT '내용',
    `recommendation`  INT            NULL        COMMENT '추천수',
    `hits`            INT            NULL        COMMENT '조회수',
    `user_seq`        INT            NULL        COMMENT '사용자아이디',
    PRIMARY KEY (post_id)
);

ALTER TABLE post COMMENT '포스트, 게시글';

ALTER TABLE post
    ADD CONSTRAINT FK_post_user_seq_user_user_seq FOREIGN KEY (user_seq)
        REFERENCES user (user_seq) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE comment
(
    `comment_id`  INT            NOT NULL    AUTO_INCREMENT COMMENT '코멘트 아이디',
    `reg_date`    VARCHAR(45)    NULL        COMMENT '등록일',
    `comment`     VARCHAR(45)    NULL        COMMENT '내용',
    `user_seq`    INT            NULL        COMMENT '사용자아이디',
    `post_id`     INT            NULL        COMMENT '포스트 아이디',
    PRIMARY KEY (comment_id)
);

ALTER TABLE comment COMMENT '댓글';

ALTER TABLE comment
    ADD CONSTRAINT FK_comment_post_id_post_post_id FOREIGN KEY (post_id)
        REFERENCES post (post_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE comment
    ADD CONSTRAINT FK_comment_user_seq_user_user_seq FOREIGN KEY (user_seq)
        REFERENCES user (user_seq) ON DELETE RESTRICT ON UPDATE RESTRICT;



/*참조테이블*/
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


/*이미지*/
CREATE TABLE img
(
    `img_id`       INT            NOT NULL    AUTO_INCREMENT COMMENT '이미지아이디',
    `img_name`     VARCHAR(45)    NULL        COMMENT '이미지이름',
    `img_file`     VARCHAR(45)    NULL        COMMENT '이미지파일',
    `upload_date`  DATETIME       NULL        COMMENT '등록일자',
    `category`     VARCHAR(45)    NULL        COMMENT '카테고리',
    PRIMARY KEY (img_id)
)default character set utf8 collate UTF8_GENERAL_CI;

ALTER TABLE img COMMENT '이미지';

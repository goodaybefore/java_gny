/*
의류쇼핑몰 구축시 필요한 테이블 구조를 잡아보기

- 장바구니 기능 없음, 한 제품의 옵션을 하나만 선택해서 여러개 구매할 수 있다.
	ex) A제품 빨강 L / A 제품 파랑 L 두 제품을 구매하려면 A제품 빨강 L을 구매 후 파랑 L 제품을 구매해야한다.
- 의류 구매 가능
- 배송 정보는 회원 주소로 사용(고정) - ERD 설계에선 여러주소도 해봤음
- 결제 정보 관리 기능 없음 
- 구매는 회원만 가능
- 쿠폰이나 할인 없음
- 제품
	분류방법 - 대분류르 상하의 구분 후 중분류로 니트 셔츠 등 구분
    
*/
create database shoppingmall;
use shoppingmall;
CREATE TABLE `goods` (
	`gd_num`	varchar(10)	NOT NULL,
	`gd_name`	varchar(50)	NULL,
	`gd_price`	int	NULL,
	`gd_detail`	longtext	NULL,
	`gd_ca_num`	int	NOT NULL
);

CREATE TABLE `option` (
	`op_num`	int	NOT NULL AUTO_INCREMENT,
	`op_color`	varchar(10)	NULL,
	`op_size`	varchar(10)	NULL,
	`op_stock`	int	NULL,
	`op_gd_num`	varchar(10)	NOT NULL,
    PRIMARY KEY(op_num)
);

CREATE TABLE `category` (
	`ca_num`	int	NOT NULL AUTO_INCREMENT,
	`ca_main`	varchar(10)	NULL,
	`ca_sub`	varchar(10)	NULL,
    PRIMARY KEY(ca_num)
);

CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_pw`	varchar(225)	NULL,
	`me_name`	varchar(30)	NULL,
	`me_phone`	varchar(13)	NULL,
	`me_gender`	varchar(10)	NULL,
	`me_ad_num`	int	NOT NULL
);

CREATE TABLE `address` (
	`ad_num`	int	NOT NULL AUTO_INCREMENT,
	`ad_nickname`	varchar(20)	NULL,
	`ad_address`	varchar(50)	NULL,
	`ad_post_num`	varchar(10)	NULL,
	`ad_detail`	varchar(50)	NULL,
    PRIMARY KEY(ad_num)
);

CREATE TABLE `order` (
	`or_num`	varchar(15)	NOT NULL,
	`or_me_id`	varchar(20)	NOT NULL,
	`or_op_num`	int	NOT NULL,
	`or_date`	datetime	NULL,
	`or_amount`	int	NULL,
	`or_total_price`	int	NULL,
	`or_state`	varchar(10)	NULL
);

CREATE TABLE `review` (
	`re_num`	int	NOT NULL AUTO_INCREMENT,
	`re_title`	varchar(100)	NULL,
	`re_content`	longtext	NULL,
	`re_date`	datetime	NULL,
	`re_gd_num`	varchar(10)	NOT NULL,
	`re_me_id`	varchar(20)	NOT NULL,
    PRIMARY KEY(re_num)
);

ALTER TABLE `goods` ADD CONSTRAINT `PK_GOODS` PRIMARY KEY (
	`gd_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);


ALTER TABLE `order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`or_num`
);


ALTER TABLE `goods` ADD CONSTRAINT `FK_category_TO_goods_1` FOREIGN KEY (
	`gd_ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `option` ADD CONSTRAINT `FK_goods_TO_option_1` FOREIGN KEY (
	`op_gd_num`
)
REFERENCES `goods` (
	`gd_num`
);

ALTER TABLE `member` ADD CONSTRAINT `FK_address_TO_member_1` FOREIGN KEY (
	`me_ad_num`
)
REFERENCES `address` (
	`ad_num`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`or_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_option_TO_order_1` FOREIGN KEY (
	`or_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_goods_TO_review_1` FOREIGN KEY (
	`re_gd_num`
)
REFERENCES `goods` (
	`gd_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_member_TO_review_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);


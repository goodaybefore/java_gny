

-- 카테고리항목 추가
-- INSERT INTO category(ca_main, ca_sub) VALUES
-- 	('아우터', '점퍼'), ('아우터', '코트'),('상의', '티셔츠'),('상의', '블라우스/셔츠'),('하의', '데님'),('하의', '팬츠'),('하의', '스커트');
SELECT * FROM shoppingmall.category;

-- 제품등록
INSERT INTO goods VALUES(1, '아크 폭스터 패딩', 159000,'패딩입니다', 1),
	(2, '엘비아 앙모코트', 219000,'앙모코트입니다', 2),
	(3, '클로 다운후드', 99000,'다운후드입니다', 3),
	(4, '파코 레이어드탑', 43000,'탑', 4),
	(5, '기모 와이드 데님 팬츠', 43000,'팬츠', 5),
	(6, '롤스 버튼 팬츠', 36000,'팬츠임니다', 5);
SELECT * FROM shoppingmall. goods;

-- 아이디가 abc123, 비번 abc123, 홍길동, 폰번 010-1234-5678, 성별남자, 주소 청주시, 우편번호 1234, 주소상세 그린컴퓨터학원인 회원이가입
-- INSERT INTO address(ad_nickname, ad_address, ad_post_num, ad_detail) VALUES (NULL,'청주시',1234,'그린컴퓨터학원');
-- INSERT INTO member(me_id, me_pw, me_name, me_phone, me_gender, me_ad_num) VALUES ('abc123','abc123','홍길동','010-1234-5678','남성',1);
SET foreign_key_checks = 0;

-- abc123 회원이 주문한 아크 폭스터 패딩에 리뷰를 작성
-- INSERT INTO review VALUES(1, '패딩좋아요', '따뜻하고좋아요', now(), 1, "abc123");
SELECT * FROM review;

SELECT * FROM shoppingmall.member;
SELECT * FROM address;


SELECT * FROM shoppingmall.order;
SELECT * FROM shoppingmall.option;
-- 아크폭스터패딩 S사이즈, 화이트인 제품이 10개 입고됨
-- INSERT INTO `option` VALUES(1, 'WHITE', 'S', 10, 1);


-- abc123회원이 아크폭스터 패딩 white, S사이즈를 1개 구매
-- INSERT INTO `order` VALUES('2021HNT001', 1, 1, now(), 1, 159000, '상태');

-- UPDATE
-- UPDATE `option` SET op_stock=1 WHERE op_num=1;


-- 아우터 모든 제품을 확인하는 쿼리문 작성
SELECT * FROM goods JOIN category
	ON ca_num = gd_ca_num
    WHERE ca_main = "아우터";
    
-- 분류가 아우터이고 구매가능한 모든제품 확인
SELECT gd_name FROM goods JOIN category
	ON ca_num = gd_ca_num
    JOIN `option` ON op_gd_num = gd_num
    WHERE ca_main = "아우터" AND op_stock>0;


-- 분류가 아우터이고 가장 많이 팔린 제품 4가지 확인

-- 어렵당,,,, 4가지 조건 어캐걸지 그룹바이 써야하는데 어캐써야할지 몰게쓰
SELECT * FROM goods JOIN category
	ON ca_num = gd_ca_num
    JOIN `order` ON or_op_num = gd_num
    JOIN `option` ON op_gd_num=gd_num
    WHERE ca_main = "아우터" ORDER BY or_amount DESC;


-- 강사님
SELECT goods.* FROM `order` JOIN `option` ON or_op_num = op_num
	JOIN goods ON gd_num = op_gd_num
    JOIN category ON ca_num = gd_ca_num
    WHERE ca_main = '아우터' AND or_state != "취소" AND or_state != "환불"
    GROUP BY gd_num
    ORDER BY sum(or_amount) DESC
    LIMIT 4;


SELECT * FROM `order`;
SELECT * FROM goods;
SELECT * FROM shoppingmall.option;


-- 등록된 아우터 제품의 전체 제품의 개수를 확인(재고량x)
SELECT count(*) FROM goods JOIN category
	ON ca_num = gd_ca_num
    WHERE ca_main = "아우터";

-- 등록된 아우터 제품을 10개씩 화면에 출력할 때 2페이지에 해당하는 제품을 확인
SELECT * FROM goods JOIN category
	ON ca_num = gd_ca_num
    WHERE ca_main = "아우터"
    LIMIT 10, 10;


-- abc123회원이 주문한 횟수
SELECT COUNT(*) AS '주문횟수' FROM `order` WHERE or_me_id="abc123";

-- abc123 회원의 상반기 사용금액
SELECT sum(or_total_price) FROM `order` JOIN `member` ON or_me_id=me_id WHERE me_id="abc123" AND or_date LIKE '2021%' AND or_date<'2021-07-01';

SELECT * FROM `order`;
SELECT * FROM `member`;


-- 아크폭스터 패딩에 달린 리뷰들 확인
SELECT re_title, re_content FROM review JOIN goods ON re_gd_num = gd_num WHERE gd_name = "아크 폭스터 패딩";
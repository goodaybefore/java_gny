/*
트리거 : 테이블에 대한 이벤트에 반읗애 자동으로 실행되는 작업
	   데이터 무결성을 지킬 수 있다 => 연관된 테이블간의 데이터 일관성을 유지
트리거 사용방법 
1 트리거 생성 (★생성하는게 어려움)
2 이벤트를 발생

타이밍 뒤 : 이벤트 실행 전에 동작시킬건지/실행된 다음에 동작시킬건지
이벤트명 뒤 : 어떤 동작을 했을 때 트리거를 동작시킬 것인지 

delimiter// <- 문장의 끝을 의미하는게 //로 바뀐다
CREATE TRIGGER 트리거명 타이밍(AFTER|BEFORE) 이벤트명(INSERT|UPDATE|DELETE) ON 테이블명
FOR EACH ROW
BEGIN
-- 실행코드 ...
END// <- 문장의 끝을 의미.
delimiter ;

<실행코드안에서 쓸 수 있는 것>
OLD : UPDATE 이벤트 발생 시 사용 가능. 값이 바뀌기 전의 행
NEW : INSERT, UPDATE 이벤트 발생 시 사용. 값이 바뀐 후의 행 또는 새로 추가된 행

변수 생성 방법
DECLARE 변수명 자료형 DFEAULT 기본값;

변수값 변경방법
SET 변수명 = 값;
SET 변수명 = (SELECT 검색결과);
*/

USE fruit_ny;
DROP TRIGGER IF EXISTS insert_buy;

DELIMITER //
CREATE TRIGGER insert_buy AFTER INSERT ON buy
FOR EACH ROW
BEGIN
-- 구매한 과일의 수량 : new.bu_amount
-- 구매한 과일의 이름 : new.bu_fr_name
UPDATE fruit
	SET
		fr_amount = fr_amount + new.bu_amount
	WHERE
		fr_name = new.bu_fr_name;
END //
DELIMITER ;

SELECT * FROM fruit;
SELECT * FROM buy;
SET foreign_key_checks = 0;
 -- INSERT INTO buy VALUES(3, "바나나", 2, now(), '송이', '과일상회');


-- 만들어진 트리거를 확인하는 쿼리
SHOW TRIGGERS;


-- 과일을 판매했을 때 과일 수량을 맞춰주는 트리거를 만들어보세요
DELIMITER //
CREATE TRIGGER insert_sell AFTER INSERT ON sell
FOR EACH ROW
BEGIN
-- 변수선언 한번 해보긩~
DECLARE _amount INT DEFAULT 0;
SET _amount = new.se_amount;
UPDATE fruit
	SET
		fr_amount = fr_amount - _amount
	WHERE
		fr_name = new.se_fr_name;
END //
DELIMITER ;

-- INSERT INTO sell VALUES(1, "바나나", 2, 2, 8000, now(), "카드");
SELECT * FROM sell;
SELECT * FROM fruit;

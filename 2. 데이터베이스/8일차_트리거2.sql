/*
프로시저 : 쿼리의 집합으로, 함수라고 생각하면 됨 

장점
 - 하나의 요청으로 여러 SQL문을 실행할 수 있다.
 - 처리 시간이 줄어든다. (미리 만들어져있기 때문에)
 - 응용프로그램측 로직을 가지지 않고도 데이터의 앞뒤가 맞게 할 수 있다.
 - 보수성이 뛰어나다

단점
 - 재사용성이 좋지 않음. 해당 TABLE과 해당 DB에 맞게 작업하는 것이기 때문에 다른 DB에서 활용하기 힘들다
	EX) 구매시 과일수량 조정하는 프로시저를 만들면, 그 프로시저를 영화티켓 예매에서 활용할 수 없다 =>근데 이건 트리거도 마찬가지 아닌가
 - 업무의 사양 변경 시 프로시저의 정의를 변경할 필요가 있다.
 
프로시저 목록 확인 
SHOW PROCEDURE STATUS;

프로시저 스크립트 확인
SHOW CREATE PROCEDURE 프로시저명;

프로지서 정의
DROP PROCEDURE IF EXISTS 프로시저명;
DELIMITER
CREATE PROCEDURE 프로시저명(
	(IN|OUT) 변수명 타입,
    ...
    (IN|OUT) 변수명 타입
)
BEGIN
	-- 실행코드
END //
DELIMITER ;

* 돌려줄 값을 OUT을 통해 지정 가능. OUT여러개 사용가능


프로시저 호출
CALL 프로시저명(변수나 값들);
*/

SHOW PROCEDURE STATUS;


-- ㄴㅏ왜이거안되는거지
-- SHOW CREATE PROCEDURE film_in_stock;


-- 과일 판매시 판매 금액을 자동으로 일벽하여 판매 정보를 sell 테이블에 추가하는 프로시저
-- INSERT 하면서 금액까지 계산해서 넣어주는..
DROP PROCEDURE IF EXISTS insert_sell;
DELIMITER //


-- in이 붙은건 매개변수라는 표시
CREATE PROCEDURE insert_sell(
IN in_fr_name VARCHAR(50),
IN in_amount INT,
IN in_unit VARCHAR(50) ,
IN in_type VARCHAR(50)

)
BEGIN
	DECLARE _total_price INT DEFAULT 0; -- 과일 총 가격
    DECLARE _price INT DEFAULT 0; -- 과일 개당 가격
    SET _price = (SELECT fr_price FROM fruit WHERE fr_name = in_fr_name);
    SET _total_price = _price * in_amount;
    INSERT INTO sell
		SELECT max(se_num)+1, in_fr_name, in_amount, in_unit, _total_price, now(), in_type FROM sell;
	
END //
DELIMITER ;


CALL insert_sell('바나나', 3, '송이', '카드');
SELECT * FROM sell;


/*
트리거는 새로 추가한 행에 대한 UPDATE를 못함
	- 이럴 땐 프로시저를 이용해야함 
트리거는 이벤트마다 동일하게 처리하는 경우 사용. 아니면 프로시저 사용 


Q. 통신사에서 작년 사용 금액을 기준으로 올해 등급을 결정하려는 과정을 하려 한다.
   이 때 프로시저를 사용해야하는가? 트리거를 사용해야하는가?
A. 프로시저

Q. 제품을 구매할 때마다 구매금액의 10%를 포인트로 지급하려한다. 이때 무엇을 사용?
A. 트리거
*/
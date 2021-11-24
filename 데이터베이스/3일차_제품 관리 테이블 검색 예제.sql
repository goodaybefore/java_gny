SELECT * FROM example.고객;
SELECT * FROM example.제품;
SELECT * FROM example.주문;

-- 고객 명단을 확인하는 쿼리문
SELECT * FROM example.고객;
SELECT 고객이름 FROM example.고객;

-- 고객등급 중복 제거하기
SELECT DISTINCT 등급 FROM example.고객;

-- 아이디가 apple 인 고객의 주문내역을 확인
SELECT * FROM 고객;
SELECT * FROM 주문;

SELECT * FROM 주문 WHERE 주문고객 ="apple";


-- 아이디가 apple인 고객의 주문제품 확인
SELECT * FROM 제품;
SELECT * FROM 주문;
SELECT DISTINCT 제품명 FROM 제품
	JOIN 주문 ON 제품.제품번호 = 주문.주문제품
    WHERE 주문고객="apple";
    
-- 이거왜안될까ㅠ
SELECT DISTINCT 제품명 FROM 제품 JOIN(SELECT * FROM 주문 WHERE 주문고객="apple") AS t ON 제품.제품번호 = 주문.주문제품;

-- 콩떡파이를 주문한 고객명단확인
SELECT DISTINCT 주문고객 FROM 주문 JOIN 제품 ON 제품.제품번호 = 주문.주문제품 WHERE 제품명="쿵떡파이";

/*
SELECT COUNT(*) AS "이순신 교수님 강의 수" FROM lecture
	JOIN (SELECT * FROM professor WHERE pr_name='이순신') AS t ON pr_num = le_pr_num;
*/
-- 과일 판매 내역을 확인하는 쿼리문 작성
SELECT * FROM sell;
SELECT se_date, se_fr_name, se_amount, se_price, se_type FROM SELL;

/*
-- 비교 할 때 맞으면 1, 틀리면 0 출력
SELECT NOW() > '2021-11-23';
SELECT NOW() < '2021-11-25';
SELECT NOW() > '2021-11-25';
*/

-- 오늘 과일 판매 내역 확인
SELECT sum(se_price) FROM SELL
	WHERE se_date>='2021-11-24';
    
-- 오늘 과일 판매 총액
SELECT se_price = se_price * se_amount FROM SELL WHERE se_date>='2021-11-24';
-- 4일차
-- 단가가 3000원이상 6000원 이하인 제품들 확인
SELECT * FROM 제품 WHERE 단가>=3000 AND 단가<6000;

-- 강사님
SELECT 제조업체, 제품명, 재고량, 단가 FROM example.제품
	WHERE 단가>=3000 AND 단가<6000
    ORDER BY 제조업체, 제품명;

SELECT 제조업체, 제품명, 재고량, 단가 FROM example.제품
	WHERE 단가 BETWEEN 3000 AND 6000
    ORDER BY 제조업체, 제품명;


-- in : 여러 값 중 하나를 만족하는 경우 사용
-- 제조업체가 대한식품 또는 민국푸드인 제품들을 확인
SELECT * FROM 제품 
	WHERE 제조업체 IN("대한식품","민국푸드")
    ORDER BY 제조업체;


-- 등급이 SLIVER 또는 GOLD인 회원인 아이디를 출력
SELECT * FROM 고객 WHERE 등급 IN("silver", "gold");

-- 등급이 silver or gold인 회원이 주문한 제품명 확인
SELECT * FROM 주문;
SELECT * FROM 고객;

SELECT DISTINCT 제품명 FROM 제품
	JOIN 주문 ON 주문.주문제품 = 제품.제품번호
    JOIN 고객 ON 주문.주문고객 = 고객.고객아이디
    WHERE 고객.등급 IN("sliver", "gold");


-- 가격이 2600 이상인 제품의 제품명과 단가 확인
SELECT * FROM 제품;
SELECT 제품명, 단가 FROM 제품 WHERE 단가>=2600;

-- 서브쿼리 : 쿼리문 안에 쿼리문이 들어가있는 쿼리 : 아래의 괄호자리
-- SELECT () FROM () [WHERE ()]
-- 쿵떡파이의 가격보다 크거나 같은 제품의 제품명과 단가 확인
SELECT * FROM 제품;
SELECT 제품명, 단가 FROM 제품 WHERE 단가>=(SELECT 단가 FROM 제품 WHERE 제품명="쿵떡파이");

-- 그냥만두 또는 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
SELECT 제품명, 단가 FROM 제품 WHERE 단가>=(SELECT 단가 FROM 제품 WHERE 제품명="얼큰라면") AND 단가>=(SELECT 단가 FROM 제품 WHERE 제품명="그냥만두");

-- 강사님
SELECT 제품명, 단가 FROM 제품 WHERE 단가>= (SELECT MAX(단가) FROM 제품 WHERE 제품명 IN("얼큰라면", "그냥만두"));

-- ALL() : 전부를 만족
SELECT 제품명, 단가 FROM 제품 WHERE 단가>= ALL(SELECT 단가 FROM 제품 WHERE 제품명 IN("얼큰라면", "그냥만두"));


-- ANY() : 둘중 하나 만족
SELECT 제품명, 단가 FROM 제품 WHERE 단가>= ANY(SELECT 단가 FROM 제품 WHERE 제품명 IN("얼큰라면", "그냥만두"));
SELECT 제품명, 단가 FROM 제품 WHERE 단가>= (SELECT MIN(단가) FROM 제품 WHERE 제품명 IN("얼큰라면", "그냥만두"));


-- GROUP BY : WHERE절 다음에 나와야함
SELECT * FROM 제품 GROUP BY 제조업체;
SELECT DISTINCT 제조업체, 제품번호 FROM 제품;
-- 제조업체별로 하나씩만 선택됨. DISTINCT 처럼 보일 수 있지만 다름.
-- DISTINCT 는 선택된 속성들이 중복되었을 때 제거하는 것. GROUP BY는 하나의 속성으로 묶어버리는 것(개념차이 잘 이해하기)


-- 대한식품에서 만든 제품 개수 확인
SELECT * FROM 제품;
SELECT COUNT(*) AS "대한식품 제품 개수" FROM 제품 WHERE 제조업체="대한식품";

-- 각 회사별 만든 제품 개수 확인
SELECT 제조업체, COUNT(*) AS "제조식품 갯수" FROM 제품 GROUP BY 제조업체;


-- 1번이상 주문한 고객별 주문 횟수
SELECT * FROM 고객;
SELECT * FROM 주문;
SELECT 고객아이디, 고객이름, COUNT(*) AS "주문횟수" FROM 고객 JOIN 주문 ON 주문.주문고객= 고객.고객아이디 GROUP BY 주문고객;
SELECT COUNT(*) AS "주문횟수" FROM 주문 GROUP BY 주문고객;

-- 1번이상 주문한 고객의 고객별 총 주문 갯수
-- ㅠㅠ 어려워ㅠㅠ
SELECT * FROM 주문;
SELECT * FROM 고객;
SELECT 주문고객, SUM(수량) AS '주문갯수' FROM 주문 GROUP BY 주문고객;

-- 1번이상 주문한 고객별 총 주문 금액
SELECT * FROM 제품;
SELECT * FROM 주문;
SELECT 주문고객, SUM(단가*수량) AS 총주문금액 FROM 주문 JOIN 제품 ON 주문.주문제품 = 제품.제품번호 GROUP BY 주문고객 ORDER BY 총주문금액 DESC;

-- 1번이상 주문한 고객 중 총주문금액이 100,000원 이상인 고객 확인
-- group by로 작업한 쿼리문의 where절에는 집약함수(sum 등)를 이용한 조건을 걸 수 없다.
-- HAVING 절 : GROUP BY로 작업한 내용에 조건을 걸어줄 때 사용
SELECT 주문고객, SUM(단가*수량) AS 총주문금액 FROM 주문 join 제품 ON 주문.주문제품 = 제품.제품번호 GROUP BY 주문고객 HAVING SUM(단가*수량)>=100000;


-- 제품별 주문한 제품번호와 수량, 제조업체를 확인하는 코드
SELECT * FROM 제품;
SELECT * FROM 주문;
SELECT 주문제품, SUM(수량) AS 누적주문량, 제조업체 FROM 주문 JOIN 제품 ON 주문.주문제품 = 제품.제품번호 GROUP BY 주문제품 ORDER BY 제품번호 ASC;

-- 위의 코드를 이용해서
-- 제조업체별 가장 많이 팔린 제품을 제조업체, 제품번호, 주문수량 확인
SELECT 제조업체, 제품번호, SUM(수량) AS 누적주문량 FROM 주문
	JOIN 제품 ON 주문.주문제품 = 제품.제품번호
    GROUP BY 제조업체
    ORDER BY 제품번호 ASC; 

SELECT MAX((SELECT SUM(수량) FROM 주문 JOIN 제품 ON 주문제품=제품번호)) GROUP BY 제조업체;
SELECT 제조업체, 제품번호, SUM(수량) FROM 주문 JOIN 제품 ON 주문제품=제품번호 GROUP BY 제조업체;

-- 힌트 참고해서 만들었음(틀린듯!)
SELECT * FROM 
	(SELECT 제조업체, 주문번호, SUM(수량) AS 누적주문량 FROM 주문 
		JOIN 제품 ON 주문.주문제품 = 제품.제품번호 
		GROUP BY 주문제품) 
    AS 제품판매량 
    GROUP BY 제조업체;

-- 강사님
SELECT 제조업체, 주문제품, MAX(누적주문량) AS 주문수량 FROM 
	(SELECT 제조업체, 주문제품, SUM(수량) AS 누적주문량 FROM 주문
		JOIN 제품 ON 주문제품=제품번호
        GROUP BY 주문제품
        ORDER BY 제조업체) AS 제품별판매량
	GROUP BY 제조업체;

-- WITH ROLLUP : 부분 총합을 구해줌

SELECT 주문제품, 주문고객, SUM(수량) FROM 주문 
	GROUP BY 주문제품, 주문고객
    WITH ROLLUP;


-- LIMIT : 검색결과의 갯수를 제한할 때 사용
-- LIMIT 정수1 : 정수 1개만큼의 결과를 보여줌
-- LIMIT 번지, 정수1 : 번지부터 정수1개의 결과를 보여줌

SELECT * FROM 주문 LIMIT 5;
-- 한번에 주문내역을 확인할 수 있는 경우가 5개인 경우로, 1페이지에 해당

SELECT * FROM 주문 LIMIT 2, 5; -- 2번지부터 5개

-- 5*3-1 = 10 => 3페이지부터 5개 출력한다는 뜻 : 갯수 * (페이지번호-1)
-- SELECT * FROM 주문 LIMIT 5*(3-1), 5; -- 2번지부터 5개


-- ★★★★★★★★★★★★★★내가 많이 어려웠던 예제★★★★★★★★★★★
-- 1. 가장 많은 금액을 사용한 고객 아이디 확인
SELECT * FROM 고객;
SELECT * FROM 제품;
SELECT * FROM 주문;

SELECT * FROM 주문;
SELECT 주문고객, MAX(총주문금액) AS max FROM
	(SELECT 주문고객, SUM(수량*단가) AS 총주문금액 FROM 주문
		JOIN 제품 ON 주문제품=제품번호 GROUP BY 주문고객 ORDER BY SUM(수량*단가) DESC)
    AS 최고판매액;

-- 2. 가장 많은 제품 개수를 구매한 고객 아이디 확인(누적)
-- LIMIT 이용하면 괜히 MAX 쓸 필요도 없음
SELECT * FROM 주문;
SELECT 주문고객, 고객의주문개수총합 AS 최고누적구매고객 FROM
	(SELECT 주문고객, SUM(수량) AS 고객의주문개수총합 FROM 주문
		GROUP BY 주문고객 ORDER BY SUM(수량) DESC LIMIT 1)
	AS 최고판매개수;

-- 강사님(앞에 쓸데없는거 다 빼버려)
SELECT 주문고객, SUM(수량) AS 고객의주문개수총합 FROM 주문
	GROUP BY 주문고객 ORDER BY SUM(수량) DESC LIMIT 1;


-- 3. 20대가 구매한 제품 목록 확인
SELECT * FROM 고객;
SELECT * FROM 주문;
SELECT 고객아이디 FROM 고객 GROUP BY 나이 HAVING 나이 BETWEEN 20 AND 29;

-- 내가쓴정답(틀림)
SELECT 주문고객, 제품명 FROM 고객
	JOIN 주문 ON 고객아이디=주문고객
    JOIN 제품 ON 주문제품 = 제품번호 GROUP BY 나이 HAVING 나이 BETWEEN 20 AND 29;

-- 강사님
 SELECT 주문고객, 제품명 AS 20대구매제품 FROM 고객
	JOIN 주문 ON 고객아이디=주문고객
    JOIN 제품 ON 주문제품 = 제품번호 WHERE 나이 BETWEEN 20 AND 29
    GROUP BY 제품명;

-- 4. 20대가 구매를 가장 많이 주문한 제품을 확인
SELECT * FROM 주문;
SELECT 주문제품, SUM(수량) FROM 주문 GROUP BY 주문제품; -- 제품별 주문수량


-- 강사님것... 내껀틀렸음 ㅜ 하
SELECT 제품명 AS 20대구매제품, SUM(수량) AS 누적주문량 FROM 고객
	JOIN 주문 ON 고객아이디=주문고객
    JOIN 제품 ON 주문제품 = 제품번호
    WHERE 나이 BETWEEN 20 AND 29
    GROUP BY 제품명
    ORDER BY 누적주문량 DESC LIMIT 1;


-- INNER JOIN

-- INNER JOIN은 테이블1, 2의 순서가 바뀌어도 똑같다
SELECT le_pr_num FROM lecture
	INNER JOIN subject
    ON le_su_num = su_num
    WHERE su_title = "컴퓨터개론";
    
SELECT le_pr_num FROM subject
	INNER JOIN lecture
    ON le_su_num = su_num
    WHERE su_title = "컴퓨터개론";
    
-- JOIN은 기본적으로 INNER JOIN 이다?
SELECT le_pr_num FROM lecture
	JOIN subject
    ON le_su_num = su_num
    WHERE su_title = "컴퓨터개론";
    
SELECT le_pr_num FROM subject
	JOIN lecture
    ON le_su_num = su_num
    WHERE su_title = "컴퓨터개론";



-- 컴퓨터개론 3분반 강의를 듣는 학생 명단을 확인하는 코드 작성
SELECT * FROM subject;
SELECT * FROM course;

-- 내가한거.. 이게 아닌듯....
SELECT co_st_num FROM subject
	INNER JOIN course
    ON su_num = 1;

select st_num, st_name from course
	join subject
		on co_su_num = su_num
	join student
		on co_st_num = st_num
	where su_title="컴퓨터개론" and su_class_num=3;
    
    
-- 20211160123 학번인 홍길동 학생이 수강한 모든 과목명을 확인하는 쿼리 작성
SELECT * FROM subject;
SELECT * FROM course;
SELECT * FROM student;

-- ㅠㅠ또틀렸어
SELECT su_title FROM course
	JOIN subject
		ON co_su_num = su_num
	JOIN student
		ON co_st_num = st_num
	WHERE st_num=2021160123;

-- 강사님
select su_title from course
	join subject
		on co_su_num = su_num
	where co_st_num=2021160123;
    

-- 이순신 교수님의 강의를 듣는 학생명단을 확인하는 쿼리
-- 맞았음 ㅎㅎ
SELECT * FROM subject;
SELECT * FROM course;
SELECT * FROM student;
SELECT * FROM lecture;
SELECT * FROM professor;

SELECT st_name, st_num FROM lecture
	JOIN course
		ON co_su_num = le_su_num
	JOIN professor
		ON pr_num = le_pr_num
	JOIN student
		ON st_num = co_st_num
	WHERE pr_name = "이순신";

select * from lecture
	join professor on pr_num = le_pr_num
    join course on co_su_num = le_su_num
    join student on st_num = co_st_num
    where pr_name = "이순신";

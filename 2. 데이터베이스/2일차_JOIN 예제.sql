SELECT * FROM university_ny.student;

-- 테이블1과 테이블2의 순서를 바꾼 경우 결과가 달라짐
SELECT co_st_num, su_title FROM course
	LEFT JOIN subject
    ON course.co_su_num = subject.su_num
    WHERE co_st_num = 2021160123;
    
SELECT co_st_num, su_title FROM subject
	LEFT JOIN course
    ON course.co_su_num = subject.su_num
    WHERE co_st_num=2021160123;
  
-- 이건 제대로된게 아니라는뎅
SELECT * FROM subject
	LEFT JOIN course
    ON co_su_num = su_num;
    

-- 2000160001 교수번호를 가진 교수님이 강의하는 강의 제목과 일정을 확인하는 쿼리문
-- 기준 : subject
SELECT * FROM subject;
SELECT * FROM lecture;
SELECT su_title, su_schedule FROM lecture
	LEFT JOIN subject
    ON subject.su_num = lecture.le_su_num;


-- 컴퓨터 개론을 강의하는 교수님 번호를 확인
SELECT * FROM lecture;
SELECT * FROM professor;
SELECT * FROM subject;

SELECT le_pr_num FROM lecture
	LEFT JOIN subject
    ON lecture.le_su_num = subject.su_num
    AND subject.su_title = "컴퓨터개론";


-- 컴퓨터개론을 강의하는 교수님의 이름을 확인하는 쿼리문
SELECT pr_name FROM lecture
	LEFT JOIN subject
		ON le_su_num = su_num
    LEFT JOIN professor
		ON pr_num = le_pr_num
	WHERE su_title = "컴퓨터개론";
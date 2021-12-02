
-- 2021160001 학생이 컴퓨터개론 3분반 강의를 신청했다. 이때 알맞은 쿼리
-- 이건 왜 안될까?
-- INSERT INTO course VALUES(co_st_num="2021160001", co_su_num=1);

-- INSERT INTO course(co_st_num, co_su_num) VALUES(2021160001,1);
-- 새로운 INSERT문
-- 2021160015 학생이 컴퓨터개론 3분반 강의를 신청했을 때 알맞은 쿼리
-- INSERT INTO course(co_st_num, co_su_num) SELECT 2021160015, su_num FROM subject WHERE su_title=" 컴퓨터학개론";
SELECT * FROM course;

-- 2021160123 홍길동 학생이 컴퓨터개론3분반의 성적이 A+
SET SQL_SAFE_UPDATES = 0;
-- and를 안붙이면 이 학생의 모든 성적이 A+이 되어버림!
UPDATE course SET co_score="A+" where co_st_num = 2021160123 and co_su_num=1; 
SELECT * FROM course;


-- 홍길동 학생이 수강한 과목의 과목 수를 확인
use UNIVERSITY_NY;
SELECT * FROM subject;
SELECT COUNT(*) AS "홍길동학생 수강과목수"FROM course 
	JOIN student
		ON student.st_num = course.co_st_num
	WHERE st_name="홍길동";


-- 컴퓨터개론 3분반 현재 수강신청 학생 수
SELECT * FROM course;
SELECT * FROM subject;
SELECT COUNT(*) AS "컴개론 3분반 현재 인원"FROM course
	JOIN subject
		ON course.co_su_num = subject.su_num
	WHERE su_title="컴퓨터개론" AND su_class_num=3;


-- 이순신 교수님이 강의하는 강의 수
SELECT COUNT(*) AS "이순신 교수님 강의 수" FROM lecture
	JOIN professor
		ON lecture.le_pr_num = professor.pr_num
        WHERE pr_name="이순신";
        
-- JOIN 효율적으로 작성하기(데이터가 많은 경우 속도빠르게하기)
-- lecture + professor 에서 이순신 찾기 vs lecture에서 이순신 찾기 정도의 차이...?
SELECT COUNT(*) AS "이순신 교수님 강의 수" FROM lecture
	JOIN (SELECT * FROM professor WHERE pr_name='이순신') AS t ON pr_num = le_pr_num;



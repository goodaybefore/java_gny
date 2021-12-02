-- SELECT문 기본 예제
SELECT * FROM student;
SELECT * FROM university_ny.student;
SELECT * FROM `university_ny`.`student`;
SELECT st_num, st_id, st_pw, st_name, st_reg_num FROM student;


SELECT * FROM student WHERE st_num = 2021123005;
SELECT * FROM student WHERE st_num = '2021123005';


-- 입학한 학생 전체를 확인하는 쿼리문을 작성하세요
SELECT * FROM student;


-- 홍길동 학생의 정보를 확인하는 쿼리문
SELECT * FROM student WHERE st_name="홍길동";

-- 홍길동 제외한 학생 정보를 입력
SELECT * FROM student WHERE st_name != "홍길동";
SELECT * FROM student WHERE st_name <> "홍길동";



-- 2000160001 교수님이 1번과목을 강의할 강의시간표가 월 1,2시로 결정되었고 분반은 3분반이다
SELECT* FROM subject;
UPDATE subject SET su_schedule='월요일 1교시, 2교시', su_class_num=3 WHERE su_num=1;

-- 시간표 일정이 등록된 과목들만 출력
SELECT * FROM subject WHERE su_schedule IS NOT NULL;

-- FOREIGN KEY 때매 삭제 안된다구 에러메세지 뜰 때 밑의 변수를 0으로 SET했다가 다시 1로 바꿔주기
-- SET foreign_key_checks = 0;


-- 과목제목에 컴퓨터로 시작하는 과목들
SELECT * FROM subject WHERE su_title LIKE '컴퓨터%';
-- 과목제목에 컴퓨터가 들어가는 과목들
SELECT * FROM subject WHERE su_title LIKE '%컴퓨터%';

-- 컴퓨터로 시작하고, 과목제목의 글자수가 5자인 과목들
SELECT * FROM subject WHERE su_title LIKE '컴퓨터__';


-- 21학번 학생들을 확인하는 쿼리문 작성
SELECT * FROM student WHERE st_num LIKE '2021%';
-- 이런것도 가능은함. 깔끔하진 않지만....
SELECT * FROM student WHERE st_num >= 2021000000 AND st_num<2022000000;


-- 컴공과 학생번호 160 을 확인하는
SELECT * FROM student WHERE st_num LIKE'____160%';

-- 여학생 확인
SELECT * FROM student;
-- SELECT * FROM student WHERE st_reg_num = '______-1%';

SELECT * FROM student WHERE st_reg_num LIKE '______-2%' OR st_reg_num LIKE '______-4';

-- 학생 이름순으로 정렬
SELECT * FROM student ORDER BY st_name ASC, st_num DESC;
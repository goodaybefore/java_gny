-- INSERT INTO student VALUES('2021160123', 'HONG', 'hong', '홍길동', '020101-3456789');

-- id : hong123, pw : pw123 을 잘못 입력함. 
-- INSERT INTO student VALUES('2021160124', 'pw123', 'hong123', '홍길동', '020505-3456789');
-- insert INTO student(st_num, st_id, st_pw, st_name, st_reg_num)
-- 			VALUES('2019160001', 'Jang', 'jang', '장세훈', '941125-1234567');
-- insert INTO student(st_num, st_pw, st_id, st_name, st_reg_num)
-- 			VALUES('2019160015', 'pwkim', 'kimid', '김영희', '021125-2234567');
INSERT INTO student 
	VALUES('2021123005', 'park', 'parkpw', '박철수', '021121-3334442'),
    ('2021456005', 'park2', 'parkpw', '박철수', '020817-3985612');

SELECT * FROM university_ny.student;

SELECT * FROM professor;
-- 교수 번호가 2000160001 인 이순신교수님의 정보를 추가
INSERT INTO professor VALUES(2000160001, "lee", "leelee", '이순신', '550505-1234567');



SELECT * FROM subject;
INSERT INTO subject (su_code, su_title) VALUES ('MSA001', '컴퓨터개론');


INSERT INTO lecture(le_pr_num, le_su_num) VALUES(2000160001, 1);
SELECT * FROM lecture;

INSERT INTO course(co_st_num, co_su_num) VALUES(2021160123,1);
SELECT * FROM course;



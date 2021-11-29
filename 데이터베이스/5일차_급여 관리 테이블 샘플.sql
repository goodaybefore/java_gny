/* 직급에 다음 데이터를 추가하는 쿼리 작성 
-  사원 대리 과장 부장 전무 이사 대표이사
*/

SELECT * FROM salary;
/*
INSERT INTO salary VALUES ("사원", 200, 10), ("대리", 230, 15),("과장", 250, 20),("부장", 280, 30),("전무", 300, 35),("이사", 350, 40),("대표이사", 400, 50);
INSERT INTO salary (sa_level, sa_base_salary, sa_add_salary) VALUES("사원", 200, 10);
INSERT INTO salary (sa_level, sa_base_salary, sa_add_salary) VALUES("대리", 230, 15);
INSERT INTO salary (sa_level, sa_base_salary, sa_add_salary) VALUES("과장", 250, 20);
INSERT INTO salary (sa_level, sa_base_salary, sa_add_salary) VALUES("부장", 280, 30);
INSERT INTO salary (sa_level, sa_base_salary, sa_add_salary) VALUES("전무", 300, 35);
INSERT INTO salary (sa_level, sa_base_salary, sa_add_salary) VALUES("이사", 350, 40);
INSERT INTO salary (sa_level, sa_base_salary, sa_add_salary) VALUES("대표이사", 400, 50);
*/

SELECT * FROM department;
/* 영업 회계 관리 마케팅 개발 */
INSERT INTO department VALUES("영업"),("회계"),("관리"),("마케팅"),("개발");


/*
2019001, 2년차, 회게부, 123456-1234567 인 홍길동 사원의 정보 추가
*/

SELECT * FROM employee;
INSERT INTO employee (em_num, em_reg_num, em_name, em_sa_level, em_join_year, em_year, em_de_department) VALUES(2019001, '123456-1234567', "홍길동", "사원", 2, 2019, "회계");


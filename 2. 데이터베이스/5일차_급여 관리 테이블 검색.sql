/*
홍길동 사원의 급여를 확인하는 쿼리문
*/
SELECT * FROM employee;
SELECT * FROM salary;
SELECT (sa_base_salary+sa_add_salary*em_join_year) AS 홍길동급여 FROM employee JOIN salary
	ON em_sa_level = sa_level
    WHERE em_name="홍길동";


/*
각 부서별 평균 급여를 출력하는 쿼리 작성. 단, 직원이 등록된 부서만 
*/

SELECT * FROM employee;
SELECT * FROM department;
SELECT * FROM salary;
-- 내가한것..(맞냐)
SELECT em_de_department, AVG(sa_base_salary+sa_add_salary*em_join_year) AS 부서별평균 FROM employee JOIN salary ON em_sa_level = sa_level GROUP BY em_de_department;






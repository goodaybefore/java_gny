/* 사원들의 월급을 관리하는 시스템 DB 설계
- 월급 지급 내역 관리 포함
직급
- 사원, 대리, 과장, 부장, 전무, 이사
월급
- 월급은 직급별 기본급에 직급별 호봉에 따른 추가금
예) 사원 기본급 200만, 호봉별 추가금이 10만원
	2년차 사원 홍길동의 월급은? 220만원
*/


CREATE TABLE `company`.`employee` (
  `em_num` INT NOT NULL,
  `em_reg_num` CHAR(14) NOT NULL,
  `em_name` VARCHAR(45) NOT NULL,
  `em_sa_level` VARCHAR(4) NOT NULL,
  `em_year` INT NOT NULL,
  `em_join_year` INT NOT NULL,
  `em_de_department` VARCHAR(10) NULL,
  PRIMARY KEY (`em_num`),
  UNIQUE INDEX `em_reg_num_UNIQUE` (`em_reg_num` ASC) VISIBLE);
-- 생성시에 외래키 설정 빠짐(아직 다른 테이블을 안 만들었으므로)

-- em_sa_level 이 클릭으로 안돼서 이렇게함... 강사님꺼랑 비교해보기
ALTER TABLE `company`.`employee` 
ADD INDEX `sa_salary_idx` (`em_sa_level` ASC) VISIBLE;
ALTER TABLE `company`.`employee` 
ADD CONSTRAINT `em_sa_level`
  FOREIGN KEY (`em_sa_level`)
  REFERENCES `company`.`salary` (`sa_level`);

ALTER TABLE `company`.`employee` 
ADD INDEX `de_department_idx` (`em_de_department` ASC) VISIBLE;
ALTER TABLE `company`.`employee` 
ADD CONSTRAINT `em_de_department`
  FOREIGN KEY (`em_de_department`)
  REFERENCES `company`.`department` (`de_department`)
  ON DELETE SET NULL
  ON UPDATE SET NULL;


CREATE TABLE `company`.`department` (
  `de_department` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`de_department`));


CREATE TABLE `company`.`salary` (
  `sa_level` CHAR(4) NOT NULL,
  `sa_base_salary` INT NOT NULL,
  `sa_add_salary` INT NOT NULL,
  PRIMARY KEY (`sa_level`));

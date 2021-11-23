-- 1. `university_ny` 생성, 있으면 삭제 후 생성
DROP SCHEMA IF EXISTS `university_ny`;
CREATE SCHEMA `university_ny`;
-- 2. `university_ny` DB선택
use `university_ny`;

-- 3. student TABLE 생성
-- 비번을 255자로 한 이유
-- 일반적으로 비번은 노출되면 안되기 때문에 암호화가 이루어져야함. 암호화가 이루어지면 짧은 비번이 긴문자열로 바뀜.
DROP TABLE IF EXISTS `university_ny`.`student`;
CREATE TABLE `university_ny`.`student` (
  `st_num` CHAR(10) NOT NULL,
  `st_id` VARCHAR(15) NOT NULL,
  `st_pw` VARCHAR(250) NOT NULL,
  `st_name` VARCHAR(50) NOT NULL,
  `st_reg_num` CHAR(14) NOT NULL,
  PRIMARY KEY (`st_num`),
  -- unique는 딱히 안써도됨
  -- ASC 오름차순 , DESC 내림차순
  UNIQUE INDEX `st_id_UNIQUE` (`st_id` ASC) VISIBLE,
  UNIQUE INDEX `st_reg_num_UNIQUE` (`st_reg_num` ASC) VISIBLE);

-- 테이블 이름 앞에 DB명. 이 붙는 경우와 안 붙는 경우의 차이
-- 테이블명 앞에 DB명. 이 붙으면 현재 선택된 DB와 상관없이 TABLE을 활용할 수 있음.

-- 4. professor TABLE 생성
DROP TABLE IF EXISTS `university_ny`.`professor`;
CREATE TABLE `university_ny`.`professor` (
  `pr_num` CHAR(10) NOT NULL,
  `pr_id` VARCHAR(15) NOT NULL,
  `pr_pw` VARCHAR(255) NOT NULL,
  `pr_name` VARCHAR(50) NOT NULL,
  `pr_reg_num` CHAR(14) NOT NULL,
  PRIMARY KEY (`pr_num`),
  UNIQUE INDEX `pr_reg_num_UNIQUE` (`pr_reg_num` ASC) VISIBLE,
  UNIQUE INDEX `pr_id_UNIQUE` (`pr_id` ASC) VISIBLE);


-- 5. subject TABLE 생성
DROP TABLE IF EXISTS `university_ny`.`subject`;
CREATE TABLE `university_ny`.`subject` (
  `su_num` INT NOT NULL AUTO_INCREMENT,
  `su_code` CHAR(6) NOT NULL,
  `su_schedule` VARCHAR(30) NULL DEFAULT NULL,
  `su_class_num` INT NOT NULL DEFAULT 1,
  `su_title` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`su_num`));



-- 5. course TABLE
DROP TABLE IF EXISTS `university_ny`.`course`;
CREATE TABLE `university_ny`.`course` (
  `co_num` INT NOT NULL AUTO_INCREMENT,
  `co_st_num` CHAR(10) NOT NULL,
  `co_su_num` INT NOT NULL,
  `co_score` VARCHAR(4) NULL,
  PRIMARY KEY (`co_num`),
  INDEX `co_st_num_idx` (`co_st_num` ASC) VISIBLE,
  INDEX `co_su_num_idx` (`co_su_num` ASC) VISIBLE,
  CONSTRAINT `co_st_num`
    FOREIGN KEY (`co_st_num`) REFERENCES `university_ny`.`student` (`st_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `co_su_num`
    FOREIGN KEY (`co_su_num`) REFERENCES `university_ny`.`subject` (`su_num`) ON DELETE CASCADE ON UPDATE CASCADE
    );


-- 6. lecture TABLE
DROP TABLE IF EXISTS `university_ny`.`lecture`;
CREATE TABLE `university_ny`.`lecture` (
  `le_num` INT NOT NULL auto_increment,
  `le_pr_num` CHAR(10) NOT NULL,
  `le_su_num` INT NOT NULL,
  PRIMARY KEY (`le_num`),
  INDEX `le_pr_num_idx` (`le_pr_num` ASC) VISIBLE,
  INDEX `le_su_num_idx` (`le_su_num` ASC) VISIBLE,
  CONSTRAINT `le_pr_num`
    FOREIGN KEY (`le_pr_num`) REFERENCES `university_ny`.`professor` (`pr_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `le_su_num`
    FOREIGN KEY (`le_su_num`) REFERENCES `university_ny`.`subject` (`su_num`) ON DELETE CASCADE ON UPDATE CASCADE);








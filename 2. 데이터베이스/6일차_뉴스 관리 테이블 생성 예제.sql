/*
스포츠, 연예, 일반 뉴스를 관리하는 사이트를 구축하기위한 ERD 설계
네이버뉴스 참고

* 뉴스 등록, 수정, 삭제기능
* 댓글기능
* 좋아요, 싫어요 기능

뉴스 
- 뉴스번호(pk), 제목, 내용, 작성자(기자), 작성일, 최종수정일, 신문사, 대분류(일반/스포츠/연예), 중분류(경제/정치/야구/축구 등)

기자
- 기자번호(pk), 이름, 주민번호, 구독자수, 응원수, 소속신문사

회원
- 아이디, 비번

댓글
* 자기자신을 외래키로 지정 => 댓글의 답글을 표현하기 위함.
* 댓글번호 == 답글번호 : 댓글 / 댓글번호 != 답글번호 : 답글
* 어렵다...ㅠㅠ
- 댓글번호(pk), 뉴스번호(fk), 아이디(fk), 댓글내용, 공감 수, 비공감 수, 답글번호(fk), 작성일

반응
* 반응번호(pk), 뉴스번호(fk), 아이디(fk), 상태(좋아요or훈훈해요or슬퍼요)



*/

CREATE DATABASE news;
USE news;

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
	`nw_num`	int	NOT NULL,
	`nw_title`	varchar(50)	NULL,
	`nw_contents`	longtext	NULL,
	`nw_reg_date`	datetime	NULL,
	`nw_update`	datetime	NULL,
	`nw_company`	varchar(50)	NULL,
	`nw_main_category`	varchar(50)	NULL,
	`nw_sub_category`	varchar(50)	NULL,
	`nw_nh_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `newshawk`;

CREATE TABLE `newshawk` (
	`nh_num`	int	NOT NULL,
	`nh_name`	varchar(50)	NULL,
	`nh_reg_num`	char(14)	NULL,
	`nh_company`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(50)	NOT NULL,
	`me_pw`	varchar(255)	NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`co_num`	int	NOT NULL,
	`co_nw_num`	int	NOT NULL,
	`co_me_id`	varchar(50)	NOT NULL,
	`co_contents`	longtext	NULL,
	`co_up`	int	NULL,
	`co_down`	int	NULL,
	`co_date`	date	NULL,
	`co_delete`	char(1)	NULL,
	`co_com_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `reaction`;

CREATE TABLE `reaction` (
	`re_num`	int	NOT NULL,
	`re_state`	varchar(10)	NULL,
	`re_me_id`	varchar(50)	NOT NULL,
	`re_nw_num`	int	NOT NULL
);

ALTER TABLE `news` ADD CONSTRAINT `PK_NEWS` PRIMARY KEY (
	`nw_num`
);

ALTER TABLE `newshawk` ADD CONSTRAINT `PK_NEWSHAWK` PRIMARY KEY (
	`nh_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`co_num`
);

ALTER TABLE `reaction` ADD CONSTRAINT `PK_REACTION` PRIMARY KEY (
	`re_num`
);

ALTER TABLE `news` ADD CONSTRAINT `FK_newshawk_TO_news_1` FOREIGN KEY (
	`nw_nh_num`
)
REFERENCES `newshawk` (
	`nh_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_news_TO_comment_1` FOREIGN KEY (
	`co_nw_num`
)
REFERENCES `news` (
	`nw_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_comment_TO_comment_1` FOREIGN KEY (
	`co_com_num`
)
REFERENCES `comment` (
	`co_num`
);

ALTER TABLE `reaction` ADD CONSTRAINT `FK_member_TO_reaction_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reaction` ADD CONSTRAINT `FK_news_TO_reaction_1` FOREIGN KEY (
	`re_nw_num`
)
REFERENCES `news` (
	`nw_num`
);


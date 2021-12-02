/*
영화 티켓 예메 사이트를 구축하기 위한 ERD를 설계하세요
CGV, 롯데시네마 참고


* 예매는 회원만 가능
* 예매는 한번에 한 좌석만 가능
ERD

영화
- 영화번호(pk), 제목, 권장연령, 런닝타임, 개봉일, 영화상세

영화장르
- 영화장르번호, 영화번호(fk), 장르명

장르
- 장르명(pk)



인물
* 가족을 테이블로 관리할 수 있지만 영화와 관련해서 배우 가족은 중요한 것이 아니기 때문에 하나의 속성으로 관리함 
* 학력은 최종학력만 기술
* 취미와 직업을 테이블로 만들 수 있지만 속성으로 관리
- 인물번호(pk), 이름, 출생, 국적, 직업, 가족, 취미, 신체, 사이트 등 

참여
- 참여번호(pk), 영화번호(fk), 인물번호(fk), 역할 

극장
- 극장번호(pk), 지역, 지점명, 주소, 교통안내, 주차안내, 관 갯수, 총 좌석

좌석 : 관별로 모든 좌석을 다 등록시켜버리기
- 좌석번호(pk), 좌석명, 극장번호(fk), 관번호, 좌석상태

상영시간 
* 총좌석수는 select로 알 수는 있는데 편하기위해서 걍넣어줌
- 상영번호(pk), 영화번호(fk), 극장번호(fk), 상영시간, 옵션(2D, 3D등), 총좌석, 예약가능좌석수

회원
- 아이디, 비번 

예매
- 예매번호(pk), 아이디(fk), 상영시간(fk), [영화명], 좌석번호(fk)

예매리스트 
* 이건 왜 만든걸까?... 1관 A01열 좌석은 시간대마다 여러 예매가 되어있을 수 있다. => M:N 관계이기 때문에 테이블을 하나 추가한 것
- 예매리스트번호(pk), 예매번호(fk), 좌석번호(fk)





























---내가한거
영화
- 영화번호, 영화제목, 감독, 장르 

배우 
- 배우번호, 배우이름, 성별 

출연
* 주연여부 : 주연이면 1, 조연이면 0으로 표기한다
- 출연번호, 배우번호, 영화번호, 역할명, 주연여부


상영 
* 좌석은 F14, E05 와 같은 형식으로 표기한다.
- 상영번호, 영화제목, 상영시간, 상영관, 최대관객수, 현재관객수, 좌석


예매
* 회원만 영화예매를 할 수 있다. 
* 상영번호에 영화정보가 들어가 있기 때문에 영화번호를 예매table에 넣어줄 필요가 없다.
- 예매번호, 회원번호, 상영번호

회원
- 회원아이디, 비번, 성별
*/



-- 강사님꺼 붙여넣기
CREATE DATABASE cgv;
USE cgv;

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(50)	NULL,
	`mo_age`	varchar(50)	NULL,
	`mo_runtime`	int	NULL,
	`mo_date`	date	NULL,
	`mo_detail`	longtext	NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`ge_name`	varchar(50)	NOT NULL
);

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
	`mg_num`	int	NOT NULL,
	`mg_ge_name`	varchar(50)	NOT NULL,
	`mg_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `character`;

CREATE TABLE `character` (
	`ch_num`	int	NOT NULL,
	`ch_name`	varchar(50)	NULL,
	`ch_birthday`	varchar(10)	NULL,
	`ch_nationality`	varchar(50)	NULL,
	`ch_job`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `participation`;

CREATE TABLE `participation` (
	`pt_num`	int	NOT NULL,
	`pt_mo_num`	int	NOT NULL,
	`pt_ch_num`	int	NOT NULL,
	`pt_role`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`th_num`	int	NOT NULL,
	`th_area`	varchar(50)	NULL,
	`th_name`	varchar(50)	NULL,
	`th_address`	varchar(50)	NULL,
	`th_traffic`	longtext	NULL,
	`th_parking`	longtext	NULL,
	`th_room_count`	int	NULL,
	`th_seat_count`	int	NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`st_num`	int	NOT NULL,
	`st_name`	char(3)	NULL,
	`st_th_num`	int	NOT NULL,
	`st_room_num`	int	NULL,
	`st_state`	varchar(50)	NULL,
	`st_type`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`sc_num`	int	NOT NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_th_num`	int	NOT NULL,
	`sc_date`	date	NULL,
	`sc_time`	varchar(5)	NULL,
	`sc_room_num`	varchar(50)	NULL,
	`sc_option`	varchar(10)	NULL,
	`sc_total_seat`	int	NULL,
	`sc_seat`	int	NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(50)	NOT NULL,
	`me_pw`	varchar(255)	NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
	`tk_num`	varchar(10)	NOT NULL,
	`tk_me_id`	varchar(50)	NOT NULL,
	`tk_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `ticketing_list`;

CREATE TABLE `ticketing_list` (
	`tl_num`	int	NOT NULL,
	`tl_tk_num`	varchar(10)	NOT NULL,
	`tl_st_num`	int	NOT NULL
);

ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
	`mo_num`
);

ALTER TABLE `genre` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `PK_MOVIE_GENRE` PRIMARY KEY (
	`mg_num`
);

ALTER TABLE `character` ADD CONSTRAINT `PK_CHARACTER` PRIMARY KEY (
	`ch_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `PK_PARTICIPATION` PRIMARY KEY (
	`pt_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `PK_THEATER` PRIMARY KEY (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`sc_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `PK_TICKETING` PRIMARY KEY (
	`tk_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `PK_TICKETING_LIST` PRIMARY KEY (
	`tl_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_movie_TO_participation_1` FOREIGN KEY (
	`pt_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_character_TO_participation_1` FOREIGN KEY (
	`pt_ch_num`
)
REFERENCES `character` (
	`ch_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_theater_TO_seat_1` FOREIGN KEY (
	`st_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_theater_TO_schedule_1` FOREIGN KEY (
	`sc_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`tk_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`tk_sc_num`
)
REFERENCES `schedule` (
	`sc_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`tl_tk_num`
)
REFERENCES `ticketing` (
	`tk_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_seat_TO_ticketing_list_1` FOREIGN KEY (
	`tl_st_num`
)
REFERENCES `seat` (
	`st_num`
);


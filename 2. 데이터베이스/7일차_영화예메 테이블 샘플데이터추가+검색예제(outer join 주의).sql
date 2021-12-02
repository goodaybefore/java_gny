-- cgv 홈페이지 영화 듄 정보를 이용하여 영화정보, 인물 등 필요한 정보를 DB에 추가




SELECT * FROM `schedule`;
SELECT * FROM theater;
SELECT * FROM `character`;
SELECT * FROM genre;
SELECT * FROM movie;
SELECT * FROM participation;

/*
INSERT INTO movie VALUES(1, "듄", "12세", 155, '2021-10-20', "“듄을 지배하는 자가 우주를 지배한다!”
10191년, 아트레이데스 가문의 후계자인 폴(티모시 샬라메)은 시공을 초월한 존재이자 
전 우주를 구원할 예지된 자의 운명을 타고났다. 
그리고 어떤 계시처럼 매일 꿈에서 아라키스 행성에 있는 한 여인을 만난다. 
모래언덕을 뜻하는 '듄'이라 불리는 아라키스는 물 한 방울 없는 사막이지만 
우주에서 가장 비싼 물질인 신성한 환각제 스파이스의 유일한 생산지로 이를 차지하기 위한 전쟁이 치열하다. 
황제의 명령으로 폴과 아트레이데스 가문은 죽음이 기다리는 아라키스로 향하는데…
위대한 자는 부름에 응답한다, 두려움에 맞서라, 이것은 위대한 시작이다!");

INSERT INTO `character` VALUES(1, "티모시 샬라메", "1995-12-27", "미국", "배우" );
INSERT INTO `character` VALUES(2, "레베카 퍼거슨", "1983-10-19", "스웨덴", "배우" );
INSERT INTO `character` VALUES(3, "드니 빌뇌브", '1967-10-03','캐나다', '영화감독, 시나리오작가');
*/
-- INSERT INTO genre VALUES ("SF");
-- INSERT INTO genre VALUES ("가족"),("공포/호러"),("드라마"),("멜로/로맨스"),("코미디"),("미스터리"),("범죄"),("옴니버스"),("느와르"),("단편"),("다큐멘터리"),("로드무비"),("무협"),("뮤지컬"),("뮤직"),("서부"),("스릴러"),("스포츠"),("시대극/사극"),("아동"),("액션"),("어드벤처"),("역사"),("전기"),("전쟁"),("종교"),("재난"),("청춘영화"),("퀴어"),("판타지"),("학원물"),("에로");
select * from genre;
SELECT * FROM movie_genre;
/*INSERT INTO movie_genre VALUES(1, "SF", 1);


SELECT * FROM `schedule`;
SELECT * FROM theater;

INSERT INTO theater VALUES(1, "강남", "강남점", "강남구 어쩌구", "교통편", "강남점 주차안내", 7, 158);
INSERT INTO `schedule` VALUES(1, 1, "1", "2021-12-01","15:45:00", 1, "2D", 158, 157);
*/
-- 듄에 참여한 인물정보 추가
-- INSERT INTO participation VALUES(1, 1, 1, "주연"),(2, 1, 2, "주연"),(3, 1, 3, "감독");

-- CGV 홈페이지에서 강남점 정보를 이용하여 DB에 추가, 상영시간표X 좌석은 A1~5, B1~B5만 추가, 관은 총 3개


-- 극장정보 입력
/*INSERT INTO theater VALUES(1, "서울", "cgv강남", "서울특별시 강남구 역삼동 814-6 스타플렉스", "# 지하철
2호선 | 강남역 11번 출구
9호선 | 신논현역 5번출구

# 버스
- 분당지역
   좌석버스: 1005-1, 1005-2, 6800, 5500-2
   간선버스: 408, 462
   광역버스: 9404, 9408
- 강북지역
   간선버스: 140, 144, 145, 471
- 강서지역
   좌석버스: 1500
   간선버스: 360
- 강동지역
   간선버스: 402, 420, 470, 407
- 인근경기지역
   좌석버스: 3030, 2002, 2002-1
   광역버스: 9409, 9500, 9501, 9503, 9700, 9711", "# 주차정보
- 위치: 건물 지하2F ~ 지하4F

# 주차요금
- CGV 영화 관람 시 주차 3시간 6,000원
- 주차시간 (3시간) 초과 시 10분 당 1,000원
※ 발렛서비스 운영시간 : 오전 8시 이후 ~ 오후 20시

※ 발렛 무료 서비스는 영화 관람 고객 한 함.  (영화 미관람 시 건물 주차장에서 별도 정산)
※ 20시 이후 입차 차량은 발렛서비스 이용이 제한될 수 있으며, 별도 운영되는 주차팀의 사정에 따라 변경될 수 있습니다.

# 이용안내
- 주차공간이 협소하여 평일 오후/주말은 주차가 어렵습니다.
- 편리한 대중교통 이용을 이용하여 주시기 바랍니다.", 3, 30);*/
SELECT * FROM theater;
SELECT * FROM seat;
-- 좌석정보 입력
/*INSERT INTO seat VALUES(1, "A01", 1, 1, "예약가능", "일반") ,(2, "A02", 1, 1, "예약가능", "일반"),(3, "A03", 1, 1, "예약가능", "일반"),(4, "A04", 1, 1, "예약가능", "일반"),(5, "A05", 1, 1, "예약가능", "일반")
				,(6, "B01", 1, 1, "예약가능", "일반"),(7, "B02", 1, 1, "예약가능", "일반"),(8, "B03", 1, 1, "예약가능", "일반"),(9, "B04", 1, 1, "예약가능", "일반"),(10, "B05", 1, 1, "예약가능", "일반")
               
               ,(11, "A01", 1, 2, "예약가능", "일반") ,(12, "A02", 1, 2, "예약가능", "일반"),(13, "A03", 1, 2, "예약가능", "일반"),(14, "A04", 1, 2, "예약가능", "일반"),(15, "A05", 1, 2, "예약가능", "일반")
				,(16, "B01", 1, 2, "예약가능", "일반"),(17, "B02", 1, 2, "예약가능", "일반"),(18, "B03", 1, 2, "예약가능", "일반"),(19, "B04", 1, 2, "예약가능", "일반"),(20, "B05", 1, 2, "예약가능", "일반")
               
               ,(21, "A01", 1, 3, "예약가능", "일반") ,(22, "A02", 1, 3, "예약가능", "일반"),(23, "A03", 1, 3, "예약가능", "일반"),(24, "A04", 1, 3, "예약가능", "일반"),(25, "A05", 1, 3, "예약가능", "일반")
				,(26, "B01", 1, 3, "예약가능", "일반"),(27, "B02", 1, 3, "예약가능", "일반"),(28, "B03", 1, 3, "예약가능", "일반"),(29, "B04", 1, 3, "예약가능", "일반"),(30, "B05", 1, 3, "예약가능", "일반");*/
SELECT * FROM seat;

-- CGV 영화 듄, 강남지점 12월 1~3일 상영스케쥴 등록
SELECT * FROM `schedule`;
INSERT INTO `schedule` (sc_mo_num, sc_th_num, sc_date, sc_time, sc_room_num, sc_option, sc_total_seat, sc_seat)
		VALUES  (1, 1, "2021-12-01", "15:45", 1, "2D", 10, 10),
				(1, 1, "2021-12-01", "21:20", 1, "2D", 10, 10),
                
                (1, 1, "2021-12-02", "10:20", 1, "2D", 10, 10),
				(1, 1, "2021-12-02", "16:20", 1, "2D", 10, 10),
				(1, 1, "2021-12-02", "19:30", 1, "2D", 10, 10),
                
                (1, 1, "2021-12-03", "10:30", 1, "2D", 10, 10),
				(1, 1, "2021-12-03", "16:30", 1, "2D", 10, 10),
				(1, 1, "2021-12-03", "19:45", 1, "2D", 10, 10),
                (1, 1, "2021-12-03", "21:40", 3, "2D", 10, 10);
SELECT * FROM `schedule`;
SELECT * FROM movie_genre;


-- 안나옴..
SELECT mo_title AS 영화제목, sc_date AS 상영날짜, sc_time AS 상영시간, mo_age AS 연령제한,
		mo_runtime AS 런타임, sc_total_seat AS 전체좌석, sc_seat AS 남은좌석, mo_ge_name AS 장르,
        sc_room_num AS 상영관 FROM `schedule`
		JOIN movie ON sc_mo_num = mo_num
        JOIN movie_genre ON mg_mo_num = mo_num
        WHERE sc_date="2021-12-01";


-- 회원가입
-- INSERT INTO member VALUES("abc123","abc123");

SELECT mo_title AS 영화제목, sc_date AS 상영날짜, sc_time AS 상영시간, mo_age AS 연령제한,
		mo_runtime AS 런타임, sc_total_seat AS 전체좌석, sc_seat AS 남은좌석,
        sc_room_num AS 상영관  FROM `schedule`
		JOIN theater ON sc_th_num = th_num
        JOIN movie ON mo_num = sc_mo_num
        WHERE sc_date="2021-12-01";


SELECT * FROM member;
-- abc123 회원이 12월 01일 21:20 영화 둔을 A1, A2 두자리 예매. 이때 실행되는 쿼리문 작성 


-- 1. 예매에 데이터 추가
/*
INSERT INTO ticketing VALUES (1, 'abc123', 2);

-- 강사님
INSERT INTO ticketing SELECT 1, "abc123", sc_num FROM schedule
	WHERE sc_time="21:20" AND sc_date="2021-12-01" AND sc_room_num=1;
SELECT * FROM ticketing;*/

-- 2. 예매리스트에 데이터 추가
SELECT * FROM ticketing_list;
INSERT INTO ticketing_list VALUES (1, 1, (SELECT st_num FROM seat WHERE st_name="A01" AND st_room_num=1));
INSERT INTO ticketing_list VALUES (2, 1, (SELECT st_num FROM seat WHERE st_name="A02" AND st_room_num=1));

SELECT * FROM seat;
UPDATE seat SET st_state="예약완료" WHERE st_name="A01" AND st_room_num=1;
UPDATE seat SET st_state="예약완료" WHERE st_name="A02" AND st_room_num=1;
UPDATE schedule SET sc_seat= sc_seat-2
	WHERE sc_date='2021-12-01' AND sc_time="21:20" AND sc_room_num=1;
SELECT * FROM schedule;

-- 12월 1일 21:20분 1관에서 하는 영화의 예매가능좌석 확인
SELECT * FROM seat;
SELECT * FROM schedule;
SELECT * FROM ticketing_list;

-- LEFT JOIN 사용해야함
SELECT * FROM seat
		JOIN schedule ON st_room_num=sc_room_num
        RIGHT JOIN ticketing_list ON tl_st_num != st_num
        WHERE sc_date="2021-12-01" AND sc_time="21:20" AND st_state="예약가능" ORDER BY st_name ASC;

-- 됐음 ㅇㅅㅇ~ 근데 강남점 조건 안 건 상태
SELECT st_name FROM seat LEFT JOIN ticketing_list ON tl_st_num = st_num
	WHERE st_state="예약가능" AND st_room_num=1;

-- cgv강남지점 1관에서 에서 12월 1일 21:20분에 상영하는 영화의 예매가능한 좌석을 확인
SELECT th_name, st_room_num, st_name FROM seat JOIN theater ON th_num = st_th_num
	WHERE th_name = "CGV강남" AND st_room_num =1;
-- 위에꺼 줄이기
SELECT st_room_num, st_name FROM seat WHERE st_th_num=1;


-- CGV강남지점 12월 1일 21:20분 1관에서 하는 영화 예매 내역
SELECT * FROM ticketing_list
	JOIN ticketing ON tl_tk_num = tk_num
    JOIN schedule ON tk_sc_num = sc_num
    WHERE sc_th_num = 1 AND sc_room_num=1 AND sc_date="2021-12-01" AND sc_time="21:20";
-- 위에꺼 줄이기
SELECT * FROM ticketing_list
	JOIN ticketing ON tl_tk_num = tk_num
    WHERE tk_sc_num = 2;

-- 최종결과 쿼리문 
SELECT st_name FROM seat LEFT
	JOIN (SELECT * FROM ticketing_list
			JOIN ticketing ON tl_tk_num = tk_num
			WHERE tk_sc_num = 2)
		AS tl
	ON st_num = tl_st_num
    WHERE st_th_num=1 AND st_room_num=1 AND tl_num IS NULL;

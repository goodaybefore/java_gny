SELECT * FROM student;
TRUNCATE student;
UPDATE student 
	SET
		st_id = 'nayoung2',
        st_pw = 'ny7236'
	WHERE
		st_num = '2021123001';

UPDATE student 
	SET
		st_id = 'nayoung21',
        st_pw = 'ny72361'
	WHERE
		st_name='권나영';
UPDATE subject
	SET
    su_schedule = "월요일 1,2교시",
    su_class_num = 3
    WHERE
    su_num=1
    ;
SELECT * FROM university_ny.student;
CREATE TABLE tbl_cbt (
    cb_id NUMBER PRIMARY KEY,
    cb_Question nVARCHAR2(200) NOT NULL,
    cb_bogi nVARCHAR2(200) NOT NULL,
    cb_answer nVARCHAR2(200) NOT NULL
);

DESC tbl_cbt;

delete from tbl_cbt;

Drop sequence seq_cbt;


CREATE SEQUENCE SEQ_CBT
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;
INSERT INTO tbl_cbt VALUES(SeQ_CBT.nextval, '안녕하세요', '정답은', '이겁니다');

commit;

select * from tbl_cbt;


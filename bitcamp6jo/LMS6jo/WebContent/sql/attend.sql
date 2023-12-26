drop table attend2;
drop sequence attend2_seq;
create table attend2(
	attno                 NUMBER  NOT NULL ,
	state                 NUMBER  NOT NULL ,
	attdate               DATE  NULL ,
	userno                NUMBER  NOT NULL ,
);
create sequence attend2_seq;
--dummy
insert into attend2 values(attend2_seq.nextval, );



SELECT B.NAME FROM USERS B, Assign A WHERE A.ASSNO=1;
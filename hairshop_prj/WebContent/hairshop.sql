--public class hairDTO {
--   //회원 관리 dto
--private String id=null;
--private String pw= null;
--private String name= null;
--private String phone= null;
--private String address= null;
--private String enroll= null;


create table rPWjd (
   id          varchar2(20)  primary key,
   pwd         varchar2(20),
   name        varchar2(40),
   phoneNumber       varchar2(20),
   address varchar2(60),
   enroll date
);

--회원 관리 dto 
insert into rPWjd values('hoon', '1234', '최훈', '010-1234-1234', '인천 어딘가', sysdate);
insert into rPwjd values('kjh', '1234', '김진혁', '010-2608-2608', '서울 어딘가', sysdate);
insert into rPwjd values('lsw', '1234', '이상우', '010-5678-5678',' 경기 어딘가', sysdate);

------9.21완료--점검 완료-- 오라클 저장 완료

//예약 테이블
private String rsv_date= null;
private String rsv_time= null;
private String rsv_status= null;
private String p_type= null;

-- 예약 테이블
create table dPdir (
   rsv_date varchar2(40),
   rsv_time varchar2(40),
   rsv_status char(1) default 0,
   p_type varchar2(60),
   id varchar2(20),
constraint pk_rsv_date primary key(rsv_date),
constraint fk_id foreign key(id) REFERENCES rPWjd (id)
);

   

insert into dPdir values('2020-09-22', '06:20 pm', '0', '염색', 'hoon'); 
insert into dPdir values('2020-09-23', '07:20 pm', '0', '펌', 'kjh');
insert into dPdir values('2020-09-24', '08:20 pm', '0', '반삭', 'lsw');

--관리자 테이블 
--private String workerid= null;
--private String workerpw= null;

 -- 관리자 테이블
create table worker(
   adminID varchar2(10),
   workerpw varchar2(10)
);

insert into worker values('admin1', '1234');
insert into worker values('admin2', '1234');


create table sangSE ( 
   rsv_date varchar2(20),
   p_type varchar2(20),
   id varchar2(15),
constraint fk_rsv_date foreign key(rsv_date ) REFERENCES dPdir (rsv_date)
);


insert into sangSE values('2020-09-22', '염색', 'hoon'); 
insert into sangSE values('2020-09-23', '펌', 'kjh');
insert into sangSE values('2020-09-24', '펌', 'lsw');

--commit;
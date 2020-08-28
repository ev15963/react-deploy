CREATE TABLE member_jdbc (
 name VARCHAR (50) not null,
 address VARCHAR (60) not null, 
 email VARCHAR (30),
 PRIMARY KEY(email)
);



insert into member_jdbc(name, address, email) values ('free','서울시', 'freeflux@naver.com');
insert into member_jdbc(name, address, email) values ('클라우드','뉴욕', 'cloud@gmail.com');
insert into member_jdbc(name, address, email) values ('애플','실리콘밸리', 'apple@icloud.com');

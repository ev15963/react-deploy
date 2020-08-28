SQL> CREATE TABLE member_jdbc (
  2   name VARCHAR (50) not null,
  3   address VARCHAR (60) not null,
  4   email VARCHAR (30),
  5   PRIMARY KEY(email)
  6  );

Table created.

SQL> insert into member_jdbc(name, address, email) values ('free','서울시', 'freeflux@naver.com');

1 row created.

SQL> insert into member_jdbc(name, address, email) values ('클라우드','뉴욕', 'cloud@gmail.com');

1 row created.

SQL> insert into member_jdbc(name, address, email) values ('애플','실리콘밸리', 'apple@icloud.com');

1 row created.

SQL> commit;

Commit complete.
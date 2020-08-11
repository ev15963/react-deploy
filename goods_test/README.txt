
SQL*Plus: Release 11.2.0.2.0 Production on 화 8월 11 09:19:10 2020

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

SQL>
SQL> conn system/1234
Connected.
SQL> create user naver_store identified by naver;

User created.

SQL> grant connect, resource to naver_store;

Grant succeeded.

SQL> conn naver_store/naver;
Connected.
SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  quantity int not null,
  5  discount int not null,
  6  delivery_charge int not null,
  7  price int not null.
  8  name varchar2(200) not null,
  9  primary key(code)
 10  );
price int not null.
                  *
ERROR at line 7:
ORA-00907: missing right parenthesis


SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  quantity int not null,
  5  discount int not null,
  6  delivery_charge int not null,
  7  price int not null.
  8  name varchar2(200) not null,
  9  primary key(code)
 10  );
price int not null.
                  *
ERROR at line 7:
ORA-00907: missing right parenthesis


SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  quantity int not null,
  5  discount int not null,
  6  delivery_charge int not null,
  7  price int not null,
  8  name varchar2(200) not null,
  9  primary key(code)
 10  );

Table created.

SQL> desc store
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CODE                                      NOT NULL NUMBER(38)
 PRODUCT                                   NOT NULL VARCHAR2(100)
 QUANTITY                                  NOT NULL NUMBER(38)
 DISCOUNT                                  NOT NULL NUMBER(38)
 DELIVERY_CHARGE                           NOT NULL NUMBER(38)
 PRICE                                     NOT NULL NUMBER(38)
 NAME                                      NOT NULL VARCHAR2(200)

SQL> drop table store;

Table dropped.

SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  content clob not null,
  5  quantity int not null,
  6  discount int not null,
  7  delivery_charge int not null,
  8  price int not null,
  9  name varchar2(200) not null,
 10  primary key(code)
 11  );

Table created.


SQL> primary key(code)
SP2-0734: unknown command beginning "primary ke..." - rest of line ignored.
SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  content clob not null,
  5  quantity int not null,
  6  discount int not null,
  7  delivery_charge int not null,
  8  price int not null,
  9  name varchar2(200) not null,
 10  primary key(code)
 11  );
create table store (
             *
ERROR at line 1:
ORA-00955: name is already used by an existing object


SQL> desc table;
ERROR:
ORA-00931: missing identifier


SQL> conn naver_store/naver;
Connected.
SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  content clob not null,
  5  quantity int not null,
  6  discount int not null,
  7  delivery_charge int not null,
  8  price int not null,
  9  name varchar2(200) not null,
 10  primary key(code)
 11  );
create table store (
             *
ERROR at line 1:
ORA-00955: name is already used by an existing object


SQL> show table;
SP2-0158: unknown SHOW option "table"
SQL> show tables;
SP2-0158: unknown SHOW option "tables"
SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  content clob not null,
  5  quantity int not null,
  6  discount int not null,
  7  delivery_charge int not null,
  8  price int not null,
  9  name varchar2(200) not null,
 10  primary key(code)
 11  );
create table store (
             *
ERROR at line 1:
ORA-00955: name is already used by an existing object


SQL> insert into table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  content clob not null,
  5  quantity int not null,
  6  discount int not null,
  7  delivery_charge int not null,
  8  price int not null,
  9  name varchar2(200) not null,
 10  primary key(code)
 11  );
insert into table store (
            *
ERROR at line 1:
ORA-00903: invalid table name


SQL> drop table store cascade constraints;

Table dropped.

SQL> drop table store cascade constraints;
drop table store cascade constraints
           *
ERROR at line 1:
ORA-00942: table or view does not exist


SQL> create table store (
  2  code int not null,
  3  product varchar2(100) not null,
  4  content clob not null,
  5  quantity int not null,
  6  discount int not null,
  7  delivery_charge int not null,
  8  price int not null,
  9  name varchar2(200) not null,
 10  primary key(code)
 11  );

Table created.

SQL> select * from store;

no rows selected

SQL> desc store
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CODE                                      NOT NULL NUMBER(38)
 PRODUCT                                   NOT NULL VARCHAR2(100)
 CONTENT                                   NOT NULL CLOB
 QUANTITY                                  NOT NULL NUMBER(38)
 DISCOUNT                                  NOT NULL NUMBER(38)
 DELIVERY_CHARGE                           NOT NULL NUMBER(38)
 PRICE                                     NOT NULL NUMBER(38)
 NAME                                      NOT NULL VARCHAR2(200)

SQL> insert into store values 11, '33', '3', 3, 3, 3, 3, '3'
  2  ;
insert into store values 11, '33', '3', 3, 3, 3, 3, '3'
                           *
ERROR at line 1:
ORA-00933: SQL command not properly ended


SQL> insert into store values 11, '33', '3', 3, 3, 3, 3, '3';
insert into store values 11, '33', '3', 3, 3, 3, 3, '3'
                           *
ERROR at line 1:
ORA-00933: SQL command not properly ended


SQL>
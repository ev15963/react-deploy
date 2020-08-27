
SQL*Plus: Release 11.2.0.2.0 Production on 목 8월 27 09:55:34 2020

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

SQL> conn lsw/1234;
Connected.

SQL> alter table board drop primary key cascade;

Table altered.

SQL> drop table board;

Table dropped.

SQL> create table board(
  2  num number(5) primary key,
  3  name varchar2(40),
  4  pass varchar2(20),
  5  email varchar2(40),
  6  title varchar2(100),
  7  content varchar2(1000),
  8  writedate date default sysdate,
  9  readcount number(7) default '0'
 10  );

Table created.

SQL> drop sequence board_seq;

Sequence dropped.

SQL> create sequence board_seq start with 1;

Sequence created.

SQL> commit;

Commit complete.

SQL>
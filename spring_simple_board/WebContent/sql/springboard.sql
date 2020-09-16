create table springboard(
num number(3) primary key,
author varchar2(15),
title varchar(50),
content varchar2(4000),
writeday date default sysdate,
readcnt number(4) default 0
);

insert into springboard (num, author, title, content)
	values (1,'GD.Hong', 'spring ex1', 'spring test content1');
insert into springboard (num, author, title, content)
	values (2, 'SL.Kim', 'spring ex2', 'spring test content2');
insert into springboard (num, author, title, content)
	values (3, 'YS.Han', 'spring ex3', 'spring test content3');
insert into springboard (num, author, title, content)
	values (4, 'JH.Oh', 'spring ex4', 'spring test content4');
insert into springboard (num, author, title, content)
	values (5, 'BH.Lee', 'spring ex5', 'spring test content5');
insert into springboard (num, author, title, content)
	values (6, 'DH.Shin', 'spring ex6', 'spring test content6');
insert into springboard (num, author, title, content)
	values (7, 'DG.Jang', 'spring ex7', 'spring test content7');
insert into springboard (num, author, title, content)
	values (8, 'MS.Lee', 'spring ex8', 'spring test content8');
insert into springboard (num, author, title, content)
	values (9, 'WS.Kam', 'spring ex9', 'spring test content9');
insert into springboard (num, author, title, content)
	values (10, 'SG.Ahn', 'spring ex10', 'spring test content10');
sql创建语句

create table novelInfo (
id int not null auto_increment,
url varchar(100) not null ,
name varchar(50) not null,
author varchar(50) not null,
description text,
type varchar(20),
chaptercount int not null,
updatetime date,
PRIMARY key(id)
)

create table chapterdetail(
id int not null auto_increment,
url varchar(100) not null,
title varchar(50) not null,
content text not null,
novelId int not null,
primary key (id)
)

drop table if EXISTS novelsite;
create table novelsite(
id int not null,
siteurl varchar(50) not null,
noveltype varchar(50) not null,
noveltypeurl varchar(50) not null,
catchstatue varchar(1) not null,
primary key (id)
)



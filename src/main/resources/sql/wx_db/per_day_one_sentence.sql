create table per_day_one_sentence (
id INTEGER  primary key autoincrement ,
day varchar(30) unique ,
sentence varchar(2000),
author varchar (300),
source varchar (1000),
remark varchar (200)
)
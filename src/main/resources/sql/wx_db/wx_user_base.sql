create table wx_user_base (
  id Integer primary key autoincrement,
  info_no varchar(48) unique ,
  wx_account varchar(100) unique,
  nick_name varchar(100) ,
  gender INTEGER ,
  language varchar(100),
  country varchar(100),
  province varchar(48),
  city varchar(100)
);
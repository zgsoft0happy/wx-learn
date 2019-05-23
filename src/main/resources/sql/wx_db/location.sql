create table location_trace (
  id INTEGER PRIMARY KEY autoincrement,
  wx_account varchar(100),
  latitude varchar(20),
  longitude varchar(20),
  address varchar(255),
  type Integer,
  create_time Integer
);

  Create index inx_account on location_trace (wx_account) ;
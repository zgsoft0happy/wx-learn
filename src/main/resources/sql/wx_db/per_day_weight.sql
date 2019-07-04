CREATE TABLE per_day_weight (
  id INTEGER PRIMARY KEY AUTOINCREMENT, -- 自增主键
  user_no varchar(100), -- 用户编号
  day VARCHAR(30) not null, -- 日期
  weight INTEGER not null , --体重，单位g
  create_time INTEGER , --建立时间
  update_time INTEGER , -- 更新时间
  remark VARCHAR(255) --备注信息
  );
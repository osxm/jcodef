create table stock_basic (
  id varchar2(10)  NOT NULL PRIMARY KEY,
  market varchar2(4) NOT NULL ,
  name varchar2(20)  NOT NULL
);


create table stock_index(
  id varchar2(10)  NOT NULL PRIMARY KEY,
  sDate varchar2(10)  NOT NULL,
  ema12 number,
  ema26 number
);
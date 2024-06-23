create table ORDERS(
  ID int not null AUTO_INCREMENT,
  UNIT varchar(10) not null,
  DESCRIPTION varchar(100) not null,
  QUANTITY int,
  PRIMARY KEY ( ID )
);
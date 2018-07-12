alter table user add create_Time datetime;
alter table user add lastlogin_Time datetime;
alter table user add login_Num int(11) NOT NULL DEFAULT '0';
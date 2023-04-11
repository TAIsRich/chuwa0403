# question 1
create database test;
use test;
create table oms_company_address(
	id bigint,
	address_name varchar(200), 
    send_status int(1), 
    receive_status int(1),
    `name` varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200),
    primary key (id)
);

# question 2
insert into oms_company_address (id,address_name) values(0, "home");
insert into oms_company_address (id,address_name) values(1, "work");
insert into oms_company_address values(2, "default",1,1,"Jone", "BJ","10010","BJ","BJ","100 Street");
insert into oms_company_address values(3, "work",0,0,"Jone", null, null,null ,null,null);

# question 3
select * from oms_company_address;

# question 4
select * from oms_company_address limit 3;

# question 5
set SQL_SAFE_UPDATES = 0;
update oms_company_address set phone = "666-6666-8888";

# question 6
delete from oms_company_address where id = 0;
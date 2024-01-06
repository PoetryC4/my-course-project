

create table IF NOT EXISTS user_info(
user_id int not null AUTO_INCREMENT,
user_name varchar(100) not null,
user_email varchar(20) not null,
password varchar(100) not null,
avatar varchar(100) null,
user_status smallint not null,
primary key(user_id)
);

drop table user_info;

select * from user_info;

truncate table user_info;


create table admin(
    admin_id int not null AUTO_INCREMENT,
    admin_name varchar(20) not null,
    admin_status smallint not null,
    admin_password varchar(100) not null,
    primary key(admin_id)
);

insert into admin(admin_name,admin_status,admin_password) values('admin',1,'fcea920f7412b5da7be0cf42b8c93759');


select DATE_FORMAT(trade_date,'%Y/%m/%d') from real_time_stock;
show databases ;
use demo_db;
show tables ;
select *from t_user_info_seq;
select *from t_user_info;

drop table t_user_info;
drop table t_user_info_seq;

delete from t_user_info where user_id=2;

create table test (
    id int primary key auto_increment,
    name varchar(32),
    age int
);

INSERT INTO test (name, age) VALUES ('Alice', 70);

ALTER TABLE test MODIFY id INT AUTO_INCREMENT;

#delete all date in the table
delete from test;

#Create user table
create table user(
    id bigint primary key auto_increment,
    name varchar(32),
    age int
);

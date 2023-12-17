CREATE DATABASE db202012015;
USE db202012015;
CREATE USER 'lsm'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON db202012015.* TO 'lsm'@'%';
FLUSH PRIVILEGES;
drop table t_m202012015;
create table t_m202012015(
                             mid bigint auto_increment primary key,
                             full_name varchar(30) not null,
                             email varchar(30) not null,
                             pw varchar(30) not null,
                             zipcode varchar(5),
                             reg_timestamp TIMESTAMP DEFAULT NOW()
);

insert into t_m202012015(full_name, email, pw, zipcode) value ('이상민','qwe@qwe.qwe','1234',12345);
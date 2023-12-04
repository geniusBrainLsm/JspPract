CREATE DATABASE db202012015;
CREATE USER 'u_a202012015'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON db202012015.* TO 'u_a202012015'@'%';
FLUSH PRIVILEGES;



create table t_prja202012015 (
    pid bigint auto_increment primary key,
    project_name varchar(30) not null,
    project_descriptions varchar(30) ,
    status varchar(15) not null ,
    client_company varchar(5),
    project_leader varchar(30),
    estimated_budget bigint,
    total_amount_spent bigint,
    estimated_project_duration bigint
);
/* CRUD - insert select update delete */
insert into t_prja202012015(project_name, status) value ('LSM_Project', 'On Hold'); /* On Hold, Canceld, Success */

select * from t_prja202012015;

select * from t_prja202012015 where pid = 1;

update t_prja202012015 set status = 'Success' where pid = 1;

delete from t_prja202012015 where pid = 1;
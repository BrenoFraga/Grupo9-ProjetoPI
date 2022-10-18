drop database findr;
create database findr;
use findr;
show tables;

show tables;
create table plans(
id_plan bigint primary key not null auto_increment,
plan_type varchar(15),
quantity_clicks int
);

create table contactor (
id_contactor bigint primary key not null auto_increment,
    image blob,
    `name` varchar(45),
    email varchar(45),
    `password` varchar(25),
    cnpj char(14),
    cpf char(11),
    phone_contact char(11),
    country varchar(45),
    state varchar(45),
    city varchar(45),
    fk_plan_contactor bigint,
    foreign key(fk_plan_contactor) references plans(id_plan)
);

create table user_freelancer(
id_user_freelancer bigint primary key not null auto_increment,
image blob,
`name` varchar(45),
    email varchar(45),
    `password` varchar(25),
    cnpj char(14),
    cpf char(11),
    phone_contact char(11),
    country varchar(45),
    state varchar(45),
    city varchar(45),
    avaliable_time char(2),
    fk_plan_freelancer  bigint,
    foreign key(fk_plan_freelancer) references plans(id_plan)
);

create table register_specialty_user(
id_specialty bigint primary key not null auto_increment,
ocupation_area varchar(30),
technology_used varchar(15),
level_knowledge varchar(15),
fk_freelancer  bigint,
foreign key(fk_freelancer) references user_freelancer(id_user_freelancer)
);

create table register_project_contactor(
id_project_contactor bigint primary key not null auto_increment,
image blob,
name_project varchar(100),
description_project varchar(200),
required_area varchar(30),
required_languages varchar(15),
quantity_profissionals int,
fk_contactor bigint,
foreign key(fk_contactor) references contactor(id_contactor)
);

create table like_project(
fk_project bigint,
fk_contactor bigint,
fk_freelancer bigint,
date_hour datetime,
evaluation char(5),
foreign key(fk_contactor) references contactor(id_contactor),
foreign key(fk_freelancer) references user_freelancer(id_user_freelancer),
foreign key(fk_project) references register_project_contactor(id_project_contactor),
primary key(fk_project,fk_contactor,fk_freelancer)

);

create table like_freelancer(
fk_contactor bigint,
fk_freelancer bigint,
fk_specialty  bigint,
date_hour datetime,
evaluation char(5),
foreign key(fk_contactor) references contactor(id_contactor),
foreign key(fk_freelancer) references user_freelancer(id_user_freelancer),
foreign key(fk_specialty) references register_specialty_user(id_specialty),
primary key(fk_contactor,fk_freelancer,fk_specialty)
);

create table match_user(
fk_contactor bigint,
fk_freelancer bigint,
date_hour datetime,
foreign key(fk_contactor) references contactor(id_contactor),
foreign key(fk_freelancer) references user_freelancer(id_user_freelancer),
primary key(fk_contactor,fk_freelancer)
);

create table log_login(
fk_contactor bigint,
fk_freelancer bigint,
date_hour datetime,
foreign key(fk_contactor) references contactor(id_contactor),
foreign key(fk_freelancer) references user_freelancer(id_user_freelancer),
primary key(fk_contactor,fk_freelancer)
);

insert into plans values 
(null, "basic", 10),
(null, "medium", 20),
(null, "pro", 30),
(null,"master",40);

select * from contactor;

select * from user_freelancer;

select * from register_project_contactor;
drop table register_project_contactor;
drop table like_project;
SELECT * FROM register_specialty_user;

select name,ocupation_area,technology_used,level_knowledge from user_freelancer inner join register_specialty_user on id_user_freelancer = fk_freelancer;

insert into like_freelancer values(2,2,2,now(),"true");
insert into like_project values(2,2,2,now(),"true");
select COUNT(distinct(fk_contactor))  from register_project_contactor;
use findr;
select * from like_freelancer;
insert into match_user values 
(1, 1, now());


select required_languages,count(required_languages) as quantidade from register_project_contactor GROUP BY required_languages order by quantidade desc;

select technology_used,count(technology_used) as tecnologias from register_specialty_user GROUP BY technology_used order by tecnologias desc;

CREATE VIEW tecnologias_requeridas as select required_languages,count(required_languages) as quantidade from register_project_contactor GROUP BY required_languages order by quantidade desc;

CREATE VIEW tecnologias_usadas as select technology_used,count(technology_used) as tecnologias from register_specialty_user GROUP BY technology_used order by tecnologias desc;
INSERT INTO register_specialty_user VALUES (null, 'Frontend','React','1',3);

drop view linguagens;
drop view linguagens_usadas;
select * from tecnologias_requeridas;
select * from tecnologias_usadas;
show tables; 
select * from match_user;
insert into match_user values(2,2,now());



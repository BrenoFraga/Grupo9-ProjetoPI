CREATE TABLE user_contactor(
id_contactor INTEGER PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45),
email VARCHAR(45),
password VARCHAR(25),
cnpj CHAR(11),
cpf CHAR(11),
phone_contact CHAR(9),
country VARCHAR(45),
state VARCHAR(45),
city VARCHAR(45),
fk_status_contactor INTEGER,
fk_plan_contactor INTEGER );


CREATE TABLE user_freelancer(
id_user_freelancer INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
email VARCHAR(45),
password VARCHAR(45),
cpf VARCHAR(11),
phone_contact CHAR(9),
country VARCHAR(45),
state VARCHAR(45),
available_time CHAR(2),
fk_status_freelancer INTEGER,
fk_plan_freelancer INTEGER
);


CREATE TABLE register_project_contactor(
id_project_contactor INT PRIMARY KEY AUTO_INCREMENT,
name_project VARCHAR(15),
description_project VARCHAR(200),
required_area VARCHAR(30),
required_languages VARCHAR(15),
quantity_profissionals INTEGER,
fk_contactor INTEGER
);

CREATE TABLE register_specialty_user(
id_specialty INT PRIMARY KEY AUTO_INCREMENT,
occupation_area VARCHAR(30),
technology_user VARCHAR(15),
level_knowledge VARCHAR(15),
fk_freelancer INTEGER
);

CREATE TABLE status_user(
id_status_user INT PRIMARY KEY AUTO_INCREMENT,
status VARCHAR(15)
);

CREATE TABLE plans(
id_plans INT PRIMARY KEY AUTO_INCREMENT,
plan_type VARCHAR(25),
quantity_clicks INT
);

CREATE TABLE match_project(
fk_project_contactor INT,
fk_contactor INT,
date_hour DATE,
evaluation INT,
fk_freelancer INT,
FOREIGN KEY(fk_freelancer) REFERENCES register_project_contactor(id_project_contactor)
);

CREATE TABLE match_contactor(
fk_contactor INT,
fk_administrator INT,
fk_freelancer INT,
date_hour DATE,
evaluation INT
);

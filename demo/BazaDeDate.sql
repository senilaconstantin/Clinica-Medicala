Drop database if exists ClinicaMedicala;
CREATE SCHEMA  ClinicaMedicala;
USE ClinicaMedicala;

drop table if exists user;
CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY ,
	firstName VARCHAR(45) NOT NULL,
	lastName VARCHAR(45) NOT NULL,
	userName VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    role VARCHAR(45) NOT NULL,
    drugsRecipe varchar(45),
    department VARCHAR(45),
    phoneNumber varchar(10) 
);

drop table if exists appointment;
CREATE TABLE IF NOT EXISTS appointment (
    id INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY ,
	patientId Int not null,
	doctorId Int not null,
    date Date	
);


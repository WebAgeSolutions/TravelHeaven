drop database if exists traveldb;

create database traveldb;

use traveldb;

create table TravelPackage (
	id integer not null AUTO_INCREMENT,
	title varchar(256) not null,
	description varchar(1028),
	price double,
	rating double,
	featured char(1),
	
	primary key (id)
);
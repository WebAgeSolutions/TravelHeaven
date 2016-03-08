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
	image varchar(256),
	
	primary key (id)
);

create table Booking (
	id integer not null AUTO_INCREMENT,
	userId varchar(256) not null,
	packageId integer not null,
	forDate varchar(15) not null,
	
	primary key (id),
	foreign key (packageId) references TravelPackage(id)
);

insert into TravelPackage (title, description, price, rating, featured, image) values
('South Beach Hotel', 'Stay right in the middle of the action.', 250.00, 4.5, 'N', '');
insert into TravelPackage (title, description, price, rating, featured, image) values
('Fabulous dining', 'Dine at some of the most beautiful places.', 125.00, 5, 'Y', '');

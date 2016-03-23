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
('Harbor cruise', 'Enjoy the sights and sound of the harbor in this 3 hour long cruise. Light snacks and non-alcoholic beverage will be served.', 99.00, 4.5, 'N', 'harbor-cruise.jpg');
insert into TravelPackage (title, description, price, rating, featured, image) values
('Helicopter ride', 'Watch scenic Hawai from a helicopter. Our knowledgable guide pilot will give you a tour of the volcanoes. The tour is 45 minutes long.', 150.00, 5, 'Y', 'helicopter-ride.jpg');
insert into TravelPackage (title, description, price, rating, featured, image) values
('Horseback riding', 'Two hour long guided ride through the mountains. Enjoy the fresh air and learn about the flora and fauna of this area.', 75.00, 3.5, 'Y', 'horseback.jpg');
insert into TravelPackage (title, description, price, rating, featured, image) values
('Sunset dinner', 'Enjoy gourmet dinner overlooking the ocean in a most romantic setting.', 55.00, 5, 'Y', 'sunset-dinner.jpg');

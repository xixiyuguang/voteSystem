CREATE DATABASE vote DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create table voter(
	id int not null auto_increment,
	ip varchar(20) not null unique,
	create_date timestamp,
	update_date timestamp,
	PRIMARY KEY (id)
);

create table candidate(
	id int not null auto_increment,
	name varchar(20),
	sex char(2),
	age int,
	address varchar(50),
	introduce varchar(255),
	image varchar(255),
	ballot int default 0,
	PRIMARY KEY (id)
);

create table admin(
	id int not null auto_increment,
	name varchar(20),
	account varchar(20) not null unique,	
	password varchar(20),
	PRIMARY KEY (id)
);

create table photo(
	id int not null auto_increment,
	photo_name varchar(255),
	PRIMARY KEY (id)
);

create table message(
	id int not null auto_increment,
	name varchar(255),
	phone varchar(255),
	words varchar(255),
	PRIMARY KEY (id)
);


insert into admin values (null,'于光','yg','yg')
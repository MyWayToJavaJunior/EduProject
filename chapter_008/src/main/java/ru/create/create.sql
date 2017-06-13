create database eduDB;

create table Role (
	id_role serial primary key ,
	name_role character varying (300)
);

create table Role_rights (
	id_rights serial primary key ,
	name_rights character varying (300)
);

create table Role_Role_Rights (
	id serial not null unique,
	id_role integer references Role(id_role),
	id_rights integer references Role_rights(id_rights),
	CONSTRAINT Role_pk PRIMARY KEY ("id_role","id_rights")
);

create table Usr (
	id_user serial primary key,
	login character varying (200),
	pass character varying (200),
	id_role integer references Role_Role_Rights(id)
);

create table Comment (
	id_comment serial primary key,
	description text,
	comm_date timestamp
);

create table File (
	id_file serial primary key,
	file bytea
);

create table Category (
	id_cat serial primary key,
	category character varying (100)
);

create table Status (
	id_stat serial primary key,
	status character varying (100)
);

create table Item (
	id_item serial primary key,
	name_item character varying (300),
	create_date timestamp,
	id_creator integer references Usr(id_user),
	id_comment integer references Comment(id_comment),
	id_file integer references File(id_file),
	id_cat integer references Category(id_cat),
	id_stat integer references Status(id_stat)
);


insert into Role (name_role) values ('Admin');
insert into Role (name_role) values ('User');

insert into Role_rights (name_rights) values ('Write');
insert into Role_rights (name_rights) values ('Read');

insert into Role_Role_Rights (id_role, id_rights) values ('1', '1');
insert into Role_Role_Rights (id_role, id_rights) values ('1', '2');
insert into Role_Role_Rights (id_role, id_rights) values ('2', '2');

insert into Usr (login, pass,id_role) values ('admin', 'admin','1');
insert into Usr (login, pass,id_role) values ('user', 'user','2');

insert into Comment (description, comm_date) values ('com 01', '2000-05-05 05:05:05');
insert into Comment (description, comm_date) values ('com 02', '2002-05-05 05:05:05');

insert into Category (category) values ('category 01');
insert into Category (category) values ('category 02');

insert into Status (status) values ('in progress');
insert into Status (status) values ('OK');

insert into Item (name_item, create_date, id_creator, id_comment, id_file, id_cat, id_stat) values ('Item 01', '2002-05-05 05:05:05', '1', '1', null, '1', '1');
insert into Item (name_item, create_date, id_creator, id_comment, id_file, id_cat, id_stat) values ('Item 02', '2002-05-05 05:05:05', '2', '1', null, '1', '1');

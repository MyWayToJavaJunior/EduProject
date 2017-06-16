create database carCatalog;

create table Transmission (
	id_trans serial primary key ,
	name_trans character varying (300)
);

create table carBody (
	id_body serial primary key ,
	name_body character varying (300)
);

create table Engine (
	id_eng serial primary key ,
	name_eng character varying (300)
);

create table Car (
	id_car serial primary key ,
	name_car character varying (300),
	id_t integer not null references Transmission(id_trans),
	id_b integer not null references carBody(id_body),
	id_e integer not null references Engine(id_eng)
);

insert into Transmission (name_trans) values ('Transmission #1');
insert into Transmission (name_trans) values ('Transmission #2');
insert into Transmission (name_trans) values ('Transmission #3');
insert into Transmission (name_trans) values ('Transmission #4');
insert into Transmission (name_trans) values ('Transmission #5');

insert into carBody (name_body) values ('carBody #1');
insert into carBody (name_body) values ('carBody #2');
insert into carBody (name_body) values ('carBody #3');
insert into carBody (name_body) values ('carBody #4');
insert into carBody (name_body) values ('carBody #5');

insert into Engine (name_eng) values ('Engine #1');
insert into Engine (name_eng) values ('Engine #2');
insert into Engine (name_eng) values ('Engine #3');
insert into Engine (name_eng) values ('Engine #4');
insert into Engine (name_eng) values ('Engine #5');

insert into Car (name_car, id_t, id_b, id_e) values ('car #1', 1, 1, 1);
insert into Car (name_car, id_t, id_b, id_e) values ('car #2', 2, 2, 2);

-- All cars
select c.id_car as "ID", c.name_car as "Name", t.name_trans as "Transmission", b.name_body as "Car body", e.name_eng as "Engine" from Car as c
inner join Transmission t on c.id_t = t.id_trans
inner join carBody b on c.id_b = b.id_body
inner join Engine e on c.id_e = e.id_eng;

-- All unused transmission
select t.id_trans as "ID", t.name_trans as "Name" from Car as c
right outer join Transmission as t on t.id_trans = c.id_t
where c.name_car is null;

-- All unused car body
select b.id_body as "ID", b.name_body as "Name" from Car as c
right outer join carBody as b on b.id_body = c.id_b
where c.name_car is null;

-- All unused car engine
select e.id_eng as "ID", e.name_eng as "Name" from Car as c
right outer join Engine as e on e.id_eng = c.id_e
where c.name_car is null;

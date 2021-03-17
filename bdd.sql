create table MStock(
	id varchar(10) primary key,
	produit varchar(30),
	type varchar(10),
	quantite varchar(20),
	PU varchar(20),
	montant varchar(20)
);

create table MvtStock(
	id varchar(10) primary key,
	produit varchar(30),
	type varchar(10),
	quantite varchar(20),
	PU varchar(20),
	montant varchar(20)
);

create sequence idStock start with 1 increment by 1;
create sequence idMvtStock start with 1 increment by 1;
	
-- temps timestamp
create database db_colas;

use db_colas;

create table tb_colas(
idcola		int auto_increment,
turno		int,
fecha		date,
tipo 	 	int, -- 1VENTANILLA 2CAJA --3TURNO
estado		int,  -- 0LIBRE 1ATENDIENDO 2AUSENTE 3ATENDIDO
ventanilla	int,
primary key (idcola,turno)
);

create table tb_errores(
id	 		int primary key auto_increment,
error		varchar(200),
fecha		timestamp
);


insert into tb_colas values(null, 1, '2019-11-06', 1, 1, 5);
insert into tb_colas values(null, 2, '2019-11-06', 1, 1, 4);
insert into tb_colas values(null, 3, '2019-11-06', 1, 1, 3);
insert into tb_colas values(null, 4, '2019-11-06', 1, 0, 10);
insert into tb_colas values(null, 10, '2019-11-06', 1, 0, 13);

insert into tb_colas values(null, 50, '2019-11-08', 1, 3, 10);

insert into tb_colas values(null, 1, '2019-11-12', 1, 1, 15);




SET SQL_SAFE_UPDATES = 0;
 
select turno from tb_colas order by turno desc LIMIT 1;

select turno from tb_colas  where fecha = CURDATE() order by turno desc LIMIT 1;

select turno from tb_colas where estado = 0 order by turno asc LIMIT 1;

select turno from tb_colas where estado = 0 and fecha = CURDATE() order by turno asc LIMIT 1;

select * from tb_colas where estado != 0 and fecha = CURDATE() order by turno desc LIMIT 4;


select turno from tb_colas  where fecha = CURDATE() and tipo = 1 order by turno desc LIMIT 1;

select turno from tb_colas where estado = 0 and fecha = CURDATE() order by turno asc LIMIT 1;

update tb_colas set estado=1 where turno=1;

update tb_colas set estado=1, ventanilla=5 where turno = 2 and fecha = CURDATE() and tipo = 1;

select ip from tb_ventanilla where ip = '192.168.1.1' and tipo;

select tipo, turno, ventanilla, estado, fecha from tb_colas where fecha between '2019-11-08'  and '2019-11-09' order by tipo;

update tb_colas set estado=2, ventanilla=20 where turno = 18 and fecha = CURDATE()  and tipo = 1;

select * from tb_colas;

select * from tb_errores;

show status like 'Threads%';

drop database db_colas;


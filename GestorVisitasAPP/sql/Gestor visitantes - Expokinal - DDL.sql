-- Gestor de Visitante - Proyecto expokinal
create database gestor_visitantes_in4cm;
use gestor_visitantes_in4cm;

create table visitantes(
	id_visitante INT primary key ,
	nombres VARCHAR(100) ,
	apellidos VARCHAR(100) ,
	tipo_visitante VARCHAR(50)
	);

create table secretarios(
	id_secretario INT primary key ,
	nombres VARCHAR(100) ,
	apellidos VARCHAR(100) ,
	cargo_puesto VARCHAR(100)
	);

create table areas(
	id_area INT primary key ,
	nombre_area VARCHAR(100) ,
	carrera_tecnica_asignada VARCHAR(100)
	);

create table gafetes(
	id_gafete INT primary key ,
	tipo_gafete VARCHAR(50) ,
	estado_gafete VARCHAR(50)
	);

create table vehiculos(
	placa VARCHAR(15) primary key ,
	tipo_vehiculo VARCHAR(50) ,
	color_vehiculo VARCHAR(50)
	);

create table visitas(
	id_visita INT primary key ,
	fecha_hora_entrada TIMESTAMP default current_timestamp ,
	fecha_hora_salida TIMESTAMP null ,
	motivo_visita VARCHAR(150) ,

	-- llaves
	id_visitante INT ,
	id_secretario INT ,
	id_area INT ,
	id_gafete INT null ,
	placa VARCHAR(15) null ,
	-- FK
	constraint fk_id_visitante foreign key (id_visitante) references visitantes (id_visitante) on delete restrict on update cascade ,
	constraint fk_id_secretario foreign key (id_secretario) references secretarios (id_secretario) on delete restrict on update cascade ,
	constraint fk_id_area foreign key (id_area) references areas (id_area) on delete restrict on update cascade ,
	constraint fk_id_gafete foreign key (id_gafete) references gafetes (id_gafete) on delete restrict on update cascade ,
	constraint fk_placa foreign key (placa) references vehiculos (placa) on delete restrict on update cascade
	);

-- Procedimientos almacenados Visitantes
-- Crear
delimiter //
create procedure sp_agregar_visitantes(
	in _id_visitante int ,
	in _nombres varchar(100) ,
	in _apellidos varchar(100) ,
	in _tipo_visitante varchar(50))
begin
	insert into visitantes(id_visitante, nombres, apellidos, tipo_visitante) values
	(_id_visitante, _nombres, _apellidos, _tipo_visitante);
end //
delimiter ;

-- Listar
delimiter //
create procedure sp_listar_visitantes()
begin
	select id_visitante, nombres, apellidos, tipo_visitante
	from visitantes;
end //
delimiter ;

-- Buscar
delimiter //
create procedure sp_buscar_visitantes(in _id_visitante int)
begin
	select id_visitante, nombres, apellidos, tipo_visitante
	from visitantes
	where id_visitante = _id_visitante;
end //
delimiter ;

-- Actualizar
delimiter //
create procedure sp_actualizar_visitantes(
	in _id_visitante int ,
	in _nombres varchar(100) ,
	in _apellidos varchar(100) ,
	in _tipo_visitante varchar(50))
begin
	update visitantes
	set nombres = _nombres, apellidos = _apellidos, tipo_visitante = _tipo_visitante
	where id_visitante = _id_visitante;
end //
delimiter ;

-- Eliminar
delimiter //
create procedure sp_eliminar_visitantes(in _id_visitante int)
begin
	delete from visitantes where id_visitante = _id_visitante;
end //
delimiter ;

-- Procedimientos almacenados Secretarios
-- Crear
delimiter //
create procedure sp_agregar_secretarios(
	in _id_secretario int ,
	in _nombres varchar(100) ,
	in _apellidos varchar(100) ,
	in _cargo_puesto varchar(100))
begin
	insert into secretarios(id_secretario, nombres, apellidos, cargo_puesto) values
	(_id_secretario, _nombres, _apellidos, _cargo_puesto);
end //
delimiter ;

-- Listar
delimiter //
create procedure sp_listar_secretarios()
begin
	select id_secretario, nombres, apellidos, cargo_puesto
	from secretarios;
end //
delimiter ;

-- Buscar
delimiter //
create procedure sp_buscar_secretarios(in _id_secretario int)
begin
	select id_secretario, nombres, apellidos, cargo_puesto
	from secretarios
	where id_secretario = _id_secretario;
end //
delimiter ;

-- Actualizar
delimiter //
create procedure sp_actualizar_secretarios(
	in _id_secretario int ,
	in _nombres varchar(100) ,
	in _apellidos varchar(100) ,
	in _cargo_puesto varchar(100))
begin
	update secretarios
	set nombres = _nombres, apellidos = _apellidos, cargo_puesto = _cargo_puesto
	where id_secretario = _id_secretario;
end //
delimiter ;

-- Eliminar
delimiter //
create procedure sp_eliminar_secretarios(in _id_secretario int)
begin
	delete from secretarios where id_secretario = _id_secretario;
end //
delimiter ;

-- Procedimientos almacenados Areas
-- Crear
delimiter //
create procedure sp_agregar_areas(
	in _id_area int ,
	in _nombre_area varchar(100) ,
	in _carrera_tecnica_asignada varchar(100))
begin
	insert into areas(id_area, nombre_area, carrera_tecnica_asignada) values
	(_id_area, _nombre_area, _carrera_tecnica_asignada);
end //
delimiter ;

-- Listar
delimiter //
create procedure sp_listar_areas()
begin
	select id_area, nombre_area, carrera_tecnica_asignada
	from areas;
end //
delimiter ;

-- Buscar
delimiter //
create procedure sp_buscar_areas(in _id_area int)
begin
	select id_area, nombre_area, carrera_tecnica_asignada
	from areas
	where id_area = _id_area;
end //
delimiter ;

-- Actualizar
delimiter //
create procedure sp_actualizar_areas(
	in _id_area int ,
	in _nombre_area varchar(100) ,
	in _carrera_tecnica_asignada varchar(100))
begin
	update areas
	set nombre_area = _nombre_area, carrera_tecnica_asignada = _carrera_tecnica_asignada
	where id_area = _id_area;
end //
delimiter ;

-- Eliminar
delimiter //
create procedure sp_eliminar_areas(in _id_area int)
begin
	delete from areas where id_area = _id_area;
end //
delimiter ;

-- Procedimientos almacenados Gafetes
-- Crear
delimiter //
create procedure sp_agregar_gafetes(
	in _id_gafete int ,
	in _tipo_gafete varchar(50) ,
	in _estado_gafete varchar(50))
begin
	insert into gafetes(id_gafete, tipo_gafete, estado_gafete) values
	(_id_gafete, _tipo_gafete, _estado_gafete);
end //
delimiter ;

-- Listar
delimiter //
create procedure sp_listar_gafetes()
begin
	select id_gafete, tipo_gafete, estado_gafete
	from gafetes;
end //
delimiter ;

-- Buscar
delimiter //
create procedure sp_buscar_gafetes(in _id_gafete int)
begin
	select id_gafete, tipo_gafete, estado_gafete
	from gafetes
	where id_gafete = _id_gafete;
end //
delimiter ;

-- Actualizar
delimiter //
create procedure sp_actualizar_gafetes(
	in _id_gafete int ,
	in _tipo_gafete varchar(50) ,
	in _estado_gafete varchar(50))
begin
	update gafetes
	set tipo_gafete = _tipo_gafete, estado_gafete = _estado_gafete
	where id_gafete = _id_gafete;
end //
delimiter ;

-- Eliminar
delimiter //
create procedure sp_eliminar_gafetes(in _id_gafete int)
begin
	delete from gafetes where id_gafete = _id_gafete;
end //
delimiter ;

-- Procedimientos almacenados Vehiculos
-- Crear
delimiter //
create procedure sp_agregar_vehiculos(
	in _placa varchar(15) ,
	in _tipo_vehiculo varchar(50) ,
	in _color_vehiculo varchar(50))
begin
	insert into vehiculos(placa, tipo_vehiculo, color_vehiculo) values
	(_placa, _tipo_vehiculo, _color_vehiculo);
end //
delimiter ;

-- Listar
delimiter //
create procedure sp_listar_vehiculos()
begin
	select placa, tipo_vehiculo, color_vehiculo
	from vehiculos;
end //
delimiter ;

-- Buscar
delimiter //
create procedure sp_buscar_vehiculos(in _placa varchar(15))
begin
	select placa, tipo_vehiculo, color_vehiculo
	from vehiculos
	where placa = _placa;
end //
delimiter ;

-- Actualizar
delimiter //
create procedure sp_actualizar_vehiculos(
	in _placa varchar(15) ,
	in _tipo_vehiculo varchar(50) ,
	in _color_vehiculo varchar(50))
begin
	update vehiculos
	set tipo_vehiculo = _tipo_vehiculo, color_vehiculo = _color_vehiculo
	where placa = _placa;
end //
delimiter ;

-- Eliminar
delimiter //
create procedure sp_eliminar_vehiculos(in _placa varchar(15))
begin
	delete from vehiculos where placa = _placa;
end //
delimiter ;

-- Procedimientos almacenados Visitas
-- Crear 
delimiter //
create procedure sp_agregar_visitas(
	in _id_visita int ,
	in _motivo_visita varchar(150) ,
	in _id_visitante int ,
	in _id_secretario int ,
	in _id_area int ,
	in _id_gafete int ,
	in _placa varchar(15))
begin
	insert into visitas(id_visita, motivo_visita, id_visitante, id_secretario, id_area, id_gafete, placa) values
	(_id_visita, _motivo_visita, _id_visitante, _id_secretario, _id_area, _id_gafete, _placa);
end //
delimiter ;

-- Listar
delimiter //
create procedure sp_listar_visitas()
begin
	select VI.id_visita, VI.fecha_hora_entrada, VI.fecha_hora_salida, VI.motivo_visita,
	V.nombres, V.apellidos, V.tipo_visitante,
	S.nombres as nombre_secretario,
	A.nombre_area,
	G.tipo_gafete,
	VH.placa, VH.tipo_vehiculo, VH.color_vehiculo
	from visitas VI
	inner join visitantes V on VI.id_visitante = V.id_visitante
	inner join secretarios S on VI.id_secretario = S.id_secretario
	inner join areas A on VI.id_area = A.id_area
	left join gafetes G on VI.id_gafete = G.id_gafete
	left join vehiculos VH on VI.placa = VH.placa;
end //
delimiter ;

-- Buscar
delimiter //
create procedure sp_buscar_visitas(in _id_visita int)
begin
	select VI.id_visita, VI.fecha_hora_entrada, VI.fecha_hora_salida, VI.motivo_visita,
	V.nombres, V.apellidos, V.tipo_visitante,
	S.nombres as nombre_secretario,
	A.nombre_area,
	G.tipo_gafete,
	VH.placa, VH.tipo_vehiculo, VH.color_vehiculo
	from visitas VI
	inner join visitantes V on VI.id_visitante = V.id_visitante
	inner join secretarios S on VI.id_secretario = S.id_secretario
	inner join areas A on VI.id_area = A.id_area
	left join gafetes G on VI.id_gafete = G.id_gafete
	left join vehiculos VH on VI.placa = VH.placa
	where VI.id_visita = _id_visita;
end //
delimiter ;

-- Actualizar 
delimiter //
create procedure sp_actualizar_visitas(
	in _id_visita int ,
	in _motivo_visita varchar(150) ,
	in _id_visitante int ,
	in _id_secretario int ,
	in _id_area int ,
	in _id_gafete int ,
	in _placa varchar(15))
begin
	update visitas
	set motivo_visita = _motivo_visita,
	id_visitante = _id_visitante, id_secretario = _id_secretario,
	id_area = _id_area, id_gafete = _id_gafete, placa = _placa
	where id_visita = _id_visita;
end //
delimiter ;

-- Eliminar
delimiter //
create procedure sp_eliminar_visitas(in _id_visita int)
begin
	delete from visitas where id_visita = _id_visita;
end //
delimiter ;

-- Registrar salida 
delimiter //
create procedure sp_registrar_salida(in _id_visita int)
begin
	update visitas
	set fecha_hora_salida = current_timestamp
	where id_visita = _id_visita;
end //
delimiter ;
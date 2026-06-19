-- Gestor de Visitante - Proyecto expokinal
create database gestor_visitantes_in4cm;
use gestor_visitantes_in4cm;
 
create table visitantes(
	id_visitante INT primary key ,
	nombres VARCHAR(100) ,
	apellidos VARCHAR(100) ,
	tipo_visitante VARCHAR(50) ,
	telefono_contacto VARCHAR(20)
	);
 
create table secretarios(
	id_secretario INT primary key ,
	nombres VARCHAR(100) ,
	apellidos VARCHAR(100) ,
	cargo_puesto VARCHAR(100) ,
	correo_electronico VARCHAR(100) ,
	jornada_laboral VARCHAR(50)
	);
 
create table areas(
	id_area INT primary key ,
	nombre_area VARCHAR(100) ,
	numero_salon_taller VARCHAR(20) ,
	sector_edificio VARCHAR(50) ,
	nivel_piso VARCHAR(20) ,
	carrera_tecnica_asignada VARCHAR(100)
	);
 
create table gafetes(
	id_gafete INT primary key ,
	tipo_gafete VARCHAR(50) ,
	estado_gafete VARCHAR(50) ,
	direccion_de_visita VARCHAR(150) ,
	estado_de_vuelta VARCHAR(50)
	);
 
create table vehiculos(
	placa VARCHAR(15) primary key ,
	tipo_vehiculo VARCHAR(50) ,
	marca VARCHAR(50) ,
	color VARCHAR(30)
	);
 
create table visitas(
	id_visita INT primary key ,
	fecha_hora_entrada TIMESTAMP default current_timestamp ,
	fecha_hora_salida TIMESTAMP ,
	motivo_visita VARCHAR(150) ,
	nombre_alumno_relacionado VARCHAR(100) ,
	grado_seccion_alumno VARCHAR(50) ,
 
	-- llaves
	id_visitante INT ,
	id_secretario INT ,
	id_area INT ,
	id_gafete INT ,
	placa VARCHAR(15) ,
	-- FK
	constraint fk_id_visitante foreign key (id_visitante) references visitantes (id_visitante) on delete cascade ,
	constraint fk_id_secretario foreign key (id_secretario) references secretarios (id_secretario) on delete cascade ,
	constraint fk_id_area foreign key (id_area) references areas (id_area) on delete cascade ,
	constraint fk_id_gafete foreign key (id_gafete) references gafetes (id_gafete) on delete cascade ,
	constraint fk_placa foreign key (placa) references vehiculos (placa) on delete cascade
	);
 
-- Procedimientos almacenados Visitantes
-- Crear
delimiter //
create procedure sp_agregar_visitantes(
	in _id_visitante int ,
	in _nombres varchar(100) ,
	in _apellidos varchar(100) ,
	in _tipo_visitante varchar(50) ,
	in _telefono_contacto varchar(20))
begin
	insert into visitantes(id_visitante, nombres, apellidos, tipo_visitante, telefono_contacto) values
	(_id_visitante, _nombres, _apellidos, _tipo_visitante, _telefono_contacto);
end //
delimiter ;
 
-- Listar
delimiter //
create procedure sp_listar_visitantes()
begin
	select id_visitante, nombres, apellidos, tipo_visitante,
	telefono_contacto
	from visitantes;
end //
delimiter ;
 
-- Buscar
delimiter //
create procedure sp_buscar_visitantes(in _id_visitante int)
begin
	select id_visitante, nombres, apellidos, tipo_visitante,
	telefono_contacto
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
	in _tipo_visitante varchar(50) ,
	in _telefono_contacto varchar(20))
begin
	update visitantes
	set nombres = _nombres, apellidos = _apellidos, tipo_visitante = _tipo_visitante,
	telefono_contacto = _telefono_contacto
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
	in _cargo_puesto varchar(100) ,
	in _correo_electronico varchar(100) ,
	in _jornada_laboral varchar(50))
begin
	insert into secretarios(id_secretario, nombres, apellidos, cargo_puesto, correo_electronico, jornada_laboral) values
	(_id_secretario, _nombres, _apellidos, _cargo_puesto, _correo_electronico, _jornada_laboral);
end //
delimiter ;
 
-- Listar
delimiter //
create procedure sp_listar_secretarios()
begin
	select id_secretario, nombres, apellidos, cargo_puesto,
	correo_electronico, jornada_laboral
	from secretarios;
end //
delimiter ;
 
-- Buscar
delimiter //
create procedure sp_buscar_secretarios(in _id_secretario int)
begin
	select id_secretario, nombres, apellidos, cargo_puesto,
	correo_electronico, jornada_laboral
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
	in _cargo_puesto varchar(100) ,
	in _correo_electronico varchar(100) ,
	in _jornada_laboral varchar(50))
begin
	update secretarios
	set nombres = _nombres, apellidos = _apellidos, cargo_puesto = _cargo_puesto,
	correo_electronico = _correo_electronico, jornada_laboral = _jornada_laboral
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
	in _numero_salon_taller varchar(20) ,
	in _sector_edificio varchar(50) ,
	in _nivel_piso varchar(20) ,
	in _carrera_tecnica_asignada varchar(100))
begin
	insert into areas(id_area, nombre_area, numero_salon_taller, sector_edificio, nivel_piso, carrera_tecnica_asignada) values
	(_id_area, _nombre_area, _numero_salon_taller, _sector_edificio, _nivel_piso, _carrera_tecnica_asignada);
end //
delimiter ;
 
-- Listar
delimiter //
create procedure sp_listar_areas()
begin
	select id_area, nombre_area, numero_salon_taller,
	sector_edificio, nivel_piso, carrera_tecnica_asignada
	from areas;
end //
delimiter ;
 
-- Buscar
delimiter //
create procedure sp_buscar_areas(in _id_area int)
begin
	select id_area, nombre_area, numero_salon_taller,
	sector_edificio, nivel_piso, carrera_tecnica_asignada
	from areas
	where id_area = _id_area;
end //
delimiter ;
 
-- Actualizar
delimiter //
create procedure sp_actualizar_areas(
	in _id_area int ,
	in _nombre_area varchar(100) ,
	in _numero_salon_taller varchar(20) ,
	in _sector_edificio varchar(50) ,
	in _nivel_piso varchar(20) ,
	in _carrera_tecnica_asignada varchar(100))
begin
	update areas
	set nombre_area = _nombre_area, numero_salon_taller = _numero_salon_taller,
	sector_edificio = _sector_edificio, nivel_piso = _nivel_piso,
	carrera_tecnica_asignada = _carrera_tecnica_asignada
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
	in _estado_gafete varchar(50) ,
	in _direccion_de_visita varchar(150) ,
	in _estado_de_vuelta varchar(50))
begin
	insert into gafetes(id_gafete, tipo_gafete, estado_gafete, direccion_de_visita, estado_de_vuelta) values
	(_id_gafete, _tipo_gafete, _estado_gafete, _direccion_de_visita, _estado_de_vuelta);
end //
delimiter ;
 
-- Listar
delimiter //
create procedure sp_listar_gafetes()
begin
	select id_gafete, tipo_gafete, estado_gafete,
	direccion_de_visita, estado_de_vuelta
	from gafetes;
end //
delimiter ;
 
-- Buscar
delimiter //
create procedure sp_buscar_gafetes(in _id_gafete int)
begin
	select id_gafete, tipo_gafete, estado_gafete,
	direccion_de_visita, estado_de_vuelta
	from gafetes
	where id_gafete = _id_gafete;
end //
delimiter ;
 
-- Actualizar
delimiter //
create procedure sp_actualizar_gafetes(
	in _id_gafete int ,
	in _tipo_gafete varchar(50) ,
	in _estado_gafete varchar(50) ,
	in _direccion_de_visita varchar(150) ,
	in _estado_de_vuelta varchar(50))
begin
	update gafetes
	set tipo_gafete = _tipo_gafete, estado_gafete = _estado_gafete,
	direccion_de_visita = _direccion_de_visita, estado_de_vuelta = _estado_de_vuelta
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
	in _marca varchar(50) ,
	in _color varchar(30))
begin
	insert into vehiculos(placa, tipo_vehiculo, marca, color) values
	(_placa, _tipo_vehiculo, _marca, _color);
end //
delimiter ;
 
-- Listar
delimiter //
create procedure sp_listar_vehiculos()
begin
	select placa, tipo_vehiculo, marca, color
	from vehiculos;
end //
delimiter ;
 
-- Buscar
delimiter //
create procedure sp_buscar_vehiculos(in _placa varchar(15))
begin
	select placa, tipo_vehiculo, marca, color
	from vehiculos
	where placa = _placa;
end //
delimiter ;
 
-- Actualizar
delimiter //
create procedure sp_actualizar_vehiculos(
	in _placa varchar(15) ,
	in _tipo_vehiculo varchar(50) ,
	in _marca varchar(50) ,
	in _color varchar(30))
begin
	update vehiculos
	set tipo_vehiculo = _tipo_vehiculo, marca = _marca, color = _color
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
	in _fecha_hora_entrada timestamp ,
	in _fecha_hora_salida timestamp ,
	in _motivo_visita varchar(150) ,
	in _nombre_alumno_relacionado varchar(100) ,
	in _grado_seccion_alumno varchar(50) ,
	in _id_visitante int ,
	in _id_secretario int ,
	in _id_area int ,
	in _id_gafete int ,
	in _placa varchar(15))
begin
	insert into visitas(id_visita, fecha_hora_entrada, fecha_hora_salida, motivo_visita, nombre_alumno_relacionado,
	grado_seccion_alumno, id_visitante, id_secretario, id_area, id_gafete, placa) values
	(_id_visita, _fecha_hora_entrada, _fecha_hora_salida, _motivo_visita, _nombre_alumno_relacionado,
	_grado_seccion_alumno, _id_visitante, _id_secretario, _id_area, _id_gafete, _placa);
end //
delimiter ;
 
-- Listar
delimiter //
create procedure sp_listar_visitas()
begin
	select VI.id_visita, VI.fecha_hora_entrada, VI.fecha_hora_salida, VI.motivo_visita,
	VI.nombre_alumno_relacionado, VI.grado_seccion_alumno,
	V.nombres, V.apellidos, V.tipo_visitante,
	S.nombres as nombre_secretario,
	A.nombre_area, A.sector_edificio,
	G.tipo_gafete, G.estado_de_vuelta,
	VH.placa, VH.marca, VH.color
	from visitas VI
	inner join visitantes V on VI.id_visitante = V.id_visitante
	inner join secretarios S on VI.id_secretario = S.id_secretario
	inner join areas A on VI.id_area = A.id_area
	inner join gafetes G on VI.id_gafete = G.id_gafete
	left join vehiculos VH on VI.placa = VH.placa;
end //
delimiter ;
 
-- Buscar
delimiter //
create procedure sp_buscar_visitas(in _id_visita int)
begin
	select VI.id_visita, VI.fecha_hora_entrada, VI.fecha_hora_salida, VI.motivo_visita,
	VI.nombre_alumno_relacionado, VI.grado_seccion_alumno,
	V.nombres, V.apellidos, V.tipo_visitante,
	S.nombres as nombre_secretario,
	A.nombre_area, A.sector_edificio,
	G.tipo_gafete, G.estado_de_vuelta,
	VH.placa, VH.marca, VH.color
	from visitas VI
	inner join visitantes V on VI.id_visitante = V.id_visitante
	inner join secretarios S on VI.id_secretario = S.id_secretario
	inner join areas A on VI.id_area = A.id_area
	inner join gafetes G on VI.id_gafete = G.id_gafete
	left join vehiculos VH on VI.placa = VH.placa
	where VI.id_visita = _id_visita;
end //
delimiter ;
 
-- Actualizar
delimiter //
create procedure sp_actualizar_visitas(
	in _id_visita int ,
	in _fecha_hora_entrada timestamp ,
	in _fecha_hora_salida timestamp ,
	in _motivo_visita varchar(150) ,
	in _nombre_alumno_relacionado varchar(100) ,
	in _grado_seccion_alumno varchar(50) ,
	in _id_visitante int ,
	in _id_secretario int ,
	in _id_area int ,
	in _id_gafete int ,
	in _placa varchar(15))
begin
	update visitas
	set fecha_hora_entrada = _fecha_hora_entrada, fecha_hora_salida = _fecha_hora_salida,
	motivo_visita = _motivo_visita, nombre_alumno_relacionado = _nombre_alumno_relacionado,
	grado_seccion_alumno = _grado_seccion_alumno, id_visitante = _id_visitante,
	id_secretario = _id_secretario, id_area = _id_area,
	id_gafete = _id_gafete, placa = _placa
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
 
-- View / Visitantes
create view vw_listar_visitantes as select id_visitante, nombres, apellidos,
	tipo_visitante, telefono_contacto
	from visitantes;
 
-- View / Secretarios
create view vw_listar_secretarios as select id_secretario, nombres, apellidos,
	cargo_puesto, correo_electronico, jornada_laboral
	from secretarios;
 
-- View / Areas
create view vw_listar_areas as select id_area, nombre_area, numero_salon_taller,
	sector_edificio, nivel_piso, carrera_tecnica_asignada
	from areas;
 
-- View / Gafetes
create view vw_listar_gafetes as select id_gafete, tipo_gafete, estado_gafete,
	direccion_de_visita, estado_de_vuelta
	from gafetes;
 
-- View / Vehiculos
create view vw_listar_vehiculos as select placa, tipo_vehiculo, marca, color
	from vehiculos;
 
-- View / Visitas
create view vw_listar_visitas as select VI.id_visita, VI.fecha_hora_entrada,
	VI.fecha_hora_salida, VI.motivo_visita,
	VI.nombre_alumno_relacionado, VI.grado_seccion_alumno,
	V.nombres, V.apellidos, V.tipo_visitante,
	S.nombres as nombre_secretario,
	A.nombre_area, A.sector_edificio,
	G.tipo_gafete, G.estado_de_vuelta,
	VH.placa, VH.marca, VH.color
	from visitas VI
	inner join visitantes V on VI.id_visitante = V.id_visitante
	inner join secretarios S on VI.id_secretario = S.id_secretario
	inner join areas A on VI.id_area = A.id_area
	inner join gafetes G on VI.id_gafete = G.id_gafete
	left join vehiculos VH on VI.placa = VH.placa;
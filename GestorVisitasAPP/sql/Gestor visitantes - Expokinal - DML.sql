-- Gestor de Visitante - Proyecto expokinal
use gestor_visitantes_in4cm;
 
-- Inserts con LLM - Visitantes
insert into visitantes(id_visitante, nombres, apellidos, tipo_visitante, telefono_contacto) values
(1,'Carlos Miguel','Méndez López','Padre de familia','55001001'),
(2,'María Mercedes','García Rodríguez','Padre de familia','55001002'),
(3,'Juan Pablo','Pérez Hernández','Exalumno','55001003'),
(4,'Ana Jimena','Martínez Gómez','Empresa externa','55001004'),
(5,'Pedro Daniel','López Reyes','Padre de familia','55001005'),
(6,'Lucía Fernanda','Hernández Castro','Empresa externa','55001006'),
(7,'Roberto Alejandro','Flores Díaz','Exalumno','55001007'),
(8,'Carmen Sofía','Sánchez Torres','Padre de familia','55001008'),
(9,'Miguel Ángel','Ramírez Vásquez','Empresa externa','55001009'),
(10,'Elena María','Torres Morales','Padre de familia','55001010');
 
-- Inserts con LLM - Secretarios
insert into secretarios(id_secretario, nombres, apellidos, cargo_puesto, correo_electronico, jornada_laboral) values
(1,'Ana Lucía','López Recinos','Secretaria de garita','ana.lopez@kinal.edu.gt','Matutina'),
(2,'Luisa Fernanda','Pérez Morales','Secretaria de garita','luisa.perez@kinal.edu.gt','Vespertina'),
(3,'Rosa Elena','García Fuentes','Secretaria de garita','rosa.garcia@kinal.edu.gt','Matutina'),
(4,'María José','Hernández Sic','Secretaria de garita','maria.hernandez@kinal.edu.gt','Vespertina'),
(5,'Carmen Sofía','Torres Ajú','Secretaria de garita','carmen.torres@kinal.edu.gt','Matutina'),
(6,'Iris Daniela','Coc Tzi','Auxiliar de garita','iris.coc@kinal.edu.gt','Matutina'),
(7,'Blanca Estela','Tzul Ixcot','Auxiliar de garita','blanca.tzul@kinal.edu.gt','Vespertina'),
(8,'Sandra Milena','Yat Caal','Secretaria de garita','sandra.yat@kinal.edu.gt','Matutina'),
(9,'Patricia Alejandra','Batz Ajú','Auxiliar de garita','patricia.batz@kinal.edu.gt','Vespertina'),
(10,'Diana Carolina','Cux Xol','Secretaria de garita','diana.cux@kinal.edu.gt','Matutina');
 
-- Inserts con LLM - Areas
insert into areas(id_area, nombre_area, numero_salon_taller, sector_edificio, nivel_piso, carrera_tecnica_asignada) values
(1,'Taller de Computación','C-01','H','Primer piso','Perito en Informática'),
(2,'Taller de Electrónica','C-02','H','Primer piso','Técnico en Electrónica'),
(3,'Taller de Mecánica','C-03','H','Planta baja','Técnico en Mecánica'),
(4,'Taller de Electricidad','C-04','H','Primer piso','Técnico en Electricidad'),
(5,'Laboratorio de Redes','C-05','H','Segundo piso','Perito en Informática'),
(6,'Biblioteca','C-06','C','Primer piso','General'),
(7,'Dirección','C-07','C','Primer piso','Administración'),
(8,'Secretaría General','C-08','C','Planta baja','Administración'),
(9,'Sala de Reuniones','C-09','C','Segundo piso','General'),
(10,'Taller de Soldadura','C-10','H','Planta baja','Técnico en Mecánica');
 
-- Inserts con LLM - Gafetes
insert into gafetes(id_gafete, tipo_gafete, estado_gafete, direccion_de_visita, estado_de_vuelta) values
(1,'Visitante general','Disponible','Edificio H - Taller de Computación','Devuelto'),
(2,'Proveedor','En uso','Edificio H - Taller de Mecánica','Pendiente'),
(3,'Padre de familia','Disponible','Edificio C - Dirección','Devuelto'),
(4,'Visitante general','En uso','Edificio C - Secretaría General','Pendiente'),
(5,'Empresa externa','Disponible','Edificio H - Laboratorio de Redes','Devuelto'),
(6,'Padre de familia','Disponible','Edificio C - Sala de Reuniones','Devuelto'),
(7,'Visitante general','En uso','Edificio H - Taller de Soldadura','Pendiente'),
(8,'Proveedor','Disponible','Edificio H - Taller de Electrónica','Devuelto'),
(9,'Empresa externa','En uso','Edificio C - Dirección','Pendiente'),
(10,'Padre de familia','Disponible','Edificio H - Taller de Computación','Devuelto');
 
-- Inserts con LLM - Vehiculos
insert into vehiculos(placa, tipo_vehiculo, marca, color) values
('P-001AAA','Sedan','Toyota','Blanco'),
('P-002BBB','SUV','Honda','Negro'),
('P-003CCC','Pickup','Nissan','Plata'),
('P-004DDD','Sedan','Chevrolet','Rojo'),
('P-005EEE','SUV','Mazda','Azul'),
('P-006FFF','Pickup','Hyundai','Gris'),
('P-007GGG','Motocicleta','Yamaha','Negro'),
('P-008HHH','Sedan','Volkswagen','Blanco'),
('P-009III','SUV','Kia','Verde'),
('P-010JJJ','Pickup','Ford','Gris');
 
-- Inserts con LLM - Visitas
insert into visitas(id_visita, fecha_hora_entrada, fecha_hora_salida, motivo_visita, nombre_alumno_relacionado, grado_seccion_alumno, id_visitante, id_secretario, id_area, id_gafete, placa) values
(1,'2025-01-06 07:45:00','2025-01-06 08:30:00','Reunión con tutor','Luis Alberto Méndez García','4to Informática A',1,1,1,1,'P-001AAA'),
(2,'2025-01-07 08:00:00','2025-01-07 09:00:00','Entrega de documentos','María Fernanda Torres Pérez','3ro Electrónica B',2,2,8,3,'P-002BBB'),
(3,'2025-01-08 09:15:00','2025-01-08 10:00:00','Trámite de título',NULL,NULL,3,3,7,5,NULL),
(4,'2025-01-09 10:00:00','2025-01-09 11:30:00','Capacitación técnica',NULL,NULL,4,4,5,9,'P-004DDD'),
(5,'2025-01-10 07:30:00','2025-01-10 08:15:00','Reunión de padres','Pedro Antonio López Sánchez','2do Mecánica A',5,5,9,6,'P-005EEE'),
(6,'2025-01-13 08:45:00','2025-01-13 09:30:00','Demostración de equipo',NULL,NULL,6,6,2,2,'P-006FFF'),
(7,'2025-01-14 09:00:00','2025-01-14 09:45:00','Actualización de datos',NULL,NULL,7,7,8,7,NULL),
(8,'2025-01-15 10:30:00','2025-01-15 11:00:00','Consulta sobre calificaciones','Carmen Lucía Flores Díaz','1ro Informática C',8,8,3,10,'P-008HHH'),
(9,'2025-01-16 11:00:00','2025-01-16 12:00:00','Visita institucional',NULL,NULL,9,9,4,9,'P-009III'),
(10,'2025-01-17 07:45:00','2025-01-17 08:20:00','Entrega de útiles','Elena Marisol Castillo Ruiz','3ro Electricidad A',10,10,6,3,NULL);
 
-- Llamar vistas
select * from vw_listar_visitantes;
select * from vw_listar_secretarios;
select * from vw_listar_areas;
select * from vw_listar_gafetes;
select * from vw_listar_vehiculos;
select * from vw_listar_visitas;
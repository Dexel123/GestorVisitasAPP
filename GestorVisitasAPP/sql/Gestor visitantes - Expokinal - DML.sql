-- Gestor de Visitante - Proyecto expokinal
use gestor_visitantes_in4cm;

-- Inserts con LLM - Visitantes
insert into visitantes(id_visitante, nombres, apellidos, tipo_visitante) values
(1,'Carlos Miguel','Méndez López','Padre de familia'),
(2,'María Mercedes','García Rodríguez','Padre de familia'),
(3,'Juan Pablo','Pérez Hernández','Exalumno'),
(4,'Ana Jimena','Martínez Gómez','Empresa externa'),
(5,'Pedro Daniel','López Reyes','Padre de familia'),
(6,'Lucía Fernanda','Hernández Castro','Empresa externa'),
(7,'Roberto Alejandro','Flores Díaz','Exalumno'),
(8,'Carmen Sofía','Sánchez Torres','Padre de familia'),
(9,'Miguel Ángel','Ramírez Vásquez','Empresa externa'),
(10,'Elena María','Torres Morales','Padre de familia');

-- Inserts con LLM - Secretarios
insert into secretarios(id_secretario, nombres, apellidos, cargo_puesto) values
(1,'Ana Lucía','López Recinos','Secretaria de garita'),
(2,'Luisa Fernanda','Pérez Morales','Secretaria de garita'),
(3,'Rosa Elena','García Fuentes','Secretaria de garita'),
(4,'María José','Hernández Sic','Secretaria de garita'),
(5,'Carmen Sofía','Torres Ajú','Secretaria de garita'),
(6,'Iris Daniela','Coc Tzi','Auxiliar de garita'),
(7,'Blanca Estela','Tzul Ixcot','Auxiliar de garita'),
(8,'Sandra Milena','Yat Caal','Secretaria de garita'),
(9,'Patricia Alejandra','Batz Ajú','Auxiliar de garita'),
(10,'Diana Carolina','Cux Xol','Secretaria de garita');

-- Inserts con LLM - Areas
insert into areas(id_area, nombre_area, carrera_tecnica_asignada) values
(1,'Taller de Computación','Perito en Informática'),
(2,'Taller de Electrónica','Técnico en Electrónica'),
(3,'Taller de Mecánica','Técnico en Mecánica'),
(4,'Taller de Electricidad','Técnico en Electricidad'),
(5,'Laboratorio de Redes','Perito en Informática'),
(6,'Biblioteca','General'),
(7,'Dirección','Administración'),
(8,'Secretaría General','Administración'),
(9,'Sala de Reuniones','General'),
(10,'Taller de Soldadura','Técnico en Mecánica');

-- Inserts con LLM - Gafetes
insert into gafetes(id_gafete, tipo_gafete, estado_gafete) values
(1,'Visitante general','Disponible'),
(2,'Proveedor','En uso'),
(3,'Padre de familia','Disponible'),
(4,'Visitante general','En uso'),
(5,'Empresa externa','Disponible'),
(6,'Padre de familia','Disponible'),
(7,'Visitante general','En uso'),
(8,'Proveedor','Disponible'),
(9,'Empresa externa','En uso'),
(10,'Padre de familia','Disponible');

-- Inserts con LLM - Vehiculos
insert into vehiculos(placa, tipo_vehiculo, color_vehiculo) values
('P-001AAA','Carro','Blanco'),
('P-002BBB','Carro','Negro'),
('P-003CCC','Carro','Plata'),
('P-004DDD','Carro','Rojo'),
('P-005EEE','Carro','Azul'),
('P-006FFF','Carro','Gris'),
('P-007GGG','Moto','Negro'),
('P-008HHH','Carro','Blanco'),
('P-009III','Carro','Verde'),
('P-010JJJ','Carro','Gris');

-- Inserts con LLM - Visitas
insert into visitas(id_visita, fecha_hora_entrada, fecha_hora_salida, motivo_visita, id_visitante, id_secretario, id_area, id_gafete, placa) values
(1,'2025-01-06 07:45:00','2025-01-06 08:30:00','Reunión con tutor',1,1,1,1,'P-001AAA'),
(2,'2025-01-07 08:00:00','2025-01-07 09:00:00','Entrega de documentos',2,2,8,3,'P-002BBB'),
(3,'2025-01-08 09:15:00','2025-01-08 10:00:00','Trámite de título',3,3,7,5,NULL),
(4,'2025-01-09 10:00:00','2025-01-09 11:30:00','Capacitación técnica',4,4,5,9,'P-004DDD'),
(5,'2025-01-10 07:30:00','2025-01-10 08:15:00','Reunión de padres',5,5,9,6,'P-005EEE'),
(6,'2025-01-13 08:45:00','2025-01-13 09:30:00','Demostración de equipo',6,6,2,2,'P-006FFF'),
(7,'2025-01-14 09:00:00','2025-01-14 09:45:00','Actualización de datos',7,7,8,7,NULL),
(8,'2025-01-15 10:30:00','2025-01-15 11:00:00','Consulta sobre calificaciones',8,8,3,10,'P-008HHH'),
(9,'2025-01-16 11:00:00','2025-01-16 12:00:00','Visita institucional',9,9,4,9,'P-009III'),
(10,'2025-01-17 07:45:00','2025-01-17 08:20:00','Entrega de útiles',10,10,6,3,NULL);

INSERT INTO Estado_De_Usuario
VALUES (1,'Pendiente'),
		(2,'Aceptada'),
		(3,'Baja');

						
INSERT INTO Tipo_Usuario
VALUES (1,'Administrador'),
		(2,'Corriente');
		
INSERT INTO Modo_Acceso
VALUES (1,'Publica'),
		(2,'Privada');
		
INSERT INTO Estado_De_Tarea
VALUES (1,'Pendiente'),
		(2,'Completa');
		
INSERT INTO Privilegio
VALUES (1,'Edicion'),
		(2,'Solo Lectura');
		
INSERT INTO Usuario(nombre,pass,id_estado_usuario,id_tipo_usuario)
VALUES('rodrigo','peperino',1,1),
		('cristian','ismael',2,2),
		('carlos','menem',1,1),
		('kari','kari',1,1);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 1',1,1,2);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 3',1,2,2);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 4',2,2,2);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 5',1,2,2);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 20',1,1,2);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 30',1,1,3);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 49',1,2,3);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 31',1,1,2);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 50',1,2,2);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 52',1,2,1);

INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario)
VALUES ('tarea nro 53',1,1,1);
--COMMIT;
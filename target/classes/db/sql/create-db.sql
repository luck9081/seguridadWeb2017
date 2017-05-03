/*DROP TABLE Usuario_Privilegio_Tarea IF EXISTS   ;
DROP TABLE Tarea IF EXISTS  ;
DROP TABLE Usuario IF EXISTS  ;
DROP TABLE Estado_De_Usuario IF EXISTS ;
DROP TABLE Tipo_Usuario IF EXISTS  ;
DROP TABLE Privilegio IF EXISTS  ;
DROP TABLE Modo_Acceso IF EXISTS  ;
DROP TABLE Estado_De_Tarea IF EXISTS  ;







CREATE TABLE Estado_De_Usuario (
  id_estado_usuario INTEGER PRIMARY KEY,
 descripcion 	VARCHAR(30)
);

CREATE TABLE Tipo_Usuario (
  id_tipo_usuario INTEGER PRIMARY KEY,
 descripcion 	VARCHAR(30)
);

CREATE TABLE Usuario (
  id_usuario 			INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  nombre 	VARCHAR(30),
  pass 		VARCHAR(30),
  id_estado_usuario INTEGER,
  id_tipo_usuario INTEGER,
  FOREIGN KEY(id_estado_usuario) REFERENCES Estado_De_Usuario(id_estado_usuario),
  FOREIGN KEY (id_tipo_usuario) REFERENCES Tipo_Usuario(id_tipo_usuario)
);

CREATE TABLE Privilegio(
	id_privilegio INTEGER PRIMARY KEY,
	descripcion VARCHAR(30)

);

CREATE TABLE Modo_Acceso(
	id_modo_acceso INTEGER PRIMARY KEY,
	descripcion VARCHAR(30)
);

CREATE TABLE Estado_De_Tarea(
	id_estado_tarea INTEGER PRIMARY KEY,
	descripcion VARCHAR(30)

);

CREATE TABLE Tarea(
	id_tarea INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	descripcion VARCHAR(30),
	id_modo_acceso INTEGER,
	id_estado_tarea INTEGER,
	id_usuario INTEGER,
	FOREIGN KEY(id_modo_acceso) REFERENCES Modo_Acceso(id_modo_acceso),
	FOREIGN KEY(id_estado_tarea) REFERENCES Estado_De_Tarea(id_estado_tarea),
	FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario)

);

CREATE TABLE Usuario_Privilegio_Tarea(
	id_usuario INTEGER,
	id_tarea INTEGER,
	id_privilegio INTEGER,
	PRIMARY KEY (id_usuario,id_tarea),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
	FOREIGN KEY (id_tarea) REFERENCES Tarea(id_tarea),
	FOREIGN KEY (id_privilegio) REFERENCES Privilegio(id_privilegio)
);*/
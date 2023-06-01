CREATE DATABASE Chess;
CREATE TABLE jugadores(NickName varchar(200) PRIMARY KEY, PartidasJugadas INT DEFAULT 0, Victorias INT DEFAULT 0, Derrotas INT DEFAULT 0, Tablas INT DEFAULT 0);
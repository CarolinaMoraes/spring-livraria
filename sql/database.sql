DROP DATABASE IF EXISTS livraria;

CREATE DATABASE livraria;

USE livraria;

CREATE TABLE usuario
(
	id BIGINT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    dt_nascimento DATE NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    senha VARCHAR(64) NOT NULL,
    
    PRIMARY KEY(id)
);

CREATE TABLE categoria
(
	id BIGINT UNSIGNED AUTO_INCREMENT,
    usuario_id BIGINT UNSIGNED NOT NULL,
    nome VARCHAR(50),
    
    UNIQUE INDEX(usuario_id, nome),
    
    PRIMARY KEY(id),
    
    FOREIGN KEY(usuario_id)
		REFERENCES usuario(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE livro
(
	id BIGINT UNSIGNED AUTO_INCREMENT,
    categoria_id BIGINT UNSIGNED NOT NULL,
    nome VARCHAR(50),
    
    UNIQUE INDEX(categoria_id, nome),
    
    PRIMARY KEY(id),
    
    FOREIGN KEY(categoria_id)
		REFERENCES categoria(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
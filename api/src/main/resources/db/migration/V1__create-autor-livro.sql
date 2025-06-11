CREATE TABLE autores (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    descricao TEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE livros (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    resumo TEXT,
    sumario TEXT,
    preco DECIMAL(10,2) NOT NULL,
    numero_paginas INT NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    data_publicacao DATE NOT NULL,
    autor_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autores(id)
);

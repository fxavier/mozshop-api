CREATE TABLE empresa (
    codigo BIGSERIAL,
    nome VARCHAR(80) NOT NULL,
    nuit VARCHAR(20) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    celular VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    avenida VARCHAR(20) NOT NULL,
    bairro VARCHAR(50) NOT NULL,   
    cidade VARCHAR(50) NOT NULL,
    PRIMARY KEY(codigo)
);
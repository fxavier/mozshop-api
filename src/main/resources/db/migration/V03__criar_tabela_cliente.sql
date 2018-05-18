CREATE TABLE cliente (
    codigo BIGSERIAL,
    nome VARCHAR(80) NOT NULL,
    tipo_cliente VARCHAR(20) NOT NULL,
    nuit VARCHAR(20) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    endereco TEXT NOT NULL,
    codigo_pais BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_cliente_pais
     FOREIGN KEY (codigo_pais) REFERENCES pais(codigo)
);
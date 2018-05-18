CREATE TABLE categoria (
    codigo BIGSERIAL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE pais (
    codigo BIGSERIAL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE fornecedor (
    codigo BIGSERIAL,
    nome VARCHAR(80) NOT NULL,
    pessoa_contacto VARCHAR(80),
    telefone VARCHAR(20) NOT NULL,
    cell VARCHAR(20),
    email VARCHAR(80) NOT NULL,
    codigo_pais BIGINT NOT NULL,
    endereco TEXT NOT NULL,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_fornecedor_pais
     FOREIGN KEY (codigo_pais) REFERENCES pais(codigo)
);


CREATE TABLE produto (
    codigo BIGSERIAL,
    sku VARCHAR(50) NOT NULL,
    nome VARCHAR(80) NOT NULL,
    descricao TEXT NOT NULL,
    codigo_barras VARCHAR(20),
    codigo_fabricante VARCHAR(20),
    valor_unitario DECIMAL(10, 2) NOT NULL,
    codigo_categoria BIGINT NOT NULL,
    codigo_fornecedor BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_produto_fornecedor
     FOREIGN KEY (codigo_fornecedor) REFERENCES fornecedor(codigo),
    CONSTRAINT fk_produto_categoria
     FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
);

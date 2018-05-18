CREATE TABLE entrada_stock (
    codigo BIGSERIAL,
    numero VARCHAR(45) NOT NULL,
    data_entrada DATE NOT NULL,
    quantidade BIGINT NOT NULL,
    tipo_entrada VARCHAR(20),
    codigo_produto BIGINT NOT NULL,
    codigo_usuario BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_produto_stock
      FOREIGN KEY (codigo_produto) REFERENCES produto(codigo),
    CONSTRAINT fk_stock_usuario
      FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
);


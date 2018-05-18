CREATE TABLE venda (
    codigo BIGSERIAL,
    data_criacao DATE NOT NULL,
    valor_frete DECIMAL(10,2),
    valor_desconto DECIMAL(10,2),
    valor_total DECIMAL(10,2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    observacao VARCHAR(200),
    data_hora_entrega DATE,
    codigo_cliente BIGINT NOT NULL,
    codigo_usuario BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_venda_cliente
       FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo),
    CONSTRAINT fk_venda_usuario
       FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
);

CREATE TABLE item_venda (
    codigo BIGSERIAL,
    quantidade INTEGER NOT NULL,
    valor_unitario DECIMAL(10,2) NOT NULL,
    codigo_produto BIGINT NOT NULL,
    codigo_venda BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_item_venda_produto
      FOREIGN KEY (codigo_produto) REFERENCES produto(codigo),
    CONSTRAINT fk_item_venda_venda
      FOREIGN KEY (codigo_venda) REFERENCES venda(codigo)
);
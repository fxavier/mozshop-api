CREATE TABLE recibo (
    codigo BIGSERIAL,
    numero_recibo VARCHAR(20) NOT NULL,
    data_recibo DATE,
    codigo_venda BIGINT NOT NULL,
    codigo_cliente BIGINT NOT NULL,
    codigo_empresa BIGINT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    valor_extenso TEXT,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_recibo_venda
      FOREIGN KEY (codigo_venda) REFERENCES venda(codigo),
    CONSTRAINT fk_recibo_cliente  
      FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo),
    CONSTRAINT fk_recibo_empresa
      FOREIGN KEY (codigo_empresa) REFERENCES empresa(codigo)
);

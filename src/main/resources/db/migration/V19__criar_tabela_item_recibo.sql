CREATE TABLE item_recibo (
    codigo BIGSERIAL,
    valor DECIMAL(10,2) NOT NULL,
    codigo_venda BIGINT NOT NULL,
    codigo_recibo BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    CONSTRAINT fk_item_recibo_venda
      FOREIGN KEY (codigo_venda) REFERENCES venda(codigo),
    CONSTRAINT fk_item_recibo_recibo
      FOREIGN KEY (codigo_recibo) REFERENCES recibo(codigo)
);
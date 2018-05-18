CREATE TABLE usuario(
codigo BIGSERIAL,
nome VARCHAR(100) NOT NULL,
email VARCHAR(150) NOT NULL,
password VARCHAR(150),
activo BOOLEAN NOT NULL DEFAULT true,
PRIMARY KEY(codigo)
);

CREATE TABLE permissao(
codigo BIGSERIAL,
descricao VARCHAR(100) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE usuario_permisso(
codigo_usuario BIGINT NOT NULL,
codigo_permissao BIGINT NOT NULL,
PRIMARY KEY(codigo_usuario, codigo_permissao),
CONSTRAINT fk_usuario_permissao_usuario
    FOREIGN KEY(codigo_usuario) REFERENCES usuario(codigo),
CONSTRAINT fk_usuario_permissao_permissao
    FOREIGN KEY(codigo_permissao) REFERENCES permissao(codigo)
);
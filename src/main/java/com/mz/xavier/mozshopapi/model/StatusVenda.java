package com.mz.xavier.mozshopapi.model;

public enum StatusVenda {

	COTACAO("cotação"),
    PROFORMA("Proforma"),
	EMITIDA("Emitida"), 
	CANCELADA("Cancelada");

	private String descricao;

	StatusVenda(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}

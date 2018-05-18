package com.mz.xavier.mozshopapi.model;

public enum TipoCliente {

	SINGULAR("Singular"),
	EMPRESA("Empresa");
		

	private String descricao;
	
	TipoCliente(String descricao) {
		this.descricao = descricao;
		
	}
		
	public String getDescricao() {
		return descricao;
	}

	

}

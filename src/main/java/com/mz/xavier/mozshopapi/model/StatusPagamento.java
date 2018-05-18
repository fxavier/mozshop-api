/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

/**
 * @author XNhagumbe
 *
 */
public enum StatusPagamento {
	
	PAGA("Paga"),
	PENDENTE("Pendente");
	
	private String descricao;
	
	StatusPagamento(String descricao){
		this.descricao = descricao;
	}

	
	public String getDescricao() {
		return descricao;
	}
	
	

}

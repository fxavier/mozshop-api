/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

/**
 * @author XNhagumbe
 *
 */
public enum TipoEntrada {
	
	COMPRA("Compra"),
	DEVOLUCAO("Devolução");
	
	private String descricao;
	
	TipoEntrada(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}

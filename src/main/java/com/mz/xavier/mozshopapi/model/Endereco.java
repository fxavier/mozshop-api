package com.mz.xavier.mozshopapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numero;
	
	private String bairro;
	
	@Column(name = "avenida", length = 500)
	private String avenida;
	
	private String cidade;
	
	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getAvenida() {
		return avenida;
	}

	public void setAvenida(String avenida) {
		this.avenida = avenida;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

		
	
}

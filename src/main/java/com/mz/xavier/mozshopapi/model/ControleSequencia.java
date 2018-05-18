/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author XNhagumbe
 *
 */
@Entity
@Table(name = "controle_sequencia")
public class ControleSequencia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo = "seq";
	
	@Column(name = "numero_factura")
	private Long numeroFactura = 0L;
	
	@Column(name = "numero_cotacao")
	private Long numeroCotacao = 0L;
	
	@Column(name = "numero_entrada")
	private Long numeroEntrada = 0L;
	
	@Column(name = "numero_proforma")
	private Long numeroProforma = 0L;
	
	private LocalDateTime ano;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Long getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Long getNumeroCotacao() {
		return numeroCotacao;
	}

	public void setNumeroCotacao(Long numeroCotacao) {
		this.numeroCotacao = numeroCotacao;
	}

	public Long getNumeroEntrada() {
		return numeroEntrada;
	}

	public void setNumeroEntrada(Long numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}

	public LocalDateTime getAno() {
		return ano;
	}

	public void setAno(LocalDateTime ano) {
		this.ano = ano;
	}

	public Long getNumeroProforma() {
		return numeroProforma;
	}

	public void setNumeroProforma(Long numeroProforma) {
		this.numeroProforma = numeroProforma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControleSequencia other = (ControleSequencia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}

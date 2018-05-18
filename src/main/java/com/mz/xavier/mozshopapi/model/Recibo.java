/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author XNhagumbe
 *
 */
@Entity
@Table(name = "recibo")
public class Recibo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "numero_recibo")
	private String numeroRecibo;
	
	private BigDecimal valor;
	
	@Column(name = "valor_extenso")
	private String valorExtenso;
	
	@Column(name = "data_recibo")
	private LocalDate dataRecibo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_venda")
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "codigo_empresa")
	private Empresa empresa;

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the numeroRecibo
	 */
	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	/**
	 * @param numeroRecibo the numeroRecibo to set
	 */
	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the valorExtenso
	 */
	public String getValorExtenso() {
		return valorExtenso;
	}

	/**
	 * @param valorExtenso the valorExtenso to set
	 */
	public void setValorExtenso(String valorExtenso) {
		this.valorExtenso = valorExtenso;
	}

	/**
	 * @return the dataRecibo
	 */
	public LocalDate getDataRecibo() {
		return dataRecibo;
	}

	/**
	 * @param dataRecibo the dataRecibo to set
	 */
	public void setDataRecibo(LocalDate dataRecibo) {
		this.dataRecibo = dataRecibo;
	}

	/**
	 * @return the venda
	 */
	public Venda getVenda() {
		return venda;
	}

	/**
	 * @param venda the venda to set
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		Recibo other = (Recibo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}

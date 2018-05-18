/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "item_recibo")
public class ItemRecibo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_venda")
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name = "codigo_recibo")
	private Recibo recibo;

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
	 * @return the valorTotal
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
	 * @return the recibo
	 */
	public Recibo getRecibo() {
		return recibo;
	}

	/**
	 * @param recibo the recibo to set
	 */
	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
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
		ItemRecibo other = (ItemRecibo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}

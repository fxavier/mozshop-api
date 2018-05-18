/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author XNhagumbe
 *
 */
@Entity
@Table(name = "entrada_stock")
public class EntradaStock implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String numero = "1";
	
	@Column(name = "data_entrada")
	private LocalDateTime dataEntrada;
	
	@NotNull(message = "O valor é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	private Integer quantidade;
	
	@NotNull( message = "O preco de compra é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "preco_compra", nullable = false, precision = 10, scale = 2)
	private BigDecimal precoCompra;
	
	@NotNull(message= "O Tipo de entrada é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_entrada")
	private TipoEntrada tipoEntrada;
	
	@ManyToOne
	@JoinColumn(name = "codigo_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public TipoEntrada getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(TipoEntrada tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
	
	/**
	 * @return the precoCompra
	 */
	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	/**
	 * @param precoCompra the precoCompra to set
	 */
	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}

	public boolean isNova(){
		return this.codigo == null;
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
		EntradaStock other = (EntradaStock) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}

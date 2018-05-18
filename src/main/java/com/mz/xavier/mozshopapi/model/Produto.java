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
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.StringUtils;

import com.mz.xavier.mozshopapi.validation.SKU;


@Entity
@Table(name="produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@NotBlank(message = "O SKU é obrigatório")
	@SKU
	@Column(nullable = false, length = 20, unique = true)
	private String sku;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 80)
	@Column(nullable = false, length = 80)
	private String nome;
	
	@NotBlank(message = "A descrição é obrigatória")
	private String descricao;
	
	@Column(name="codigo_barras", length = 20)
	private String codigoBarras;
	
	@Column(name="codigo_fabricante", length = 20)
	private String codigoFabricante;
	
	@NotNull(message = "O preco de compra é obrigatório")
	@Column(name="preco_compra", nullable = false, precision = 10, scale = 2)
	private BigDecimal precoCompra;
	
	@NotNull(message = "O valor é obrigatório")
	@Column(name="valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal iva = BigDecimal.ZERO;
	
	@Column(name="preco_com_iva", nullable = false, precision = 10, scale = 2)
	private BigDecimal precoComIva = BigDecimal.ZERO;	
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal lucro = BigDecimal.ZERO;
	
	@Column(name = "data_validade")
	private LocalDate dataValidade;

	@NotNull(message = "O Stock é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name="quantidade_estoque", nullable = false, length = 5)
	private Integer quantidadeEstoque;
	
	@NotNull(message = "A categoria é obrigatória")
	@ManyToOne
	@JoinColumn(name = "codigo_categoria", nullable = false)
	private Categoria categoria;
	
    	
    @NotNull(message = "O Fornecedor é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_fornecedor")
	private Fornecedor fornecedor;
	
	private String foto;
	
	@Column(name = "content_type")
	private String contentType;
	
	@Transient
	private boolean novaFoto;	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.toUpperCase();
	}		
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	/**
	 * @return the codigoBarras
	 */
	

	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * @return the codigoFabricante
	 */
	
	
	public String getCodigoFabricante() {
		return codigoFabricante;
	}

	/**
	 * @param codigoFabricante the codigoFabricante to set
	 */
	public void setCodigoFabricante(String codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}

		
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

		

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
		
	/**
	 * @return the fornecedor
	 */
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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

	/**
	 * @return the iva
	 */
	public BigDecimal getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	/**
	 * @return the precoComIva
	 */
	public BigDecimal getPrecoComIva() {
		return precoComIva;
	}

	/**
	 * @param precoComIva the precoComIva to set
	 */
	public void setPrecoComIva(BigDecimal precoComIva) {
		this.precoComIva = precoComIva;
	}

	/**
	 * @return the lucro
	 */
	public BigDecimal getLucro() {
		return lucro;
	}

	/**
	 * @param lucro the lucro to set
	 */
	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	/**
	 * @return the dataValidade
	 */
	public LocalDate getDataValidade() {
		return dataValidade;
	}

	/**
	 * @param dataValidade the dataValidade to set
	 */
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String temFotoOuMock(){
		return !StringUtils.isEmpty(foto) ? foto : "no_image.png";
	}
	
	
	public boolean isNovo(){
		return codigo == null;
	}	
    
	@Transient
	public boolean isNovaFoto() {
		return novaFoto;
	}

	public void setNovaFoto(boolean novaFoto) {
		this.novaFoto = novaFoto;
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	/*public void baixarEstoque(Integer quantidade) {
		int novaQuantidade = this.getQuantidadeEstoque() - quantidade;
		
		if (novaQuantidade < 0) {
			throw new NegocioException("Não há disponibilidade no estoque de "
					+ quantidade + " itens do produto " + this.getSku() + ".");
		}
		
		this.setQuantidadeEstoque(novaQuantidade);
	}
*/
	

}
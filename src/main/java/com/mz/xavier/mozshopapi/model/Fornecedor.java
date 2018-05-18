/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;



/**
 * @author XNhagumbe
 *
 */
@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@Column(name = "pessoa_contacto")
	private String pessoaContacto;	
	
	@NotBlank(message = "O telefone é obrigatório")
	private String telefone;	
	
	private String cell;
	
	@NotBlank(message = "O email é obrgatório") 
	@Email(message = "O email é inválido")
	private String email;
	
	@NotNull(message = "O país é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_pais")
	private Pais pais;
	
	private String endereco;
	
	
	/**
	 * @return the codigo
	 */
	
	public Long getCodigo() {
		return codigo;
	}
	/**
	 * @param 
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nome
	 */
	
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the pessoaContacto
	 */
	
	public String getPessoaContacto() {
		return pessoaContacto;
	}
	/**
	 * @param pessoaContacto the pessoaContacto to set
	 */
	public void setPessoaContacto(String pessoaContacto) {
		this.pessoaContacto = pessoaContacto;
	}
	/**
	 * @return the telefone
	 */
	
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the cell
	 */

	public String getCell() {
		return cell;
	}
	/**
	 * @param cell the cell to set
	 */
	public void setCell(String cell) {
		this.cell = cell;
	}
	/**
	 * @return the email
	 */

	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pais
	 */
	
	public Pais getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	/**
	 * @return the endereco
	 */
	
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		Fornecedor other = (Fornecedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}

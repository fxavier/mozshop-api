/**
 * 
 */
package com.mz.xavier.mozshopapi.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author XNhagumbe
 *
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo = 1L;
	
	@NotBlank(message = "O Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O NUIT é obrigatório")
	private String nuit;
	
	@NotBlank(message = "O Telefone é obrigatório")
	private String telefone;
	
	private String celular;
	
	private String banco;
	
	private String conta;
	
	private String nib;
	
	@NotBlank(message = "O e-mail é obrigatório")
	@Email(message = "E-mail inválido")
	private String email;
	
	@JsonIgnore
	@Embedded
	private Endereco endereco;
	
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
	public String getNuit() {
		return nuit;
	}
	public void setNuit(String nuit) {
		this.nuit = nuit;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the banco
	 */
	public String getBanco() {
		return banco;
	}
	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}
	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}
	/**
	 * @param conta the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}
	/**
	 * @return the nib
	 */
	public String getNib() {
		return nib;
	}
	/**
	 * @param nib the nib to set
	 */
	public void setNib(String nib) {
		this.nib = nib;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}

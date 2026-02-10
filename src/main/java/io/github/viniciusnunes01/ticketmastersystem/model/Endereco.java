package io.github.viniciusnunes01.ticketmastersystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;

	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	public Endereco() {

	}

	public Endereco(String logradouro, String numero, String bairro, String cep, String complemento, Cidade cidade) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep.replace("-", "");
		if (this.cep.length() != 8) {
			throw new IllegalArgumentException("O CEP deve conter 8 dígitos.");
		}
		this.complemento = complemento;

		if (cidade == null) {
			throw new IllegalArgumentException("É necessário uma cidade para esse endereço");
		}
		this.cidade = cidade;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}

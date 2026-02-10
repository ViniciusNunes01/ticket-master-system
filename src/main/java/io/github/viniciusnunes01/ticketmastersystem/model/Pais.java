package io.github.viniciusnunes01.ticketmastersystem.model;

public class Pais {

	private Integer idPais;
	private String nome;
	private String sigla;

	public Pais(String nome, String sigla) {
		super();
		this.nome = nome;

		if (sigla == null || sigla.length() != 2) {
			throw new IllegalArgumentException("A sigla do país deve ter exatamente 2 caracteres");
		}

		this.sigla = sigla.toUpperCase();
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla.toUpperCase();
	}

}

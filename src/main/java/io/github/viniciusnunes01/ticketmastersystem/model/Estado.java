package io.github.viniciusnunes01.ticketmastersystem.model;

public class Estado {

	private Integer idEstado;
	private String nome;
	private String sigla;
	private Pais pais;

	public Estado(String nome, String sigla, Pais pais) {
		super();
		this.nome = nome;
		
		if(sigla == null || sigla.length() != 2) {
			throw new IllegalArgumentException("A sigla do estado deve ter exatamente 2 caracteres");
		}
		
		this.sigla = sigla.toUpperCase();
		
		if(pais == null) {
			throw new IllegalArgumentException("É necessário um país para esse Estado");
		}
		
		this.pais = pais;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}

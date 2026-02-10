package io.github.viniciusnunes01.ticketmastersystem.model;

public class Cidade {

	private Integer idCidade;
	private String nome;
	private Estado estado;

	public Cidade(String nome, Estado estado, Estado _siglaEstado) {
		super();
		this.nome = nome;

		if (estado == null) {
			throw new IllegalArgumentException("É preciso um estado válido para a cidade");
		}
		this.estado = estado;
	}

	public String getNomeComEstado() {
		return this.nome + " - " + this.estado.getSigla();
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}

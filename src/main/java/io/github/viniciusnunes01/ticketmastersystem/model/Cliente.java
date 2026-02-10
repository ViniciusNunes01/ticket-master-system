package io.github.viniciusnunes01.ticketmastersystem.model;

import java.time.LocalDate;

public class Cliente {

	private Integer idCliente;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	private String email;
	private Endereco endereco;

	public Cliente(String cpf, LocalDate dataNascimento, String telefone, String email, Endereco endereco) {
		super();
		this.cpf = cpf;

		if (dataNascimento.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("A data de nascimento não pode ser futura.");
		}
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;

		if (endereco == null) {
			throw new IllegalArgumentException("É necessário um endereço para o cliente");
		}
		this.endereco = endereco;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

}

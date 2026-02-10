package io.github.viniciusnunes01.ticketmastersystem.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvento;

	private String nome;
	private LocalDateTime data;
	private Integer capacidadeMaxima;
	private Integer ingressosRestantes;
	private BigDecimal precoBase;

	public Evento() {

	}

	public Evento(String nome, LocalDateTime data, Integer capacidadeMaxima, BigDecimal precoBase) {
		super();
		this.nome = nome;
		this.data = data;
		this.capacidadeMaxima = capacidadeMaxima;
		this.precoBase = precoBase;
		this.ingressosRestantes = capacidadeMaxima;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Integer getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(Integer capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public Integer getIngressosRestantes() {
		return ingressosRestantes;
	}

	public void setIngressosRestantes(Integer ingressosRestantes) {
		this.ingressosRestantes = ingressosRestantes;
	}

	public BigDecimal getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}

}
